package producer.eureka.services;

import producer.eureka.model.TeacherLevel;

public interface TeacherLevelService {
    TeacherLevel save(TeacherLevel teacherLevel);

    TeacherLevel update(int id, TeacherLevel teacherLevel);

    void softDelete(int id);

    void forceDelete(int id);

    TeacherLevel search(int id);
}
