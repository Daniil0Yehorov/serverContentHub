package ua.nure.serverContentHub.ServiceInterface;

import jakarta.jws.WebService;
import ua.nure.serverContentHub.Entity.Profile;
import ua.nure.serverContentHub.Entity.User;



@WebService(targetNamespace = "http://ServiceImplementation.serverContentHub.nure.ua/")
public interface ProfileService {
    //створення профілю у authservice функції save(user user);

    void placeTagsForProfile(int profileId,String[] tags);
    //оновлення даних профілю креатора. Креатор також може  використовувати оновлення користувача
    Profile update(Profile updatedProfile);

    //репорт на профіль. Репорт за пост, звісно буде в іншому сервісі
    void reportProfile(int profileid,int whoComplainedId,String reason);

    //трігери у бд зменшують або збільшують кількість підписок у профілі креатора
    void subscribeCreator(Profile profileToSubscribe, User subscriber);

    void unsubscribeCreator(Profile profileToUnsubscribe, User unsubscriber);

    //додатково
    Profile getProfileByID(int id);
}
