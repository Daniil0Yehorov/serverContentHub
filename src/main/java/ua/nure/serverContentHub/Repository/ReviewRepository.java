package ua.nure.serverContentHub.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.nure.serverContentHub.Entity.Review;

public interface ReviewRepository extends JpaRepository<Review,Long> {
}
