package producer.eureka.specification;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

import static producer.eureka.common.Common.JOIN_ATTRIBUTE;

@AllArgsConstructor
public class ObjectSpecificationBuilder {

    private final List<SearchCriteria> params;

    public ObjectSpecificationBuilder() {
        this.params = new ArrayList<>();
    }

    public ObjectSpecificationBuilder with(String root, String classname, String key,
                                           String operation, Object value, String joinType) {
        String keySearch = (JOIN_ATTRIBUTE.indexOf(key) > -1) ? key : "name";
        params.add(new SearchCriteria(root, classname, keySearch, operation, value, joinType));
        return this;
    }

    public Specification<Object> build() {
        if (this.params.size() == 0) {
            return null;
        }
        List<Specification<Object>> specifications = new ArrayList<>();
        for (SearchCriteria param : params) {
            specifications.add(new ObjectSpecification(param));
        }

        Specification<Object> result = specifications.get(0);
        for (int i = 1; i < specifications.size(); i++) {
            result = Specification.where(result).and(specifications.get(i));
        }
        return result;
    }
}
