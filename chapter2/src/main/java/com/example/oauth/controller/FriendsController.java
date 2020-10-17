package com.example.oauth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.PagedList;
import org.springframework.social.facebook.api.Reference;
import org.springframework.social.facebook.api.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class FriendsController {

    @Autowired
    private Facebook facebook;
    @Autowired
    private ConnectionRepository connectionRepository;

    @GetMapping
    public String friends(Model model) {
        if(connectionRepository.findPrimaryConnection(Facebook.class) == null) {
            return "redirect:/connect/facebook";
        }
        String[] fields = { "id", "email", "name" };
        User userProfile = facebook.fetchObject("me", User.class, fields);

        model.addAttribute("facebookProfile", userProfile);
        PagedList<Reference> frieds = facebook.friendOperations().getFriends();

        return "friends";
    }
}
