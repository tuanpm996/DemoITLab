package producer.eureka.repository;

import org.springframework.data.repository.CrudRepository;
import producer.eureka.model.Channel;

public interface ChannelRepository extends CrudRepository<Channel, Integer> {
}
