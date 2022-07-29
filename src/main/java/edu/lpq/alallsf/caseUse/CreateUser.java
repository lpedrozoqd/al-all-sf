package edu.lpq.alallsf.caseUse;

import org.springframework.stereotype.Component;

import edu.lpq.alallsf.entity.Users;
import edu.lpq.alallsf.services.UserService;

@Component
public class CreateUser {
    private UserService userService;

    public CreateUser(UserService userService) {
        this.userService = userService;
    }

    public Users save(Users newUser){
        return userService.save(newUser);
    }
    
    
    
}
