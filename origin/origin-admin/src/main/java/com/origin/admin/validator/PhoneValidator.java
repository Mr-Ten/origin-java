package com.origin.admin.validator;

import com.origin.admin.annotation.Phone;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 * <pre>
 * 手机校验器
 * </pre>
 *
 * @author: tenglei
 * @date: 2021/11/10 14:00
 */
public class PhoneValidator implements ConstraintValidator<Phone, String> {
    private static final String REGEXP_PHONE = "^0?(13[0-9]|14[5-9]|15[012356789]|166|17[0-8]|18[0-9]|19[89])[0-9]{8}$";
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (Objects.isNull(value)){
            return true;
        }
        return Pattern.matches(REGEXP_PHONE, value);
    }
}
