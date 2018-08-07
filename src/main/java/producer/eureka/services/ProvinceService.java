package producer.eureka.services;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import producer.eureka.model.Province;

import java.util.Optional;

public interface ProvinceService {
    public Province save(Province province);

    public Iterable<Province> findAll(Specification specification);

    public Iterable<Province> findAll();

    public Optional<Province> findByid(Long id);

    public Iterable<Province> findAll(Specification specification, int page, int size);
}
