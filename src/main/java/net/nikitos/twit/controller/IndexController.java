package net.nikitos.twit.controller;

import net.nikitos.twit.service.TwitService;
import net.nikitos.twit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @Autowired
    private TwitService twitService;

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("twits", twitService.findAll());
        return "index";
    }
}
