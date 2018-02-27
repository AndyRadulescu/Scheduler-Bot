package ro.schedulerbot.service.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({ "com.intech.hwlmonitor.persistence.config", "com.intech.hwlmonitor.service" })
public class ServiceBeanConfig {
	
}
