package ro.schedulerbot.bot_handler.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"ro.schedulerbot.bot_handler", "ro.schedulerbot.service.config"})
public class BotHandlerConfig {

}
