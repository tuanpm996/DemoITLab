package producer.eureka.repository;

import org.springframework.data.repository.CrudRepository;
import producer.eureka.model.TeacherLevel;

public interface TeacherLevelRepository extends CrudRepository<TeacherLevel, Integer> {
}
