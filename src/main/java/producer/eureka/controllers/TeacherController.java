package producer.eureka.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import producer.eureka.model.Teacher;
import producer.eureka.services.TeacherService;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/teachers")
public class TeacherController extends BaseController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("")
    public ResponseEntity<Object> index(@RequestParam Map<String, String> requestParams) throws ParseException {
        this.convertParams(requestParams);
        Specification<?> spec = convertStringToSpecification(this.search, Teacher.class);
        return new ResponseEntity<>(teacherService.findAll(spec, this.page - 1, this.size), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@Valid @RequestBody Teacher teacher, BindingResult result) {
        if (result.hasErrors()) {
            List<FieldError> errors = result.getFieldErrors();
            Map<String, Object> map = new HashMap<>();
            for (FieldError error : errors) {
                map.put(error.getField(), error.getDefaultMessage());

            }
            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        }
        Teacher teacherInsert = teacherService.save(teacher);
        return new ResponseEntity<>(teacherInsert, HttpStatus.CREATED);

    }

}
