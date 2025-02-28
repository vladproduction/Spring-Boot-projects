package com.vladproduction.controller;

import com.vladproduction.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    // http://localhost:8080/

    // Sample data
    private List<User> users = new ArrayList<>();

    // Constructor with sample data
    public HomeController() {
        // Add some sample users for demonstration
        users.add(new User("John Doe", "john.doe@example.com"));
        users.add(new User("Jane Smith", "jane.smith@example.com"));
    }

    // Method using @RequestMapping
    @RequestMapping("/")
    public String home() {
        System.out.println("Home controller method called!");
        return "home"; // This will render home.jsp
    }

    // Method using @GetMapping
    @GetMapping("/users")
    public String showUsers(Model model) {
        System.out.println("Users controller method called!");
        // Add data to the model
        model.addAttribute("userList", users);
        return "users"; // This will render users.jsp
    }

    // Method using ModelAndView
    @GetMapping("/register")
    public ModelAndView showRegistrationForm() {
        System.out.println("Register form controller method called!");
        ModelAndView modelAndView = new ModelAndView("register");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    // Method handling form submission
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user) {
        System.out.println("Register post controller method called!");
        System.out.println("Received user: " + user.getName() + ", " + user.getEmail());
        users.add(user);
        return "redirect:/users";
    }

    ///////////////////*******previous version*******///////////////////

//    private List<User> users = new ArrayList<>();
//
//    // Method using @RequestMapping
//    @RequestMapping("/")
//    public String home() {
//        System.out.println("Home controller method called!"); // Logging for debugging
//        return "home"; // This will render home.jsp
//    }
//
//    // Method using @GetMapping
//    @GetMapping("/users")
//    public String showUsers(Model model) {
//        System.out.println("Users controller method called!"); // Logging for debugging
//        // Add data to the model
//        model.addAttribute("userList", users);
//        return "users"; // This will render users.jsp
//    }
//
//    // Method using ModelAndView
//    @GetMapping("/register")
//    public ModelAndView showRegistrationForm() {
//        System.out.println("Register form controller method called!"); // Logging for debugging
//        ModelAndView modelAndView = new ModelAndView("register");
//        modelAndView.addObject("user", new User());
//        return modelAndView;
//    }
//
//    // Method handling form submission
//    @PostMapping("/register")
//    public String registerUser(@ModelAttribute("user") User user) {
//        System.out.println("Register post controller method called!"); // Logging for debugging
//        System.out.println("Received user: " + user.getName() + ", " + user.getEmail());
//        users.add(user);
//        return "redirect:/users";
//    }

}
