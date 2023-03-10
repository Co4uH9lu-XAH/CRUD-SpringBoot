package ru.kunin.CRUDSpringBoot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kunin.CRUDSpringBoot.models.User;
import ru.kunin.CRUDSpringBoot.service.UserService;


@Controller
@RequestMapping("/")
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String showStartPage() {
        return "first/start-page";
    }

    @GetMapping("/showUsers")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users/show-users";
    }

    @GetMapping("show-user/{id}")
    public String getUser(@PathVariable("id") int id, Model model ) {
        model.addAttribute("user", userService.getUser(id));
        return "users/show-user";
    }

    @GetMapping("/newUser")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "/users/new-user";
    }

    @PostMapping("/user-create")
    public String addUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/showUsers";
    }

    @GetMapping("/{id}/edit")
    public String editUser(@PathVariable ("id") int id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "/users/edit-user";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute User user, @PathVariable("id") int id) {
        userService.updateUser(id, user);
        return "redirect:/showUsers";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.removeUser(id);
        return "redirect:/showUsers";
    }
}
