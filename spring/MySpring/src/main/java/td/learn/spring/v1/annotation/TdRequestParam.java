package td.learn.spring.v1.annotation;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TdRequestParam {
    String value() default "";
}
