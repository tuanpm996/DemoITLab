package producer.eureka.controllers;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;
import producer.eureka.specification.ObjectSpecificationBuilder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static producer.eureka.common.Common.*;
import static producer.eureka.specification.SearchOperation.*;

public class BaseController {

    protected int page = 1;

    protected int size = 10;

    protected String search = "";

    protected Specification<?> convertStringToSpecification(String search, Class rootClass) {
        ObjectSpecificationBuilder builder = new ObjectSpecificationBuilder();
        Pattern pattern = Pattern.compile("(\\w+?)(\\$|:|<|>)(.+?),", Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(search);

        while (matcher.find()) {
            String className = StringUtils.capitalize(matcher.group(1));
            if (classExists(rootClass.getName() + className)) {
                if(!classExists(PATH_TO_MODEL + className)){
                    builder.with(rootClass.getSimpleName(), className, matcher.group(1), matcher.group(2), matcher.group(3), ONE_TO_MANY_1_TABLE);
                } else {
                    builder.with(rootClass.getSimpleName(), matcher.group(1), null, matcher.group(2), matcher.group(3),ONE_TO_MANY_2_TABLE);
                }

            } else if (classExists(PATH_TO_MODEL + className)) {
                builder.with(rootClass.getSimpleName(),className, matcher.group(1), matcher.group(2), matcher.group(3), MANY_TO_ONE);
            } else {
                builder.with(null, null, matcher.group(1), matcher.group(2), matcher.group(3), "None");
            }
        }
        return builder.build();
    }

    protected void convertParams(Map<String, String> allRequestParams) {
        this.page = 1;
        this.size = 10;
        this.search = "";
        StringBuilder sb = new StringBuilder();
        for (String key : allRequestParams.keySet()) {
            String value = allRequestParams.get(key);
            switch (key) {
                case "createdAtStart":
                    sb.append("createdAt" + GREATER_THAN_OR_EQUAL + value + ",");
                    break;
                case "createdAtEnd":
                    sb.append("createdAt" + LESS_THAN + getEndDate(value) + ",");
                    break;
                case "page":
                    this.page = Integer.parseInt(value);
                    break;
                case "size":
                    this.size = Integer.parseInt(value);
                    break;
                default:
                    sb.append(key + EQUALITY + value + ",");
                    break;
            }
        }
        this.search = sb.toString();
    }

    private boolean classExists(String className) {
        try {
            Class.forName(className);
            return true;
        } catch (ClassNotFoundException ex) {
            return false;
        }
    }

    private String getEndDate(String createdAtEnd) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_TIME_PATTERN);
        Date dateEnd = null;
        try {
            dateEnd = simpleDateFormat.parse(createdAtEnd);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String dateEndAddedOneDay = simpleDateFormat.format(
                new Date(dateEnd.getTime() + TimeUnit.DAYS.toMillis(1)));
        return dateEndAddedOneDay;

    }
}
