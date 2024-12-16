package ua.nure.serverContentHub;
import java.util.List;
import jakarta.xml.bind.JAXB;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import jakarta.xml.ws.Endpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ua.nure.serverContentHub.Entity.Enum.Role;
import ua.nure.serverContentHub.Entity.Enum.User_Status;
import ua.nure.serverContentHub.Entity.Profile;
import ua.nure.serverContentHub.Entity.Tags;
import ua.nure.serverContentHub.Entity.User;
import ua.nure.serverContentHub.Repository.TagsRepository;
import ua.nure.serverContentHub.ServiceImplementation.AuthServiceImpl;
import ua.nure.serverContentHub.ServiceImplementation.ContentServiceImpl;
import ua.nure.serverContentHub.ServiceImplementation.ProfileServiceImpl;

import java.io.File;
import java.time.LocalDateTime;

@SpringBootApplication
public class ServerUaContentHubApplication {
	@Autowired
	private TagsRepository tagRepository;

	public static void main(String[] args) {
		SpringApplication.run(ServerUaContentHubApplication.class, args);
	}
	@Bean
	public CommandLineRunner publishWebService(AuthServiceImpl authService,
											   ProfileServiceImpl profileService, ContentServiceImpl contentService) {
		return args -> {
			Endpoint.publish("http://localhost:8082/ws/auth?wsdl", authService);
			Endpoint.publish("http://localhost:8083/ws/profile?wsdl", profileService);
			Endpoint.publish("http://localhost:8084/ws/content?wsdl", contentService);
			//креатор
			User user1 = new User();
			user1.setEmail("exampl1e@domain.com");
			user1.setLogin("user1");
			user1.setName("Creator One");
			user1.setPassword("password1");
			user1.setRole(Role.CREATOR);
			user1.setStatus(User_Status.ACTIVE);
			LocalDateTime currentDate = LocalDateTime.now();
			System.out.println(currentDate);
			user1.setRegistrationDate(currentDate);
			authService.save(user1);
			//креатор
			User user11 = new User();
			user11.setEmail("exampl11e@domain.com");
			user11.setLogin("user11");
			user11.setName("Creator Two");
			user11.setPassword("password11");
			user11.setRole(Role.CREATOR);
			user11.setStatus(User_Status.ACTIVE);
			LocalDateTime currentDate11 = LocalDateTime.now();
			System.out.println(currentDate11);
			user11.setRegistrationDate(currentDate11);
			authService.save(user11);

			//звичайний користувач
			User user = new User();
			user.setEmail("example@domain.com");
			user.setLogin("user2");
			user.setName("User one");
			user.setPassword("password21");
			user.setRole(Role.USER);
			user.setStatus(User_Status.ACTIVE);
			LocalDateTime currentDate1 = LocalDateTime.now();
			System.out.println(currentDate1);
			user.setRegistrationDate(currentDate1);
			authService.save(user);
			//test маршалинг
			/*
			JAXBContext jaxBC= JAXBContext.newInstance(User.class);
			Marshaller jaxbm=jaxBC.createMarshaller();
			File xmlFile = new File("src/main/resources/static/tes.xml");
			jaxbm.marshal(user,System.out);
			jaxbm.marshal(user,xmlFile);
			authService.save(user);*/
			//анмаршалинг
			/*
			JAXBContext jaxbC=JAXBContext.newInstance(User.class);
			Unmarshaller jaxbU=jaxbC.createUnmarshaller();
			User user22= (User) jaxbU.unmarshal(xmlFile);
			System.out.println(user22);*/

			//авторизація креатора
			User loggedInUser = authService.login("user1", "password1");
			System.out.println("Пользователь увійшов: " + loggedInUser.getName());


			//авторизація користувача
			User loggedInUser1 = authService.login("user2", "password21");
			System.out.println("Пользователь увійшов: " + loggedInUser1.getName());

			//оновлення креатора юзера
			user1.setName("Updated Creator One");
			authService.update(user1);
			System.out.println("Користувач оновлен");

			//з створенням креатора, створився профіль тому оновимо його
			Profile profile1 = profileService.getProfileByID(user1.getId());
			Profile profile11 = profileService.getProfileByID(user11.getId());
			profile1.setUser(user1);
			profile1.setDescription("This is a profile description");
			profileService.update(profile1);
			System.out.println("Профіль креатора оновлен:"+profile1.getUser().getName());

			//створення тегів до бд. поки не розроблен сервіс адміністратора, запишемо через репозиторій
 			Tags tag=new Tags();
			tag.setName("Tag1");
			tagRepository.save(tag);

			Tags tag1=new Tags();
			tag1.setName("Tag2");
			tagRepository.save(tag1);

			// Додавання тегу к профілю. (у веб-клієнта, така можливість буде
			// у адмііністратора який створює креаторів)
			String[] tags = {"Tag1", "Tag2"};
			profileService.placeTagsForProfile(profile1.getId(), tags);
			System.out.println("Teги додані");
			profileService.placeTagsForProfile(profile11.getId(), tags);
			// підписуємо користувача до існуючого креатора
			profileService.subscribeCreator(profile1, user);
			System.out.println("користувач"+user.getName()+", підписався на креатора:"+profile1.getUser().getName());

			profileService.unsubscribeCreator(profile1, user);
			System.out.println("Користувач відписався від креатора");

			// приклад репорта
			profileService.reportProfile(user1.getId(), user.getId(), "Inappropriate content");
			System.out.println("Жалоба на профіль відправлена");

			// Пошук за тегами
			List<Profile> creatorsByTags = contentService.searchCreatorsByTags(List.of("Tag1", "Tag2"));
			System.out.println("Креаторы с тегом 'Tag1' i 'Tag2':");
			creatorsByTags.forEach(creator -> System.out.println(creator.getUser().getName()));

			Profile retrievedProfile = contentService.viewContent(profile1.getId());
			System.out.println("Контент профиля: " + retrievedProfile.getDescription());

			List<Profile> allCreators = contentService.getAllCreators();
			System.out.println("Список всех креаторов:");
			allCreators.forEach(creator -> System.out.println(creator.getUser().getName()));
		};
	}
}
