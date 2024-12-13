package ua.nure.serverContentHub.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.nure.serverContentHub.Entity.User;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByLogin(String login);
    User findById(int id);
    @Query("SELECT u FROM User u WHERE u.login = :login AND u.Password = :Password")
    User findByLoginAndPassword(String login, String Password);
    @Query("SELECT u FROM User u WHERE u.Email = :Email")
    User findByEmail(String Email);
}
