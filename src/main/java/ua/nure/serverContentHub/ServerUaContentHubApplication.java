package ua.nure.serverContentHub;

import jakarta.xml.ws.Endpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import ua.nure.serverContentHub.Entity.Enum.Role;
import ua.nure.serverContentHub.Entity.Enum.User_Status;
import ua.nure.serverContentHub.Entity.profile;
import ua.nure.serverContentHub.Entity.tags;
import ua.nure.serverContentHub.Entity.user;
import ua.nure.serverContentHub.Repository.tagsRepository;
import ua.nure.serverContentHub.ServiceImplementation.AuthServiceImpl;
import ua.nure.serverContentHub.ServiceImplementation.ProfileServiceImpl;

import java.time.LocalDateTime;
import java.util.Date;

@SpringBootApplication
public class ServerUaContentHubApplication {
	@Autowired
	private tagsRepository tagRepository;

	public static void main(String[] args) {
		SpringApplication.run(ServerUaContentHubApplication.class, args);
	}
	@Bean
	public CommandLineRunner publishWebService(AuthServiceImpl authService, ProfileServiceImpl profileService) {
		return args -> {
			Endpoint.publish("http://localhost:8082/ws/auth?wsdl", authService);
			Endpoint.publish("http://localhost:8083/ws/profile?wsdl", profileService);
			//креатор
			user user1 = new user();
			user1.setEmail("user1@example.com");
			user1.setLogin("user1");
			user1.setName("User One");
			user1.setPassword("password1");
			user1.setEmail("password1");
			user1.setRole(Role.creator);
			user1.setStatus(User_Status.active);
			LocalDateTime currentDate = LocalDateTime.now();
			System.out.println(currentDate);
			user1.setRegistrationDate(currentDate);

			authService.save(user1);
			//звичайний користувач
			user user = new user();
			user.setEmail("user2@example.com");
			user.setLogin("user2");
			user.setName("User Two");
			user.setPassword("password21");
			user.setEmail("password21");
			user.setRole(Role.user);
			user.setStatus(User_Status.active);
			LocalDateTime currentDate1 = LocalDateTime.now();
			System.out.println(currentDate1);
			user.setRegistrationDate(currentDate1);

			authService.save(user);

			//авторизація креатора
			user loggedInUser = authService.login("user1", "password1");
			System.out.println("Пользователь увійшов: " + loggedInUser.getName());

			//авторизація користувача
			user loggedInUser1 = authService.login("user2", "password21");
			System.out.println("Пользователь увійшов: " + loggedInUser1.getName());

			//оновлення креатора юзера
			user1.setName("Updated User One");
			authService.update(user1);
			System.out.println("Користувач оновлен");

			//з створенням креатора, створився профіль тому оновимо його

			profile profile1 = profileService.getProfileByID(user1.getId());
			profile1.setUser(user1);
			profile1.setDescription("This is a profile description");
			profileService.update(profile1);
			System.out.println("Профіль креатора оновлен:"+profile1.getUser().getName());

			//створення тегів до бд. поки не розроблен сервіс адміністратора, запишемо через репозиторій
 			tags tag=new tags();
			tag.setName("Tag1");
			tagRepository.save(tag);

			tags tag1=new tags();
			tag1.setName("Tag2");
			tagRepository.save(tag1);

			// Додавання тегу к профілю. (у веб-клієнта, така можливість буде
			// у адмііністратора який створює креаторів)
			String[] tags = {"Tag1", "Tag2"};
			profileService.placeTagsForProfile(profile1.getId(), tags);
			System.out.println("Teги додані");

			// підписуємо користувача до існуючого креатора
			profileService.subscribeCreator(profile1, user);
			System.out.println("користувач"+user.getName()+", підписався на креатора:"+profile1.getUser().getName());

			profileService.unsubscribeCreator(profile1, user);
			System.out.println("Пользователь отписался от креатора");

			// приклад репорта
			profileService.reportProfile(user1.getId(), user.getId(), "Inappropriate content");
			System.out.println("Жалоба на профіль відправлена");
		};
	}
}
