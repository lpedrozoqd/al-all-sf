package edu.lpq.alallsf.caseUse;

import java.util.Optional;

import org.springframework.stereotype.Component;

import edu.lpq.alallsf.entity.Users;
import edu.lpq.alallsf.services.UserService;

@Component
public class UpdateUser {
    private UserService userService;

    public UpdateUser(UserService userService) {
        this.userService = userService;
    }

    public Users update(Users newUser, Long id){
        return userService.update(newUser, id);
    }
    
}
