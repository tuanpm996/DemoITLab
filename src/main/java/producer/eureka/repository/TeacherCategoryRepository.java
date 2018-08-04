package producer.eureka.repository;

import org.springframework.data.repository.CrudRepository;
import producer.eureka.model.TeacherCategory;

public interface TeacherCategoryRepository extends CrudRepository<TeacherCategory, Long> {
}
