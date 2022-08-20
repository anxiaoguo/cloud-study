package cn.axg.study.redis.springboot;

import lombok.Getter;
import lombok.Setter;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * Author：SDY
 * Description：短信类型枚举
 * Date：Create in 2019/3/27 15:02
 * Modified By：
 * Reason：
 */
public enum SmsTemplateCodeEnum {


    LOGIN(1, "达人登陆短信模板", "SMS_18670507"),
    REGISTER(2, "达人注册短信模板", "SMS_18670507"),
    APP_LOGIN(3, "APP达人登陆短信模板", "SMS_18670507"),
    BIND_PHONE(4, "主播绑定手机号短信模板", "SMS_18670507"),

    BINDING_ALIPAY(7, "商户绑定支付宝模板", "SMS_18670507"),
    WITHDRAW(8, "商户提现模板", "SMS_18670507"),
    SHOP_LOGIN(10, "商户登陆短信模板", "SMS_18670507"),
    SHOP_REGISTER(11, "商户注册短信模板", "SMS_18670507"),
    UPDATE_PHONE(12, "反馈回执", "SMS_200714052"),
    SHOP_SUB_ACCOUNT_PASSWORD(15, "商家子账户", "SMS_198920068"),
    HOT_SOLD_OUT_PUSH(17, "暂无爆款推送", "SMS_200186703"),
    FEEDBACK_RECEIPT(18, "反馈回执", "SMS_200714052");

    @Getter
    @Setter
    private Integer index;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String template;

    SmsTemplateCodeEnum(Integer index, String name, String template) {
        this.name = name;
        this.index = index;
        this.template = template;
    }


    public static SmsTemplateCodeEnum getTemplateByIndex(Integer index) {
        Optional<SmsTemplateCodeEnum> first = Stream.of(values().clone())
                .filter(statusEnum -> statusEnum.index.equals(index))
                .findFirst();
        return first.orElse(null);
    }
}

