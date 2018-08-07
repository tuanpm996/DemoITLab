package producer.eureka.repository;

import org.springframework.data.repository.CrudRepository;
import producer.eureka.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
}
