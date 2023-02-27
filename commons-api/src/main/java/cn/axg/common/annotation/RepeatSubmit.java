package cn.axg.common.annotation;

import java.lang.annotation.*;

/**
 * 自定义注解防表单重复提交
 *
 * @author zengshiy11
 * @since 2022/6/10 9:35
 */
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RepeatSubmit {


}
