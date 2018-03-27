package ro.schedulerbot.bot_handler_standalone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication(scanBasePackages = {"ro.schedulerbot.bot_handler.config"})
@PropertySource("classpath:application.properties")
public class BotHandlerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BotHandlerApplication.class, args);
	}
}
