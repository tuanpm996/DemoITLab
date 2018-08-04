package producer.eureka.repository;

import org.springframework.data.repository.CrudRepository;
import producer.eureka.model.TeacherEmail;

public interface TeacherEmailRepository extends CrudRepository<TeacherEmail, Long> {
}
