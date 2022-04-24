package com.example.springboot.controllers;

import com.example.springboot.models.User;
import com.example.springboot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping("/")
public class UsersController {

    final UserService us;

    public UsersController(UserService us) {
        this.us = us;
    }


    @GetMapping()
    public String index(Model model) {
        model.addAttribute("users", us.getAllUsers());
        return "index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", us.getUserById(id));
        return "show";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping
    public String create(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new";
        }
        us.save(user);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", us.getUserById(id));
        return "edit";
    }

    @PostMapping("/{id}")
    public String update(@ModelAttribute("user")  @Valid User user, BindingResult bindingResult, @PathVariable("id") Long id) {
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        us.update(id, user);
        return "redirect:/";
    }

    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        us.delete(id);
        return "redirect:/";
    }
}
