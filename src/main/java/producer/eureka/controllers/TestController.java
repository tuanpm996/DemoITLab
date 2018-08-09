package producer.eureka.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import producer.eureka.model.Category;
import producer.eureka.model.Teacher;
import producer.eureka.model.TeacherLevel;
import producer.eureka.repository.TeacherCategoryRepository;
import producer.eureka.services.*;

import java.util.Optional;

@RestController
@RequestMapping("api/teachers")
public class TestController {
    public static String MESS = "thanh cong";
    public static String ERROR = "that bai";
    @Autowired
    CategoryService categoryService;

    @Autowired
    TeacherLevelService teacherLevelService;

    @Autowired
    TeacherService teacherService;

    @Autowired
    TeacherPhoneService teacherPhoneService;



    @PostMapping("/categories/create")
    public ResponseEntity<Object> createCategory(@RequestBody Category category){
        try {
            return new ResponseEntity<>(categoryService.save(category),HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(category,HttpStatus.BAD_GATEWAY);
        }

    }

    @GetMapping("/categories")
    public ResponseEntity<Object> findAllCategory(){
        try {
            return new ResponseEntity<>(categoryService.findAllCategory(),HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(ERROR,HttpStatus.BAD_GATEWAY);
        }
    }

    @PutMapping("/categories/update/{id}")
    public ResponseEntity<Object> updateCategory(@PathVariable int id,@RequestBody Category category){
        try {
            return new ResponseEntity<>(categoryService.update(id,category),HttpStatus.UPGRADE_REQUIRED);
        }
        catch (Exception e){
            return new ResponseEntity<>(category,HttpStatus.BAD_GATEWAY);
        }

    }

    @DeleteMapping("/categories/delete/{id}")
    public ResponseEntity<Object> deleteCategory(@PathVariable int id){
        try {
            categoryService.delete(id);
            return new ResponseEntity<>(MESS,HttpStatus.UPGRADE_REQUIRED);
        }
        catch (Exception e){
            return new ResponseEntity<>(ERROR,HttpStatus.BAD_GATEWAY);
        }
    }

    @PostMapping("/teacherlevel/create")
    public ResponseEntity<Object> createTeacherLevel(@RequestBody TeacherLevel teacherLevel){
        try {
            return new ResponseEntity<>(teacherLevelService.save(teacherLevel),HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(teacherLevel,HttpStatus.BAD_GATEWAY);
        }

    }

    @PutMapping("/teacherlevel/update/{id}")
    public ResponseEntity<Object> updateTeacherLevel(@PathVariable int id,@RequestBody TeacherLevel teacherLevel){
        try {
            return new ResponseEntity<>(teacherLevelService.update(id,teacherLevel),HttpStatus.UPGRADE_REQUIRED);
        }
        catch (Exception e){
            return new ResponseEntity<>(teacherLevel,HttpStatus.BAD_GATEWAY);
        }

    }

    @DeleteMapping("/teacherlevel/delete/{id}")
    public ResponseEntity<Object> deleteTeacherLevel(@PathVariable int id){
        try {
            teacherLevelService.delete(id);
            return new ResponseEntity<>(MESS,HttpStatus.UPGRADE_REQUIRED);
        }
        catch (Exception e){
            return new ResponseEntity<>(ERROR,HttpStatus.BAD_GATEWAY);
        }
    }

    @GetMapping("/teacherlevel/show/{id}")
    public ResponseEntity<Object> showTeacherLevel(@PathVariable int id){
        return new ResponseEntity<>(teacherLevelService.search(id),HttpStatus.OK);
    }

    @GetMapping("/teacherphone/show/{id}")
    public ResponseEntity<Object> showTeacherPhone(@PathVariable int id){
        return new ResponseEntity<>(teacherPhoneService.findByTeacher(teacherService.search(id)),HttpStatus.OK);
    }

}
