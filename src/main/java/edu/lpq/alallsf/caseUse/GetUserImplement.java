package edu.lpq.alallsf.caseUse;
import java.util.List;
import edu.lpq.alallsf.entity.Users;
import edu.lpq.alallsf.services.UserService;

public class GetUserImplement implements GetUser{

    private UserService userService;


    public GetUserImplement(UserService userService) {
        this.userService = userService;
    }


    @Override
    public List<Users> getAll() {
        List<Users> usuarios = userService.getAllUsers();
        System.out.println("Usuarios.size()::" + usuarios.size());
        return usuarios;
    }
    
}
