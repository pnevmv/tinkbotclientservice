package ru.chnr.vn.tinkbotclientservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.chnr.vn.tinkbotclientservice.domain.Role;
import ru.chnr.vn.tinkbotclientservice.domain.User;
import ru.chnr.vn.tinkbotclientservice.repos.UserRepo;
import ru.chnr.vn.tinkbotclientservice.services.BotService;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepo userRepository;
    @Autowired
    BotService botService;

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String , Object> model){
        User userFromDb = userRepository.findByUserName(user.getUserName());
        long botId;

        if(userFromDb != null){
            model.put("message", "User alresdy exists!");
            return "registration";
        }

        try{
            botId = botService.createBot(user.getToken());
        }catch(Exception e){
            model.put("message", "Something goes wrong while creating bot");
            return "registration";
        }

        user.setBotId(botId);
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepository.save(user);

        return "redirect:/login";
    }
}
