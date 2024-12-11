package ua.nure.serverContentHub;

import jakarta.xml.ws.Endpoint;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import ua.nure.serverContentHub.Entity.Enum.Role;
import ua.nure.serverContentHub.Entity.Enum.User_Status;
import ua.nure.serverContentHub.Entity.user;
import ua.nure.serverContentHub.ServiceImplementation.AuthServiceImpl;

import java.time.LocalDateTime;
import java.util.Date;

@SpringBootApplication
public class ServerUaContentHubApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerUaContentHubApplication.class, args);
	}
	@Bean
	public CommandLineRunner publishWebService(AuthServiceImpl authService) {
		return args -> {
			Endpoint.publish("http://localhost:8082/ws/auth?wsdl", authService);

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
		};
	}
}
