package producer.eureka.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import producer.eureka.model.Teacher;

public interface TeacherRepository extends CrudRepository<Teacher, Integer> {
    @Transactional
    @Modifying
    @Query("UPDATE Teacher t SET t.softDelete = true WHERE t.id =:id")
    void delete(@Param("id") int id);
}
