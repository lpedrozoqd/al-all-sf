package edu.lpq.alallsf.services;

import java.util.List;
import java.util.Optional;

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
            .forEach(userRepository::save);
    }

    public List<Users> getAllUsers(){
        return userRepository.findAll();
    }

    public Users save(Users newUser){
        return userRepository.save(newUser);
    }

    public void delete(Long id){
        userRepository.delete(new Users(id));
    }

    public Users update(Users newUser, Long id) {
       return userRepository.findById(id)
                .map(
                    user -> {
                        user.setEmail(newUser.getEmail());
                        user.setBirthDate(newUser.getBirthDate());
                        user.setName(newUser.getName());
                        return userRepository.save(newUser);
                    }
                ).get();
    
    }
    

}
