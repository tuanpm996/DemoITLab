package producer.eureka.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import producer.eureka.model.Teacher;
import producer.eureka.model.TeacherCategory;

public interface TeacherCategoryRepository extends CrudRepository<TeacherCategory, Integer> {
    @Transactional
    @Modifying
    @Query("DELETE FROM TeacherCategory tc WHERE tc.teacher =:teacher")
    void deleteByTeacher(@Param("teacher")Teacher teacher);
}
