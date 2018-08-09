package producer.eureka.repository;

import org.springframework.data.repository.CrudRepository;
import producer.eureka.model.Province;

public interface ProvinceRepository extends CrudRepository<Province, Integer> {
}
