package edu.lpq.alallsf.configuration;

import edu.lpq.alallsf.utils.UserData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * EnableConfigurationProperties = permite tomar los valores de dicha clase
 * */

@Configuration
@EnableConfigurationProperties(UserData.class)
@PropertySource("classpath:connection.properties")
public class GeneralConfiguration {

    @Value("${jdbc.url}")
    private String jdbcUrl;

    @Value("${jdbc.driver}")
    private String jdbcDriver;

    @Value("${jdbc.username}")
    private String jdbcUsername;
    
    @Value("${jdbc.password}")
    private String jdbcPassword;

    @Value("${value.name}")
    private String name;

    @Value("${value.apellido}")
    private String apellido;

    @Value("${value.random}")
    private String random;

    @Bean
    public DataSource dataSource(){
        DataSourceBuilder dsb = DataSourceBuilder.create();

        // Opcion #1 para setear valores:
        // dsb.driverClassName("org.h2.Driver");
        // dsb.url("jdbc:h2:mem:testdb");
        // dsb.username("sa");
        // dsb.password("");


        // Opcion #2 para setear valores:
        dsb.driverClassName(jdbcDriver);
        dsb.url(jdbcUrl);
        dsb.username(jdbcUsername);
        dsb.password(jdbcPassword);
        return dsb.build();
    }

    

}
