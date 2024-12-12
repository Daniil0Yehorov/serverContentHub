package ua.nure.serverContentHub.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.nure.serverContentHub.Entity.user;

public interface UserRepository extends JpaRepository<user,Long> {
    user findByLogin(String login);
    user findById(int id);
    @Query("SELECT u FROM user u WHERE u.login = :login AND u.Password = :Password")
    user  findByLoginAndPassword(String login, String Password);
    @Query("SELECT u FROM user u WHERE u.Email = :Email")
   user findByEmail(String Email);
}
