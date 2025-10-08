package com.shashank.SpringBootEverything.customannotation;

import jakarta.validation.Constraint;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueUsernameValidator.class)
@Target(value = ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueUsername {
}
