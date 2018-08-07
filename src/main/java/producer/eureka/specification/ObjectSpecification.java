package producer.eureka.specification;

import org.springframework.data.jpa.domain.Specification;
import producer.eureka.model.Province;
import producer.eureka.model.Teacher;

import javax.persistence.criteria.*;

public class TeacherSpecification implements Specification<Object> {

    private SearchCriteria criteria;

    public TeacherSpecification(SearchCriteria searchCriteria) {
        this.criteria = searchCriteria;
    }

    @Override
    public Predicate toPredicate(Root<Object> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        if(criteria.getClassname() != null){
            try {
                Class<?> clazz = Class.forName("producer.eureka.model." + criteria.getClassname());
                Join<Object,?> teacherProvinceJoin  = root.join(criteria.getClassname().toLowerCase());
                return criteriaBuilder.equal(teacherProvinceJoin.get(criteria.getKey()), criteria.getValue());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        if (criteria.getOperation().equalsIgnoreCase(">")) {
            return criteriaBuilder.greaterThanOrEqualTo(root.get(criteria.getKey()), criteria.getValue().toString());
        }

        if (criteria.getOperation().equalsIgnoreCase("<")) {
            return criteriaBuilder.lessThanOrEqualTo(root.get(criteria.getKey()), criteria.getValue().toString());
        }

        if (criteria.getOperation().equalsIgnoreCase(":")) {
            if (criteria.getValue().toString().equalsIgnoreCase("true")) {
                return criteriaBuilder.equal(root.get(criteria.getKey()), Boolean.TRUE);
            }
            if (criteria.getValue().toString().equalsIgnoreCase("false")) {
                return criteriaBuilder.equal(root.get(criteria.getKey()), Boolean.FALSE);
            }
            if (root.get(criteria.getKey()).getJavaType() == String.class) {
                return criteriaBuilder.like(root.get(criteria.getKey()), "%" + criteria.getValue() + "%");
            }
            return criteriaBuilder.equal(root.get(criteria.getKey()), criteria.getValue());
        }
        return null;
    }
}
