package ua.nure.serverContentHub.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.nure.serverContentHub.Entity.user;

public interface UserRepository extends JpaRepository<user,Long> {
}
