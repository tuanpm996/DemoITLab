package producer.eureka.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import producer.eureka.model.TeacherLevel;
import producer.eureka.repository.TeacherLevelRepository;
import producer.eureka.services.TeacherLevelService;

import java.util.Optional;

@Service
public class TeacherLevelServiceImpl implements TeacherLevelService {
    @Autowired
    TeacherLevelRepository teacherLevelRepository;

    @Override
    public TeacherLevel save(TeacherLevel teacherLevel) {
        teacherLevelRepository.save(teacherLevel);
        return teacherLevel;
    }

    @Override
    public TeacherLevel update(int id, TeacherLevel teacherLevel) {
         if(teacherLevelRepository.findById(id)!=null){
             teacherLevel.setId(id);
             return teacherLevelRepository.save(teacherLevel);
         }
             return null;
    }

    @Override
    public void softDelete(int id) {

    }

    @Override
    @Transactional
    public void forceDelete(int id) {
        teacherLevelRepository.deleteById(id);
    }

    @Override
    public TeacherLevel search(int id) {
        Optional<TeacherLevel> optionalTeacherLevel = teacherLevelRepository.findById(id);
        return optionalTeacherLevel.get();
    }
}
