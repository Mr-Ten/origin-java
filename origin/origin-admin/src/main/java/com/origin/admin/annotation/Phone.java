package com.origin.admin.annotation;

import com.origin.admin.validator.PhoneValidator;
import org.hibernate.validator.constraints.Length;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * <pre>
 *
 * </pre>
 *
 * @author: tenglei
 * @date: 2021/11/10 13:06
 */
@Documented
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Constraint(validatedBy = {PhoneValidator.class})
@Length(min = 11, max = 11)
public @interface Phone {

    String message() default "手机号码格式不合法";
    //分组
    Class<?>[] groups() default {};
    //
    Class<? extends Payload>[] payload() default {};
}
