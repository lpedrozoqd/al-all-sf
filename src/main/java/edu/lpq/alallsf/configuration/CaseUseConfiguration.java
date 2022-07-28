package edu.lpq.alallsf.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import edu.lpq.alallsf.caseUse.GetUser;
import edu.lpq.alallsf.caseUse.GetUserImplement;
import edu.lpq.alallsf.services.UserService;

@Configuration
public class CaseUseConfiguration {
    @Bean
    GetUser getUser(UserService userService){
        return new GetUserImplement(userService);
    }
    
}
