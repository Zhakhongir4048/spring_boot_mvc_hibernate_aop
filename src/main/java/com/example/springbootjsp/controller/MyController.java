package com.example.springbootjsp.controller;

import com.example.springbootjsp.entity.User;
import com.example.springbootjsp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MyController {

    private final UserService userService;

    @Autowired
    public MyController(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping("/")
    public ModelAndView showAllUsers(ModelAndView modelAndView) {

        List<User> allUsers = userService.getAllUsers();
        modelAndView.setViewName("all-users");

        modelAndView.addObject("allUsers", allUsers);

        return modelAndView;
    }

    @RequestMapping("/addNewUser")
    public ModelAndView addNewUser(ModelAndView modelAndView) {

        User user = new User();
        modelAndView.setViewName("user-info");

        modelAndView.addObject("user", user);

        return modelAndView;
    }

    @RequestMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {

        userService.saveUser(user);

        return "redirect:/";
    }


    @RequestMapping("/updateInfo")
    public String updateUser(@RequestParam("userId") int id, Model model) {

        User user = userService.getUser(id);
        model.addAttribute("user", user);

        return "user-info";
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(@RequestParam("userId") int id) {

        userService.deleteUser(id);

        return "redirect:/";

    }


}
