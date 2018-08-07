package producer.eureka.services.impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class TestResponse {
    public static ResponseEntity<Object> test(){
        return new ResponseEntity<>("Some thing wrong", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
