package com.example.oauth.controller;

import com.example.oauth.vo.UserProfile;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api")
public class AdminController {

    @RequestMapping("/users")
    public ResponseEntity<List<UserProfile>> getAllUsers() {
        return ResponseEntity.ok(getUsers());
    }

    private List<UserProfile> getUsers() {
        List<UserProfile> users = new ArrayList<>();
        users.add(new UserProfile("naver", "naver@naver.com"));
        users.add(new UserProfile("kakao", "kakako@kakao.com"));
        users.add(new UserProfile("google", "google@google.com"));
        return users;
    }

}
