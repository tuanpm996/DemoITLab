package producer.eureka.repository;

import org.springframework.data.repository.CrudRepository;
import producer.eureka.model.RoleGroup;

public interface RoleGroupRepository extends CrudRepository<RoleGroup, Integer> {
}
