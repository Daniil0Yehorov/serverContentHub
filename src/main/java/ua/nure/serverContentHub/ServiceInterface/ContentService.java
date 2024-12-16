package ua.nure.serverContentHub.ServiceInterface;

import jakarta.jws.WebService;
import ua.nure.serverContentHub.Entity.Profile;

import java.util.List;

@WebService(targetNamespace = "http://ServiceImplementation.serverContentHub.nure.ua/")
public interface ContentService {
    //пошук креаторів за тегами
    List<Profile> searchCreatorsByTags(List<String> tags);
    //перегляд креатора за айді
    Profile viewContent(int profileId);
    //Отримання усіх креаторів, задля подальшої фільтрації
    List<Profile> getAllCreators();
}
