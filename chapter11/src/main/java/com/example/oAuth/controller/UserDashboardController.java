package com.example.oAuth.controller;

import com.example.oAuth.user.ClientUser;
import com.example.oAuth.user.ClientUserDetails;
import com.example.oAuth.user.Entry;
import com.example.oAuth.user.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;

@Controller
public class UserDashboardController {

    @Autowired
    private OAuth2RestTemplate restTemplate;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/dashboard")
    public ModelAndView dashboard() {
        ClientUserDetails userDetails = (ClientUserDetails) SecurityContextHolder.getContext();
        ClientUser clientUser = userDetails.getClientUser();
        clientUser.setEntries(Arrays.asList(new Entry("entry 1"), new Entry("entry 2")));

        ModelAndView mv = new ModelAndView("dashboard");
        mv.addObject("user", clientUser);
        return mv;
    }

    private void tryToGetUserProfile(ModelAndView mv) {
        String endpoint = "http://localhost:8080/api/profile";
        try {
            UserProfile userProfile = restTemplate.getForObject(endpoint, UserProfile.class);
            mv.addObject("profile", userProfile);
        } catch (HttpClientErrorException e) {
            throw new RuntimeException("it was not possible to retrieve user profile");
        }
    }

    @GetMapping("/callback")
    public ModelAndView callback() {
        return new ModelAndView("forward:/dashboard");
    }

}
