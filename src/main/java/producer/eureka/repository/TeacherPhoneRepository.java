package producer.eureka.repository;

import org.springframework.data.repository.CrudRepository;
import producer.eureka.model.TeacherPhone;

public interface TeacherPhoneRepository extends CrudRepository<TeacherPhone, Long> {
}
