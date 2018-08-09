package producer.eureka.services;

import producer.eureka.model.Teacher;
import producer.eureka.model.TeacherPhone;

import java.util.List;

public interface TeacherPhoneService {

    List<TeacherPhone> findByTeacher(Teacher teacher);
}
