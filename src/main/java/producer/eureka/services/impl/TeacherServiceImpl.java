package producer.eureka.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import producer.eureka.model.Category;
import producer.eureka.model.Teacher;
import producer.eureka.model.TeacherCategory;
import producer.eureka.repository.CategoryRepository;
import producer.eureka.repository.ProvinceRepository;
import producer.eureka.repository.TeacherCategoryRepository;
import producer.eureka.repository.TeacherRepository;
import producer.eureka.services.TeacherService;

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
    private TeacherCategoryRepository teacherCategoryRepository;


    @Override
    public Teacher save(Teacher teacher) {
        teacher.setProvince(provinceRepository.findById(teacher.getProvince().getId()).get());
        List<Category> categoryList = new ArrayList<>();
        for (TeacherCategory teacherCategory : teacher.getTeacherCategories()) {
            Category category = teacherCategory.getCategory();
            Optional<Category> optional = categoryRepository.findById(category.getId());
            Category categoryInsert = optional.get();
            categoryList.add(categoryInsert);
            TeacherCategory teacherCategory1 = new TeacherCategory(teacher, categoryInsert);
            teacherCategoryRepository.save(teacherCategory);
        }
        teacher.setCategories(categoryList);
        return teacherRepository.save(teacher);
    }


    @Override
    public Iterable<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    public Iterable<Teacher> findAll(Specification specification, int page, int size) {
        return teacherRepository.findAll(specification, PageRequest.of(page, size));
    }
}
