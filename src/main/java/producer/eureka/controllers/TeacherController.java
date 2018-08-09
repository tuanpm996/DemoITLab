package producer.eureka.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import producer.eureka.model.Teacher;
import producer.eureka.services.TeacherService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/teachers")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @PostMapping("/create")
    public ResponseEntity<Object> create(@Valid @RequestBody Teacher teacher, BindingResult result) {
        if (result.hasErrors()) {
            List<FieldError> errors = result.getFieldErrors();
            Map<String, Object> map = new HashMap<>();
            for(FieldError error: errors){
                map.put(error.getField(), error.getDefaultMessage());

            }
            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST) ;
        }
        Teacher teacherInsert = teacherService.save(teacher);
        return new ResponseEntity<>(teacherInsert, HttpStatus.CREATED);

    }

    @GetMapping("/show/{id}")
    public ResponseEntity<Object> create(@PathVariable("id") int id){
        return new ResponseEntity<>(teacherService.search(id),HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") int id, @RequestBody Teacher teacher){
        return new ResponseEntity<>(teacherService.update(id,teacher),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteTeacher(@PathVariable int id){
        System.out.println(id);
        teacherService.delete(id);
        return new ResponseEntity<>("DELETE OK",HttpStatus.UPGRADE_REQUIRED);

    }

}
