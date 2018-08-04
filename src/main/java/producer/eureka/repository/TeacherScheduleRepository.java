package producer.eureka.repository;

import org.springframework.data.repository.CrudRepository;
import producer.eureka.model.TeacherSchedule;

public interface TeacherScheduleRepository extends CrudRepository<TeacherSchedule, Long> {
}
