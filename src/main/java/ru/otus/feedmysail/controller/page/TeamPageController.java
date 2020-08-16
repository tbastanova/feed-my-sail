package ru.otus.feedmysail.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import ru.otus.feedmysail.service.impl.UserDetailsServiceImpl;

@Controller
public class TeamPageController {
//    private final UserDetailsServiceImpl userDetailsService;
//
//    public TeamPageController(UserDetailsServiceImpl userDetailsService) {
//        this.userDetailsService = userDetailsService;
//    }

    @GetMapping("/myTeam/{id}")
    public String teamPage(@PathVariable long id, Model model) {
//        model.addAttribute("userId", userDetailsService.getUserId());
        model.addAttribute("userId", 1);
        model.addAttribute("teamId", id);
        return "myTeam";
    }

    @GetMapping("/teamProductList/{id}")
    public String teamProductList(@PathVariable long id, Model model) {
//        model.addAttribute("userId", userDetailsService.getUserId());
        model.addAttribute("userId", 1);
        model.addAttribute("teamId", id);
        return "teamProductList";
    }
}
