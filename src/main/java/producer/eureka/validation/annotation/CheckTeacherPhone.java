package producer.eureka.validation.annotation;

import producer.eureka.validation.TeacherPhoneValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = TeacherPhoneValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckTeacherPhone {
    String message() default "so dien thoai sai dinh dang";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
