package net.nikitos.twit.controller;

import net.nikitos.twit.entity.Twit;
import net.nikitos.twit.entity.User;
import net.nikitos.twit.service.TwitService;
import net.nikitos.twit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Date;


@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TwitService twitService;

    @RequestMapping("/users")
    public String users(Model model){
        model.addAttribute("users", userService.findAll());
        return "users";
    }

    @RequestMapping("/users/{id}")
    public String detail(Model model, @PathVariable int id){
        model.addAttribute("user", userService.findWithTwit(id));
        return "user";

    }

    @RequestMapping("/registration")
    public String registration(){
        return "registration";
    }

    @ModelAttribute("user")
    public User construct(){
        return new User();
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@Valid @ModelAttribute("user")User user, BindingResult result){
        if (result.hasErrors()){
            return "registration";
        }
        userService.save(user);
        return "redirect:/registration?success=true";
    }
    @ModelAttribute("twit")
    public Twit constructTwit(){
        return new Twit();
    }
    @RequestMapping(value = "/account", method = RequestMethod.POST)
    public String addTwit(@Valid @ModelAttribute("twit")Twit twit, Principal principal, BindingResult result, Model model){
        if (result.hasErrors()){
            return account(model,principal);
        }
        String name = principal.getName();
        twit.setDate(new Date());
        twitService.save(twit,name);

        return "redirect:/account";
    }

    @RequestMapping("/account")
    public String account(Model model, Principal principal){
        String name = principal.getName();
        model.addAttribute("user",userService.findWithTwit(name));
        return "account";
    }

    @RequestMapping("/twit/remove/{id}")
    public String removeTwit(@PathVariable int id){
        twitService.delete(id);
        return "redirect:/account";
    }

    @RequestMapping("/registration/available")
    @ResponseBody
    public String available(@RequestParam String username){
        Boolean available = userService.findOne(username) == null;
        return available.toString();

    }

    @RequestMapping("/users/{id}/follow")
    public String followUser(@PathVariable int id, Principal principal){
        String name = principal.getName();
        User parent = userService.findOne(name);
        User follower = userService.findOne(id);
        userService.saveFollower(parent,follower);

        return "redirect:/users";

    }

    @RequestMapping("/users/{id}/unfollow")
    public String unfollowUser(@PathVariable int id, Principal principal){
        String name = principal.getName();
        User parent = userService.findOne(name);
        User follower = userService.findOne(id);
        userService.deleteFollower(parent,follower);
        return "redirect:/users";
    }

}
