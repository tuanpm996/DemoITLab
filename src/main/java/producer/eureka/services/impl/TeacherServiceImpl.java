package producer.eureka.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import producer.eureka.model.Teacher;
import producer.eureka.repository.TeacherRepository;
import producer.eureka.services.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    public Teacher save(Teacher teacher) {
        return teacherRepository.save(teacher);
    }
}
