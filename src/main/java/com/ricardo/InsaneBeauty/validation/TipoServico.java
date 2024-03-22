package com.ricardo.InsaneBeauty.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target(FIELD)
@Constraint(validatedBy = TipoServicoValidator.class)
@Retention(RUNTIME)
public @interface TipoServico {

    String message() default "Tipo de serviço inválido. Oferecemos serviços de: manicure, pedicure, depilação e corte de cabelo.";

    Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

}
