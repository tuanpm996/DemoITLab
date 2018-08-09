package producer.eureka.services;

import producer.eureka.model.Teacher;

public interface TeacherService {
    Teacher save(Teacher teacher);

    Teacher search(int id);

    Teacher update(int id, Teacher teacher);

    void delete(int id);
}
