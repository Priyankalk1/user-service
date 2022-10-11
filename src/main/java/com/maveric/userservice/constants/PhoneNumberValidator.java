package com.maveric.userservice.constants;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {
    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext constraintValidatorContext) {
        return phoneNumber != null &&
                phoneNumber.matches("[0-9]+") &&
                phoneNumber.length() ==10;
                //&&
                //phoneNumber.length() < 14;
    }
}
