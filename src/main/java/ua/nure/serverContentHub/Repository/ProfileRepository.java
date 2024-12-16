package ua.nure.serverContentHub.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.nure.serverContentHub.Entity.Profile;
import ua.nure.serverContentHub.Entity.Tags;

import java.util.List;

public interface ProfileRepository extends JpaRepository<Profile,Long> {
    Profile findById(int id);
    List<Profile> findAll();
    @Query("SELECT p FROM Profile p JOIN p.phs ph WHERE ph.tags IN :tags")
    List<Profile> findAllByTags(@Param("tags") List<Tags> tags);
}
