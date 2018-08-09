package producer.eureka.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import producer.eureka.model.*;
import producer.eureka.repository.*;
import producer.eureka.services.TeacherService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private TeacherCategoryRepository teacherCategoryRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private TeacherLevelRepository teacherLevelRepository;

    @Autowired
    private ChannelRepository channelRepository;

    @Autowired
    private ProvinceRepository provinceRepository;

    @Autowired
    private TeacherSourceRepository teacherSourceRepository;

    @Autowired
    private TeacherEmailRepository teacherEmailRepository;

    @Autowired
    private TeacherPhoneRepository teacherPhoneRepository;

    public Teacher save(Teacher teacher) {
        Optional<Channel> optionalChannel = channelRepository.findById(teacher.getChannel().getId());
        teacher.setChannel(optionalChannel.get());

        Optional<Province> optionalProvince = provinceRepository.findById(teacher.getProvince().getId());
        teacher.setProvince(optionalProvince.get());

        Optional<TeacherSource> optionalTeacherSource = teacherSourceRepository.findById(teacher.getTeacherSource().getId());
        teacher.setTeacherSource(optionalTeacherSource.get());

        if ((teacher.getTeacherLevel()) != null) {
            Optional<TeacherLevel> optionalTeacherLevel = teacherLevelRepository.findById(teacher.getTeacherLevel().getId());
            teacher.setTeacherLevel(optionalTeacherLevel.get());
        } else {
            Optional<TeacherLevel> optionalTeacherLevel = teacherLevelRepository.findById(2);
            teacher.setTeacherLevel(optionalTeacherLevel.get());
        }

        for (TeacherEmail email : teacher.getTeacherEmails()) {
            email.setTeacher(teacher);
//            teacherEmailRepository.save(email);
        }


        for (TeacherPhone phone : teacher.getTeacherPhones()) {
            phone.setTeacher(teacher);
//            teacherPhoneRepository.save(phone);
        }
//        teacherCategoryRepository.deleteByTeacher(teacher);
        List<Category> categoryList = new ArrayList<>();
        List<TeacherCategory> teacherCategories = new ArrayList<>();
        for (Category category : teacher.getCategoryList()) {
            Optional<Category> optionalCategory = categoryRepository.findById(category.getId());
            Category categoryInsert = optionalCategory.get();
            categoryList.add(categoryInsert);
            TeacherCategory teacherCategory = new TeacherCategory(teacher, categoryInsert);
            teacherCategories.add(teacherCategory);
            teacherCategoryRepository.save(teacherCategory);
        }
        teacher.setCategoryList(categoryList);
        teacher.setTeacherCategories(teacherCategories);

        return teacherRepository.save(teacher);
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
}
