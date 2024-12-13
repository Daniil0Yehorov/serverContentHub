package ua.nure.serverContentHub.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.nure.serverContentHub.Entity.Tags;

public interface tagsRepository extends JpaRepository<Tags,Long> {
    Tags findByName(String name);
}
