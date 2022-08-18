package ru.chnr.vn.tinkbotclientservice.configure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.chnr.vn.tinkbotclientservice.services.BotService;

@Configuration
public class CheckGrpc {
    private static final Logger log = LoggerFactory.getLogger(CheckGrpc.class);
    @Value("${token}")
    String defaultToken;

    @Bean
    CommandLineRunner initDatabase(BotService botService) {
        return args -> {
            log.info("Created default bot: " + botService.createBot(defaultToken));
        };

    }
}