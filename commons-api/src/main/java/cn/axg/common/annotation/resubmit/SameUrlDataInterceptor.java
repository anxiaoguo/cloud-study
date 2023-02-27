package cn.axg.common.annotation.resubmit;

import cn.axg.common.interceptor.RepeatSubmitInterceptor;
import cn.axg.common.service.RedisService;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 判断请求url和数据是否和上一次相同，
 * 如果和上次相同，则是重复提交表单。 有效时间为5秒
 *
 * @author zengshiy11
 * @since 2022/6/10 10:00
 */
@Component
public class SameUrlDataInterceptor extends RepeatSubmitInterceptor {
    public static final String REPEAT_SUBMIT_KEY = "repeat_submit:";
    public final String REPEAT_PARAMS = "repeatParams";
    public final String REPEAT_TIME = "repeatTime";
    // 令牌自定义标识
    @Value("${token.header:Authorization}")
    private String header;

    @Resource
    private RedisService redisService;

    /**
     * 间隔时间，单位:秒 默认5秒
     * <p>
     * 两次相同参数的请求，如果间隔时间大于该参数，系统不会认定为重复提交的数据
     */
    @Value("${token.intervalTime:5}")
    private int intervalTime;

    @SuppressWarnings("unchecked")
    @Override
    public boolean isRepeatSubmit(HttpServletRequest request) {
        String nowParams = "";
        if (request instanceof RepeatedlyRequestWrapper) {
            RepeatedlyRequestWrapper repeatedlyRequest = (RepeatedlyRequestWrapper) request;
            nowParams = RepeatedlyRequestWrapper.getBodyString(repeatedlyRequest);
        }

        // body参数为空，获取Parameter的数据
        if (StrUtil.isBlank(nowParams)) {
            nowParams = JSONObject.toJSONString(request.getParameterMap());
        }
        Map<String, Object> nowDataMap = new HashMap<>(16);
        nowDataMap.put(REPEAT_PARAMS, nowParams);
        nowDataMap.put(REPEAT_TIME, System.currentTimeMillis());

        // 请求地址（作为存放cache的key值）
        String url = request.getRequestURI();

        // 唯一值（没有消息头则使用请求地址）
        String submitKey = request.getHeader(header);
        if (StrUtil.isBlank(submitKey)) {
            submitKey = url;
        }

        // 唯一标识（指定key + 消息头）
        String CACHE_REPEAT_KEY = REPEAT_SUBMIT_KEY + submitKey;

        Object sessionObj = redisService.get(CACHE_REPEAT_KEY);
        if (sessionObj != null) {
            Map<String, Object> sessionMap = (Map<String, Object>) sessionObj;
            if (sessionMap.containsKey(url)) {
                Map<String, Object> preDataMap = (Map<String, Object>) sessionMap.get(url);
                if (compareParams(nowDataMap, preDataMap) && compareTime(nowDataMap, preDataMap)) {
                    return true;
                }
            }
        }
        Map<String, Object> cacheMap = new HashMap<String, Object>();
        cacheMap.put(url, nowDataMap);
        redisService.set(CACHE_REPEAT_KEY, cacheMap, intervalTime);
        return false;
    }

    /**
     * 判断参数是否相同
     */
    private boolean compareParams(Map<String, Object> nowMap, Map<String, Object> preMap) {
        String nowParams = (String) nowMap.get(REPEAT_PARAMS);
        String preParams = (String) preMap.get(REPEAT_PARAMS);
        return nowParams.equals(preParams);
    }

    /**
     * 判断两次间隔时间
     */
    private boolean compareTime(Map<String, Object> nowMap, Map<String, Object> preMap) {
        long time1 = (Long) nowMap.get(REPEAT_TIME);
        long time2 = (Long) preMap.get(REPEAT_TIME);
        if ((time1 - time2) < (this.intervalTime * 1000)) {
            return true;
        }
        return false;
    }
}
