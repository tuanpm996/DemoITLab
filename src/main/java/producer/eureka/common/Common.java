package producer.eureka.common;

import java.util.ArrayList;
import java.util.List;

public class Common {
    public static final String PATH_TO_MODEL = "producer.eureka.model.";
    public static final String DATE_TIME_PATTERN = "yyyy/MM/dd";
    public static final String ONE_TO_MANY_1_TABLE = "One to many 2 table";
    public static final String ONE_TO_MANY_2_TABLE = "One to many 1 table";
    public static final String MANY_TO_ONE = "Many to one";
    public static final List<String> JOIN_ATTRIBUTE = new ArrayList<String>() {{
        add("email");
        add("phone");
    }};
}
