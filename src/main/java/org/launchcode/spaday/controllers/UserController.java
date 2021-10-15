package org.launchcode.spaday.controllers;

import org.launchcode.spaday.data.UserData;
import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping
    public String index(Model model){
        model.addAttribute("users", UserData.getAll());
        return "user/index";
    }

    @GetMapping("/add")
    public String displayAddUserForm(){
        return "user/add";
    }

    @PostMapping()
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify){
        if(user.getPassword().equals(verify)){
            User newUser = new User(user.getUsername(), user.getEmail(),user.getPassword());
            UserData.add(newUser);
            model.addAttribute("users", UserData.getAll());
            return "user/index";
        }else{
            model.addAttribute("error", "Password Error");
            model.addAttribute("username",user.getUsername());
            model.addAttribute("email",user.getEmail());
            return "user/add";
        }
    }

    @GetMapping("detail/{userId}")
    public String displayEditEventForm(Model model, @PathVariable int userId) {
        User userToDisplay = UserData.getById(userId);
        String title = "User Detail of " + userToDisplay.getUsername() + " (id= " + userToDisplay.getId() + ")";
        model.addAttribute("title", title);
        model.addAttribute("user", userToDisplay);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String signUpDate = dtf.format(userToDisplay.getSignDate());
        model.addAttribute("date", signUpDate);
        return "user/detail";
    }
}
