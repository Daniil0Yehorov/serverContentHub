package ua.nure.serverContentHub.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.nure.serverContentHub.Entity.profile;

public interface profileRepository  extends JpaRepository<profile,Long> {
    profile findById(int id);
}
