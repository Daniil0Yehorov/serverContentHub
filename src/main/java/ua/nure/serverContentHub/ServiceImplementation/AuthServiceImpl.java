package ua.nure.serverContentHub.ServiceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.nure.serverContentHub.Entity.Enum.Role;
import ua.nure.serverContentHub.Entity.profile;
import ua.nure.serverContentHub.Entity.user;
import ua.nure.serverContentHub.Repository.UserRepository;
import ua.nure.serverContentHub.Repository.profileRepository;
import ua.nure.serverContentHub.ServiceInterface.AuthService;
import jakarta.jws.WebService;


@WebService(endpointInterface = "ua.nure.serverContentHub.ServiceInterface.AuthService")
@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private profileRepository prRepository;
    @Override
    public void save(user user) {
        //ще більше помилок обробити і валідацію
        if (userRepository.findByLogin(user.getLogin()) != null) {
            throw new IllegalArgumentException("Користувач вже існує з подібним логіном.");
        }
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new IllegalArgumentException("Користувач вже існує з цією поштою.");
        }
        userRepository.save(user);
        //для креаторів створюється профіль
       if(user.getRole()== Role.creator) {
           profile newProfile = new profile();
           newProfile.setUser(user);
           newProfile.setDescription("....");
           user.setProfile(newProfile);
           prRepository.save(newProfile);}

    }
    @Override
    public user login(String login, String password) {
        //перевірки додати
        return userRepository.findByLoginAndPassword(login, password);
    }
    public user findById(int id) {
        //перевірки додати
        return userRepository.findById(id);
    }
    //в profileservice додати + оновлення профилю(для креаторів)
    public user update(user user) {
        //перевірки додати
        user existingUser = userRepository.findById(user.getId());
        existingUser.setPassword(user.getPassword());
        existingUser.setName(user.getName());
        existingUser.setLogin(user.getLogin());
        existingUser.setEmail(user.getEmail());
        return userRepository.save(existingUser);
    }

}
