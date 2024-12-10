package ua.nure.serverContentHub.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.nure.serverContentHub.Entity.likes;

 public interface postRepository extends JpaRepository<likes,Long> {
}
