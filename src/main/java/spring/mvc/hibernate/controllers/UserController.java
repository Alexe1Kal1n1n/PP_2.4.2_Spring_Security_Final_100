package spring.mvc.hibernate.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import spring.mvc.hibernate.model.User;
import spring.mvc.hibernate.service.UserService;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showAllUser(Model model) {
        List<User> allUsers = userService.listUsers();
        model.addAttribute("allUs", allUsers);
        return "all-users";
    }

    @GetMapping("/addNewUser")
    public String addNewUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user-info";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable("id") int id, ModelMap model) {
        User user = userService.getById(id);
        model.addAttribute("user", user);
        return "edit-user";
    }

    @PatchMapping("/edit/{id}")
    public String editUser(@ModelAttribute User user) {
        userService.update(user);
        return "redirect:/";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/";
    }
}
