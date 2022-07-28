package edu.lpq.alallsf.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import edu.lpq.alallsf.caseUse.GetUser;
import edu.lpq.alallsf.entity.Users;


@RestController
@RequestMapping("/api/users")
public class UserRestController {
    private GetUser getUser;
    
    
    public UserRestController(GetUser getUser) {
        this.getUser = getUser;
    }

    @GetMapping(path="/"
   )

    List<Users> get(){
        List<Users> usuarios = getUser.getAll();
        return usuarios;
    }
    
}
