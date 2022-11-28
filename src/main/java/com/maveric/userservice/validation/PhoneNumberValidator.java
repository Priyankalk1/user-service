package com.maveric.userservice.validation;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {
    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext constraintValidatorContext) {
        return phoneNumber != null &&
                phoneNumber.matches("\\d+") &&
                phoneNumber.length() ==10;
    }
}
