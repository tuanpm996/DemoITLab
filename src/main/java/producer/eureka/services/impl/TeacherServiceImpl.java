package producer.eureka.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import producer.eureka.model.*;
import producer.eureka.repository.*;
import producer.eureka.services.TeacherService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private ProvinceRepository provinceRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ChannelRepository channelRepository;

    @Autowired
    private TeacherEmailRepository teacherEmailRepository;

    @Autowired
    private TeacherPhoneRepository teacherPhoneRepository;

    @Autowired
    private TeacherCategoryRepository teacherCategoryRepository;


//    @Override
//    public Teacher save(Teacher teacher) {
//        teacher.setProvince(provinceRepository.findById(teacher.getProvince().getId()).get());
//        List<Category> categoryList = new ArrayList<>();
//        for (TeacherCategory teacherCategory : teacher.getTeacherCategories()) {
//            Category category = teacherCategory.getCategory();
//            Optional<Category> optional = categoryRepository.findById(category.getId());
//            Category categoryInsert = optional.get();
//            categoryList.add(categoryInsert);
//            TeacherCategory teacherCategory1 = new TeacherCategory(teacher, categoryInsert);
//            teacherCategoryRepository.save(teacherCategory);
//        }
//        teacher.setCategories(categoryList);
//        return teacherRepository.save(teacher);
//    }


    @Override
    public Iterable<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    public Iterable<Teacher> findAll(Specification specification, int page, int size) {
        return teacherRepository.findAll(specification, PageRequest.of(page, size));
    }

    @Override
    public Teacher search(int id) {
        Optional<Teacher> optionalTeacher = teacherRepository.findById(id);
        return optionalTeacher.get();
    }

    @Override
    @Transactional
    public Teacher update(int id, Teacher teacher) {
        Optional<Teacher> optionalTeacher = teacherRepository.findById(id);
        if (optionalTeacher.get() != null) {
            teacher.setId(id);
            teacherRepository.save(teacher);
            return teacher;
        } else return null;

    }

    @Override
    @Transactional
    @Modifying
    public void delete(int id) {
        teacherRepository.delete(id);
    }

    public Teacher save(Teacher teacher) {
        for (TeacherEmail email : teacher.getTeacherEmails()) {
            email.setTeacher(teacher);
            teacherEmailRepository.save(email);
        }


        for (TeacherPhone phone : teacher.getTeacherPhones()) {
            phone.setTeacher(teacher);
            teacherPhoneRepository.save(phone);
        }
        teacherCategoryRepository.deleteByTeacher(teacher);
        List<Category> categoryList = new ArrayList<>();
        List<TeacherCategory> teacherCategories = new ArrayList<>();
        for (Category category : teacher.getCategories()) {
            Optional<Category> optionalCategory = categoryRepository.findById(category.getId());
            Category categoryInsert = optionalCategory.get();
            categoryList.add(categoryInsert);
            TeacherCategory teacherCategory = new TeacherCategory(teacher, categoryInsert);
            teacherCategories.add(teacherCategory);
            teacherCategoryRepository.save(teacherCategory);
        }
        teacher.setCategories(categoryList);
        teacher.setTeacherCategories(teacherCategories);

        return teacherRepository.save(teacher);
    }
}
