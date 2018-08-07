package producer.eureka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import producer.eureka.model.Teacher;

import javax.transaction.Transactional;

public interface TeacherRepository extends CrudRepository<Teacher, Integer>,
        JpaRepository<Teacher, Integer>,
        JpaSpecificationExecutor<Teacher>,
        PagingAndSortingRepository<Teacher, Integer> {
    @Transactional
    @Modifying
    @Query("UPDATE Teacher t SET t.softDelete = true WHERE t.id =:id")
    void delete(@Param("id") int id);
}
