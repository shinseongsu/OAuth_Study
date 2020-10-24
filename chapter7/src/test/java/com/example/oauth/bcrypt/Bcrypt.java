package com.example.oauth.bcrypt;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
public class Bcrypt {

    @Test
    public void 암호화() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String clientSecret = "123456";
        clientSecret = encoder.encode(clientSecret);
        System.out.println(clientSecret);           // $2a$10$ex7ff1WOv9wZkPgRH/Bcc.raypBGVijD6iDi2qOD7vcRngjwzeW62
    }

}
