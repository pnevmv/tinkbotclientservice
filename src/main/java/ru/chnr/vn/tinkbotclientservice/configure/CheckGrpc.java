package ru.chnr.vn.tinkbotclientservice.configure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.chnr.vn.tinkbotclientservice.controller.BotService;

@Configuration
public class CheckGrpc {
    private static final Logger log = LoggerFactory.getLogger(CheckGrpc.class);

    @Bean
    CommandLineRunner initDatabase(BotService botService) {
        return args -> {
            log.info("Bot id response: " + botService.createBot(228));
            log.info("Bot is deleted " + botService.deleteBot(1));
            log.info("Bot is deleted " + botService.deleteBot(10));
        };

    }
}