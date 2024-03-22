package com.ricardo.InsaneBeauty.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TipoServicoValidator implements ConstraintValidator<TipoServico, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.equals("manicure") || value.equals("pedicure") || value.equals("depilação") || value.equals("corte de cabelo");
    }

}