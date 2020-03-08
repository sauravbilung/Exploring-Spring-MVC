package com.psl.util;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/*@Documented
@Constraint(validatedBy = BranchValidator.class)
@Target( {ElementType.FIELD} )
@Retention(RetentionPolicy.RUNTIME)*/
public @interface IsValidBranch {
   String message() default "Please provide a valid branch name: "+ "accepted branches are CSE and IT (Choose anyone)";
   
   Class<?>[] groups() default {};
   Class<? extends Payload>[] payload() default {};
}
