package producer.eureka.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import producer.eureka.model.Teacher;
import producer.eureka.model.TeacherPhone;
import producer.eureka.repository.TeacherPhoneRepository;
import producer.eureka.services.TeacherPhoneService;

import java.util.List;

@Service
public class TeacherPhoneServiceImpl implements TeacherPhoneService {

    @Autowired
    TeacherPhoneRepository teacherPhoneRepository;

    @Override
    public List<TeacherPhone> findByTeacher(Teacher teacher) {
        return teacherPhoneRepository.findByTeacher(teacher);
    }
}
