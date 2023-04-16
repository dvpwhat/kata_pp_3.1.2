package com.kata.pp.kata.controller;


import com.kata.pp.kata.model.User;
import com.kata.pp.kata.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String getAllUsers(Model model) {
        List<User> list = userService.getAllUsers();
        model.addAttribute("list", list);
        return "user";
    }
    @GetMapping("/addNewUser")
    public String addNewUser(@ModelAttribute("user") User user) {

        return "UserInfo";
    }

    @PostMapping("/addNewUser")
    public String createUser(@ModelAttribute("user") User user) {
        userService.createUser(user);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.showUserById(id));
        return "userEdit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/";
    }

}
