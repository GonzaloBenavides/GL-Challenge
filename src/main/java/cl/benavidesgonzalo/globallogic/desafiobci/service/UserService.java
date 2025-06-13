package cl.benavidesgonzalo.globallogic.desafiobci.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import cl.benavidesgonzalo.globallogic.desafiobci.model.Phone;
import cl.benavidesgonzalo.globallogic.desafiobci.model.User;
import cl.benavidesgonzalo.globallogic.desafiobci.model.UserRepo;
import cl.benavidesgonzalo.globallogic.desafiobci.util.JwtUtil;


// Aquí podría agregar un extends UserServiceInterface
@Service
public class UserService {

    @Autowired
    UserRepo repo;

    @Autowired
    JwtUtil jwt;

    @Autowired
    PasswordEncoder encoder;

    public String generateUserToken(User user){
        return jwt.generateToken(user.getName());
    }

    public User findUserByToken(String token){
        Optional<User> tokenUser = repo.findByToken(token);

        if(tokenUser.isPresent()){
            User user = tokenUser.get();
            if(jwt.validateToken(token, user.getName())){
                updateUserToken(user);
                return user;
            }
            else return null;
        }
        else return null;
    }

    public User addUser(User newUser){
        Optional<User> existe = repo.findByName(newUser.getName());
        if(existe.isPresent()) return null;
        else {
            for(Phone p : newUser.getPhones()){
                p.setUser(newUser);
            }

            newUser.setPassword(encoder.encode(newUser.getPassword()));
            newUser.setToken(this.generateUserToken(newUser));
            repo.save(newUser);
        }
        return newUser;
    }

    public void updateUserToken(User user){
        String newToken = jwt.generateToken(user.getName());
        user.setToken(newToken);
        repo.save(user);
    }
}
