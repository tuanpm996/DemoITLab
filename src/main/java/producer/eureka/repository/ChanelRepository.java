package producer.eureka.repository;

import org.springframework.data.repository.CrudRepository;
import producer.eureka.model.Channel;

public interface ChanelRepository extends CrudRepository<Channel, Long> {
}
