package ua.nure.serverContentHub.ServiceInterface;


import jakarta.jws.WebService;
import ua.nure.serverContentHub.Entity.user;


/**
 * 	Реєстрація
 * 	Авторизація
 * 	Вихід з облікового запису
 */

@WebService(targetNamespace = "http://ServiceImplementation.serverContentHub.nure.ua/")
public interface AuthService {
    //реєстрація користувача у системі
    void save(user user);
    //оновлення даних про користувача
    user update(user user);
    //авторизація
    user login(String login, String password);

}
