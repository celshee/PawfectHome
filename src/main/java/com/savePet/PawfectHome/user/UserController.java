package com.savePet.PawfectHome.user;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class UserController {
    @RequestMapping("/")
    public String greet(){
        return "Hello World";
    }
}
