package producer.eureka.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import producer.eureka.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Integer> {

}
