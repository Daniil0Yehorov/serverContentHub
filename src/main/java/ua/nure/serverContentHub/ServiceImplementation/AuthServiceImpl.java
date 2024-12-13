package ua.nure.serverContentHub.ServiceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.nure.serverContentHub.Entity.Enum.Role;
import ua.nure.serverContentHub.Entity.Profile;
import ua.nure.serverContentHub.Entity.User;
import ua.nure.serverContentHub.Repository.UserRepository;
import ua.nure.serverContentHub.Repository.ProfileRepository;
import ua.nure.serverContentHub.ServiceInterface.AuthService;
import jakarta.jws.WebService;

import java.util.regex.Pattern;


@WebService(endpointInterface = "ua.nure.serverContentHub.ServiceInterface.AuthService")
@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProfileRepository prRepository;
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"
    );

    @Override
   public void save(User user) {
        if (user == null) {
            throw new IllegalArgumentException("Користувач не може бути null.");
        }

        if (user.getLogin() == null || user.getLogin().trim().isEmpty()) {
            throw new IllegalArgumentException("Логін не може бути порожнім.");
        }

        if (user.getPassword() == null || user.getPassword().length() < 6) {
            throw new IllegalArgumentException("Пароль повинен містити не менше 6 символів.");
        }

        if (user.getEmail() == null || !EMAIL_PATTERN.matcher(user.getEmail()).matches()) {
            throw new IllegalArgumentException("Невірний формат email.");
        }

        if (userRepository.findByLogin(user.getLogin()) != null) {
            throw new IllegalArgumentException("Користувач вже існує з подібним логіном.");
        }

        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new IllegalArgumentException("Користувач вже існує з цією поштою.");
        }

        if (user.getRole() == null) {
            throw new IllegalArgumentException("Роль користувача не може бути null.");
        }
        userRepository.save(user);
            //для креаторів створюється профіль
        if(user.getRole()== Role.creator) {
            Profile newProfile = new Profile();
            newProfile.setUser(user);
            newProfile.setDescription("....");
            user.setProfile(newProfile);
            prRepository.save(newProfile);}

    }
    @Override
    public User login(String login, String password) {
        if (login == null || login.trim().isEmpty()) {
            throw new IllegalArgumentException("Логін не може бути порожнім.");
        }

        if (password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("Пароль не може бути порожнім.");
        }

        User foundUser = userRepository.findByLoginAndPassword(login, password);

        if (foundUser == null) {
            throw new IllegalArgumentException("Невірний логін або пароль.");
        }
        return foundUser;
    }
    public User findById(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID користувача повинен бути більше 0.");
        }

        User foundUser = userRepository.findById(id);

        if (foundUser == null) {
            throw new IllegalArgumentException("Користувача з таким ID не знайдено.");
        }

        return foundUser;
    }

    public User update(User user) {
        if (user == null) {
            throw new IllegalArgumentException("Користувач не може бути null.");
        }

        User existingUser = userRepository.findById(user.getId());

        if (existingUser == null) {
            throw new IllegalArgumentException("Користувач з таким ID не знайдено.");
        }

        if (user.getLogin() != null && !user.getLogin().trim().isEmpty()) {
            existingUser.setLogin(user.getLogin());
        }

        if (user.getPassword() != null && user.getPassword().length() >= 6) {
            existingUser.setPassword(user.getPassword());
        } else if (user.getPassword() != null) {
            throw new IllegalArgumentException("Пароль повинен містити не менше 6 символів.");
        }

        if (user.getEmail() != null && EMAIL_PATTERN.matcher(user.getEmail()).matches()) {
            existingUser.setEmail(user.getEmail());
        } else if (user.getEmail() != null) {
            throw new IllegalArgumentException("Невірний формат email.");
        }

        if (user.getName() != null && !user.getName().trim().isEmpty()) {
            existingUser.setName(user.getName());
        }

        return userRepository.save(existingUser);
    }

}
