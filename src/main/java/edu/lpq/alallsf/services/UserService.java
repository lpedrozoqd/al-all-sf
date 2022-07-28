package edu.lpq.alallsf.services;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype.Service;

import edu.lpq.alallsf.entity.Users;
import edu.lpq.alallsf.repository.UserRepository;

@Service
public class UserService {
    private final Log LOGGER = LogFactory.getLog(UserService.class);
    private UserRepository userRepository;
    
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void saveTransactional(List<Users> users){
        users.stream()
            .peek(user->LOGGER.info("Usuario insertado: " + user))
            .forEach(user -> userRepository.save(user));
    }

    public List<Users> getAllUsers(){
        return userRepository.findAll();
    }

    
}
