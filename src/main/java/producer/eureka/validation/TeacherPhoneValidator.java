package producer.eureka.validation;

import org.springframework.beans.factory.annotation.Autowired;
import producer.eureka.model.TeacherPhone;
import producer.eureka.repository.TeacherPhoneRepository;
import producer.eureka.validation.annotation.CheckTeacherPhone;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class TeacherPhoneValidator implements ConstraintValidator<CheckTeacherPhone,String> {

    @Autowired
    TeacherPhoneRepository teacherPhoneRepository;

    @Override
    public void initialize(CheckTeacherPhone constraintAnnotation) {
    }

    @Override
    public boolean isValid(String phone, ConstraintValidatorContext context) {
//        System.out.println(phone);
//        TeacherPhone teacherPhone = teacherPhoneRepository.findByPhoneNumber(phone);
//        if (teacherPhone != null){
//            return false;
//        }
//        else {
            return phone != null && phone.matches("[0-9]+")
                    && (phone.length() > 9) && (phone.length() < 13);
//        }
    }
}
