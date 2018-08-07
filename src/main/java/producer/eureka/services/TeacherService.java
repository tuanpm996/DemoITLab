package producer.eureka.services;

import org.springframework.data.jpa.domain.Specification;
import producer.eureka.model.Teacher;

public interface TeacherService {
    public Teacher save(Teacher teacher);

    public Iterable<Teacher> findAll();


    public Iterable<Teacher> findAll(Specification specification, int page, int size);

    Teacher search(int id);

    Teacher update(int id, Teacher teacher);

    void delete(int id);


}
