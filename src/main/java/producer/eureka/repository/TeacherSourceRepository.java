package producer.eureka.repository;

import org.springframework.data.repository.CrudRepository;
import producer.eureka.model.TeacherSource;

public interface TeacherSourceRepository extends CrudRepository<TeacherSource,Integer> {
}
