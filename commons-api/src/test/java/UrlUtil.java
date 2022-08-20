import cn.hutool.core.util.StrUtil;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * program: 51DaiHuoServer
 * Author：马慧彪
 * Description：
 * Date：Create in 2021-02-25 15:27
 * Modified By：
 * Reason：
 */
public class UrlUtil {

    /**
     * 去掉url中的路径，留下请求参数部分
     *
     * @param url url地址
     * @return url请求参数部分
     */
    private static String urlToQuery(String url) {
        int index = url.indexOf("?");
        if (index < 0) {
            return "";
        }
        return url.substring(index + 1);
    }

    /**
     * 解析出url参数中的键值对
     * 如 "index.jsp?Action=del&id=123"，解析出Action:del,id:123存入map中
     * 取出后参数不区分大小写
     *
     * @param url url地址
     * @return url请求参数部分
     */
    public static Map<String, String> mapUrlQuery(String url) {
        String query = urlToQuery(url);
        if (StringUtils.isEmpty(query)) {
            return null;
        }
        return Arrays.stream(query.split("&"))
            .filter(s -> !s.endsWith("="))
            .map(s -> s.split("="))
            .collect(Collectors.toMap(s -> s[0], s -> s[1]));
    }

    /**
     * 取出后参数区分大小写
     *
     * @param url url
     * @param name 参数名称
     * @return 参数值
     */
    public static String getParam(String url, String name) {
        String query = urlToQuery(url);
        if (StrUtil.isBlank(query)) {
            return null;
        }
        return Arrays.stream(query.split("&"))
            .filter(s -> s.startsWith(name+"="))
            .map(s -> s.endsWith("=") ? "" : s.split("=")[1])
            .findFirst().orElse(null);
    }


}
