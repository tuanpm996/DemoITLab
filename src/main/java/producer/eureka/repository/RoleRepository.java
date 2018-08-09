package producer.eureka.repository;

import org.springframework.data.repository.CrudRepository;
import producer.eureka.model.Role;

public interface RoleRepository extends CrudRepository<Role, Integer> {
}
