package producer.eureka.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import producer.eureka.model.Province;
import producer.eureka.model.Teacher;
import producer.eureka.services.ProvinceService;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.Map;


@RestController
@RequestMapping("api/provinces")
public class ProvinceController extends BaseController {

    @Autowired
    private ProvinceService provinceService;

    @GetMapping("")
    public ResponseEntity<Object> index(@RequestParam Map<String, String> requestParams) throws ParseException {
        this.convertParams(requestParams);
        Specification<?> spec = convertStringToSpecification(this.search, Teacher.class);
        return new ResponseEntity<>(provinceService.findAll(spec, this.page - 1, this.size), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody @Valid Province province) {
        Province provinceInsert = provinceService.save(province);
        return new ResponseEntity<>(provinceInsert, HttpStatus.CREATED);
    }

}