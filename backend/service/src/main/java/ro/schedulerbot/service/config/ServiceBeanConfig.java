package ro.schedulerbot.service.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({ "ro.schedulerbot.persistence.config", "ro.schedulerbot.service" })
public class ServiceBeanConfig {
	
}
