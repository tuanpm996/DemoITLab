package producer.eureka.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import producer.eureka.model.Province;
import producer.eureka.services.ProvinceService;

import javax.validation.Valid;

//public class CategoryController {
//}
//

@RestController
@RequestMapping("api/categories")
public class CategoryController extends BaseController {

    @Autowired
    private ProvinceService provinceService;

//    @Autowired
//    private ProvinceService provinceService;

    @GetMapping("")
    public ResponseEntity<Object> index(@RequestParam(value = "search", required = true) String search,
                                        @RequestParam(value = "page", defaultValue = "1") int page,
                                        @RequestParam(value = "size", defaultValue = "10") int size) {
        Specification<Object> spec = convertSearchToSpecification(search);
        return new ResponseEntity<>(provinceService.findAll(spec, page - 1, size), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody @Valid Province province) {
        Province provinceInsert = provinceService.save(province);
        return new ResponseEntity<>(provinceInsert, HttpStatus.CREATED);
    }

}