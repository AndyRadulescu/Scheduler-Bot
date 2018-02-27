package ro.schedulerbot.rest_controller.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"ro.schedulerbot.rest-controller", "ro.schedulerbot.service.config"})
public class RestBeanConfig {

}
