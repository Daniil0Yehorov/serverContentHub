package ua.nure.serverContentHub.ServiceInterface;

import jakarta.jws.WebService;
import ua.nure.serverContentHub.Entity.User;


@WebService(targetNamespace = "http://ServiceImplementation.serverContentHub.nure.ua/")
public interface AuthService {
    //реєстрація користувача у системі
    void save(User user);
    //оновлення даних про користувача
    User update(User user);
    //авторизація
    User login(String login, String password);
}
