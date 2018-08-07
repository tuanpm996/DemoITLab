package producer.eureka.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import producer.eureka.model.Province;
import producer.eureka.repository.ProvinceRepository;
import producer.eureka.services.ProvinceService;

import java.util.Optional;

@Service
public class ProvinceServiceImpl implements ProvinceService {

    @Autowired
    ProvinceRepository provinceRepository;

    @Override
    public Province save(Province province) {
        return provinceRepository.save(province);
    }

    @Override
    public Optional<Province> findByid(Long id) {
        return provinceRepository.findById(id);
    }

    @Override
    public Iterable<Province> findAll(Specification specification, int page, int size) {
        return provinceRepository.findAll(specification, PageRequest.of(page, size));
    }

    @Override
    public Iterable<Province> findAll(Specification specification) {
        return provinceRepository.findAll(specification);
    }

    @Override
    public Iterable<Province> findAll() {
        return provinceRepository.findAll();
    }
}
