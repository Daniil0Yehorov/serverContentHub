package ua.nure.serverContentHub.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.nure.serverContentHub.Entity.review;

public interface reviewRepository extends JpaRepository<review,Long> {
}
