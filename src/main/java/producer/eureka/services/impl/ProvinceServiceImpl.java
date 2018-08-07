package producer.eureka.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
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
    public Province getOne(Province province) {
        return provinceRepository.getOne(province.getId());
    }

    @Override
    public Iterable<Province> findAll() {
        return provinceRepository.findAll();
    }

    @Override
    public Optional<Province> findByid(Long id) {
        return provinceRepository.findById(id);
    }
}
