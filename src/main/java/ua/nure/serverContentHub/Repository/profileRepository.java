package ua.nure.serverContentHub.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.nure.serverContentHub.Entity.Profile;

public interface profileRepository  extends JpaRepository<Profile,Long> {
    Profile findById(int id);
}
