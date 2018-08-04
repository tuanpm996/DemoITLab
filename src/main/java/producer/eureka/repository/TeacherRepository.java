package producer.eureka.repository;

import org.springframework.data.repository.CrudRepository;
import producer.eureka.model.Teacher;

public interface TeacherRepository extends CrudRepository<Teacher, Long> {

}
