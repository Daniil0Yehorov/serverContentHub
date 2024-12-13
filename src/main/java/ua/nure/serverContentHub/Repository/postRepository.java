package ua.nure.serverContentHub.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.nure.serverContentHub.Entity.Post;

public interface postRepository extends JpaRepository<Post,Long> {
}
