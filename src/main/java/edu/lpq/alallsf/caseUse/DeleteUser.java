package edu.lpq.alallsf.caseUse;

import org.springframework.stereotype.Component;

import edu.lpq.alallsf.services.UserService;

@Component
public class DeleteUser {
    private UserService userService;

    public DeleteUser(UserService userService) {
        this.userService = userService;
    }

    public void remove(Long id){
        userService.delete(id);
    } 
}
