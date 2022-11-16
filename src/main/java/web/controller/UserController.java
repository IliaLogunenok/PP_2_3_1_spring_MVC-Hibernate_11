package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("userList", userService.findAll());
        return "index1";
    }

    @GetMapping("/id")
    public String show(@RequestParam(value = "id", required = false) int id, Model model) {
        model.addAttribute("user", userService.findOne(id));
        return "show";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping
    public String create(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/user";
    }

    @GetMapping("/id/edit")
    public String edit(Model model, @RequestParam(value = "id", required = false) int id) {
        model.addAttribute("user", userService.findOne(id));
        return "edit";
    }

    @PatchMapping("/id")
    public String update(@ModelAttribute("user") User user, @RequestParam(value = "id", required = false) int id) {
        userService.update(id, user);
        return "redirect:/user";
    }

    @DeleteMapping("/id")
    public String delete(@RequestParam(value = "id", required = false) int id) {
        userService.delete(id);
        return "redirect:/user";
    }
}
