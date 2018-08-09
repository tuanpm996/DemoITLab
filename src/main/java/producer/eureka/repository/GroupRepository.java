package producer.eureka.repository;

import org.springframework.data.repository.CrudRepository;
import producer.eureka.model.Group;

public interface GroupRepository extends CrudRepository<Group, Integer> {
}
