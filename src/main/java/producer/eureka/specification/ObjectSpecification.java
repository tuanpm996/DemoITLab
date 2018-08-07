package producer.eureka.specification;

import org.atteo.evo.inflector.English;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static producer.eureka.common.Common.*;
import static producer.eureka.specification.SearchOperation.*;

public class ObjectSpecification implements Specification<Object> {

    private SearchCriteria criteria;

    private final Logger slf4jLogger = LoggerFactory.getLogger(ObjectSpecification.class);

    public ObjectSpecification(SearchCriteria searchCriteria) {
        this.criteria = searchCriteria;
    }

    @Override
    public Predicate toPredicate(Root<Object> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

        switch (criteria.getJoinType()) {
            case ONE_TO_MANY_2_TABLE:
                slf4jLogger.info("Object specification Join 2 tables");
                Join<?, ?> tableJoin1 = root.join(
                        criteria.getRoot().toLowerCase()
                                + StringUtils.capitalize(English.plural(criteria.getClassname())));
                Join<?, ?> tableJoin2 = tableJoin1.join(criteria.getClassname().toLowerCase());
                return createPredicate(tableJoin2, criteria, criteriaBuilder);

            case ONE_TO_MANY_1_TABLE:
                slf4jLogger.info("Object specification Join 1 table");
                Join<Object, Object> tableJoin = root.join(
                        criteria.getRoot().toLowerCase()
                                + StringUtils.capitalize(English.plural(criteria.getClassname())));
                return createPredicate(tableJoin, criteria, criteriaBuilder);

            case MANY_TO_ONE:
                slf4jLogger.info("Object specification Join 1 table");
                Join<Object, Object> tableJoin3 = root.join(criteria.getClassname().toLowerCase());
                return createPredicate(tableJoin3, criteria, criteriaBuilder);

            default:
                slf4jLogger.info("Object specification not join");
                return createPredicate(root, criteria, criteriaBuilder);
        }


    }

    private Predicate createPredicate(From<?, ?> root, SearchCriteria criteria, CriteriaBuilder criteriaBuilder) {
        switch (criteria.getOperation()) {
            case EQUALITY:
                if (criteria.getValue().toString().equals("true")) {
                    return criteriaBuilder.equal(root.get(criteria.getKey()), Boolean.TRUE);
                }
                if (criteria.getValue().toString().equals("false")) {
                    return criteriaBuilder.equal(root.get(criteria.getKey()), Boolean.FALSE);
                }
                if (root.get(criteria.getKey()).getJavaType() == String.class) {
                    return criteriaBuilder.like(root.get(criteria.getKey()), "%" + criteria.getValue() + "%");
                }
                return criteriaBuilder.equal(root.get(criteria.getKey()), criteria.getValue());

            case LESS_THAN_OR_EQUAL:
                return criteriaBuilder.lessThanOrEqualTo(root.get(criteria.getKey()), criteria.getValue().toString());

            case GREATER_THAN_OR_EQUAL:
                if (criteria.getKey().equalsIgnoreCase("createdAt")) {
                    Date dateStart = null;
                    try {
                        dateStart = new SimpleDateFormat(DATE_TIME_PATTERN).parse(criteria.getValue().toString());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    return criteriaBuilder.greaterThanOrEqualTo(
                            root.get(criteria.getKey()), dateStart);
                }
                return criteriaBuilder.greaterThanOrEqualTo(
                        root.get(criteria.getKey()), criteria.getValue().toString());

            case LESS_THAN:
                if (criteria.getKey().equalsIgnoreCase("createdAt")) {
                    Date dateEnd = null;
                    try {
                        dateEnd = new SimpleDateFormat(DATE_TIME_PATTERN).parse(criteria.getValue().toString());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    return criteriaBuilder.lessThan(root.get(criteria.getKey()), dateEnd);
                }

                return criteriaBuilder.lessThan(root.get(criteria.getKey()), criteria.getValue().toString());

            case GREATER_THAN:
                return criteriaBuilder.greaterThan(root.get(criteria.getKey()), criteria.getValue().toString());

            default:
                return null;
        }
    }
}
