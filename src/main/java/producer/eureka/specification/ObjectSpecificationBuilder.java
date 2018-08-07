package producer.eureka.specification;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import producer.eureka.model.Teacher;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class TeacherSpecificationBuilder {

    private final List<SearchCriteria> params;

    public TeacherSpecificationBuilder() {
        this.params = new ArrayList<SearchCriteria>();
    }

    public TeacherSpecificationBuilder with(String key, String operation, Object value) {
        params.add(new SearchCriteria(key, operation, value));
        return this;
    }

    public TeacherSpecificationBuilder with(String classname, String key, String operation, Object value) {
        params.add(new SearchCriteria(classname, key, operation, value));
        return this;
    }

    public Specification<Object> build() {
        if (this.params.size() == 0) {
            return null;
        }
        List<Specification<Object>> specifications = new ArrayList<>();
        for (SearchCriteria param : params) {
            specifications.add(new TeacherSpecification(param));
        }

        Specification<Object> result = specifications.get(0);
        for (int i = 1; i < specifications.size(); i++) {
            result = Specification.where(result).and(specifications.get(i));
        }
        return result;
    }
}
