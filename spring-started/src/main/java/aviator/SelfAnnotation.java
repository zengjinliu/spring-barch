package aviator;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * TODO
 *
 * @Annotation SelfAnnotation
 * @Author LiuZJ
 * @Date 2019/7/12 16:14
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface SelfAnnotation {
    /**
     * 自定义函数名称,同时也是spring bean 的名称
     * @return
     */
    String value() default "";

    /**
     * 详细说明该表达式的用法，返回值，变量，逻辑要点。
     * @return
     */
    String description() default "";
}
