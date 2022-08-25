package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/SignUp")
public class UserController {
    @GetMapping
    public String showSignUpForm() {
        return "SignUp";
    }

}
