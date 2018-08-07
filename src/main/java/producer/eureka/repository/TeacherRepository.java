package producer.eureka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import producer.eureka.model.Teacher;

public interface TeacherRepository extends CrudRepository<Teacher, Long>,
        JpaRepository<Teacher, Long>,
        JpaSpecificationExecutor<Teacher>,
        PagingAndSortingRepository<Teacher, Long> {
}
