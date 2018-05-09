package td.learn.spring.v1.annotation;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TdAutoWried {
    String value() default "";
}
