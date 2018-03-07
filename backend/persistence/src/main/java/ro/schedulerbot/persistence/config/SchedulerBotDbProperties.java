package ro.schedulerbot.persistence.config;


import java.util.Optional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Configuration
@PropertySource("classpath:application.properties")
public class SchedulerBotDbProperties {
  
  @Value("${hibernate.hbm2ddl.auto}")
  private String hibernateAuto;

  @Value("${hibernate.show_sql}")
  private String hibernateShowSql;

  @Value("${hibernate.dialect}")
  private String hibernateDialect;

  @Value("${hibernate.check_nullability:#{null}}")
  private Optional<String> hibernateCheckNullability;
  
  @Value("${datasource.driverClassName}")
  private String jdbcDriverClassName;

  @Value("${datasource.url}")
  private String jdbcUrl;

  @Value("${datasource.username}")
  private String jdbcUsername;

  @Value("${datasource.password}")
  private String jdbcPassword;


}
