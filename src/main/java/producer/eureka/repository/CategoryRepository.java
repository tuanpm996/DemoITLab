package producer.eureka.repository;

import org.springframework.data.repository.CrudRepository;
import producer.eureka.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
