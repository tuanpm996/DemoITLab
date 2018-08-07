package producer.eureka.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import producer.eureka.model.Teacher;
import producer.eureka.model.TeacherPhone;

import java.util.List;

public interface TeacherPhoneRepository extends CrudRepository<TeacherPhone, Integer> {
    @Query(name = "SELECT p FROM TeacherPhone p WHERE p.teacher = :teacher")
    List<TeacherPhone> findByTeacher(@Param("teacher") Teacher teacher);
}
