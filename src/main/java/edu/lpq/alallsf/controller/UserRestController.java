package edu.lpq.alallsf.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.lpq.alallsf.caseUse.CreateUser;
import edu.lpq.alallsf.caseUse.DeleteUser;
import edu.lpq.alallsf.caseUse.GetUser;
import edu.lpq.alallsf.caseUse.UpdateUser;
import edu.lpq.alallsf.entity.Users;


@RestController
@RequestMapping("/api/users")
public class UserRestController {
    private GetUser getUser;
    private CreateUser createUser;
    private DeleteUser deleteUser;
    private UpdateUser updateUser;
    
     

    // public UserRestController(GetUser getUser, CreateUser createUser, DeleteUser deleteUser, UpdateUser updateUser) {
    //     this.getUser = getUser;
    //     this.createUser = createUser;
    //     this.deleteUser = deleteUser;
    //     this.updateUser = updateUser;
    // }

    public UserRestController(GetUser getUser) {
        this.getUser = getUser;
    }

    @GetMapping(path="/")
    List<Users> get(){
        List<Users> usuarios = getUser.getAll();
        return usuarios;
    }

    @PostMapping(value="/")
    ResponseEntity<Users> newUser(@RequestBody Users newUser ){
        return new ResponseEntity(createUser.save(newUser), HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    ResponseEntity deleteUser(@PathVariable Long id ){
        deleteUser.remove(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); //204 es el código
    }

    @PutMapping("/{id}")
    ResponseEntity<Users> updateUser(@RequestBody Users newUser, @PathVariable Long id ){
        return new ResponseEntity<>(updateUser.update(newUser, id), HttpStatus.CREATED);
    }


   
}
