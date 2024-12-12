package ua.nure.serverContentHub.ServiceInterface;

import jakarta.jws.WebService;
import ua.nure.serverContentHub.Entity.profile;
import ua.nure.serverContentHub.Entity.user;

/**
 	Зміна даних профілю(з валідацією введених даних)
 	Перегляд профілю
 	Підписка на креаторів
 	Відписка від креаторі
 	Можливість кинути жалобу
 	Призначення тегів до профілю креатора(Адміністратор)
 */

@WebService(targetNamespace = "http://ServiceImplementation.serverContentHub.nure.ua/")
public interface ProfileService {
    //створення профілю у authservice функції save(user user);

    void placeTagsForProfile(int profileId,String[] tags);
    //оновлення даних профілю креатора. Креатор також може  використовувати оновлення користувача
    profile update(profile updatedProfile);

    //репорт на профіль. Репорт за пост, звісно буде в іншому сервісі
    void reportProfile(int profileid,int whoComplainedId,String reason);

    //трігери у бд зменшують або збільшують кількість підписок у профілі креатора
    void subscribeCreator(profile profileToSubscribe, user subscriber);

    void unsubscribeCreator(profile profileToUnsubscribe, user unsubscriber);

    //додатково
    profile getProfileByID(int id);
}
