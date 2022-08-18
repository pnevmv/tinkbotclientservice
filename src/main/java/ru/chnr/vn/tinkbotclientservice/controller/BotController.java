package ru.chnr.vn.tinkbotclientservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.chnr.vn.tinkbotclientservice.domain.User;
import ru.chnr.vn.tinkbotclientservice.repos.UserRepo;
import ru.chnr.vn.tinkbotclientservice.services.BotService;

import java.util.Map;

@Controller
public class BotController {
    @Autowired
    UserRepo userRepo;
    @Autowired
    BotService botService;

    @GetMapping
    public String home(){
        return "home";
    }

    @GetMapping("deleteBot")
    public String deleteBot(
            @AuthenticationPrincipal User user,
            Map<String , Object> model
    ){
        if(botService.deleteBot(user.getBotId())){
            userRepo.delete(user);
            return "redirect:/login";
        }
        else{
            model.put("message", "Cant delete bot:(");
            return "home";
        }
    }
}
