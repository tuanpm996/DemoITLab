package producer.eureka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import producer.eureka.model.*;
import producer.eureka.services.ProvinceService;
import producer.eureka.services.TeacherService;

@SpringBootApplication
public class EurekaApplication implements CommandLineRunner {

    @Autowired
    private ProvinceService provinceService;

    @Autowired
    private TeacherService teacherService;




//    @PostConstruct
//    public void init(){
//        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Saigonjl"));   // It will set UTC timezone
//        System.out.println("Spring boot application running in UTC timezone :"+new Date());   // It will print UTC timezone
//    }

    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        ObjectSpecificationBuilder builder = new ObjectSpecificationBuilder();
//        Pattern pattern = Pattern.compile("id:1,", Pattern.UNICODE_CHARACTER_CLASS);
//        Matcher matcher = pattern.matcher("id:1,");
//        System.out.println(matcher);
//        System.out.println(matcher.group(0));
//        System.out.println(matcher.group(1));
//        System.out.println(matcher.group(2));
//        System.out.println(matcher.group(3));
//        System.out.println(matcher.group(4));
//        System.out.println(matcher.group(5));
//        System.out.println(matcher.group(3));

        for (int i = 0; i <= 5; i++) {
//            Province province = new Province();
//            province.setName("Hà Nội");
//            provinceService.save(province);
//            TeacherEmail teacherEmail = new TeacherEmail();
//            teacherEmail.setEmail("tuanpm996@gmail.com");
//            TeacherEmail teacherEmail2 = new TeacherEmail();
//            teacherEmail.setEmail("ahihi@gmail.com");
//            Teacher teacher = new Teacher();
//            teacher.setProvince(province);
//            Category category = new Category();
//            category.setName("test category");
//            category.setId(1L);
//            TeacherCategory teacherCategory = new TeacherCategory(teacher, category);
//            teacher.getTeacherCategories().add(teacherCategory);
////            teacher.setSoftDelete(true);
//            teacher.getTeacherEmails().add(teacherEmail);
//            teacher.getTeacherEmails().add(teacherEmail2);
//            teacherService.save(teacher);
        }
////
//        Province province = provinceService.findAll().iterator().next();
////        provinceService.save(province);
//        Teacher teacher = new Teacher();
//        teacher.setProvince(province);
//        teacher.setSoftDelete(false);
//        teacherService.save(teacher);
        }
}
