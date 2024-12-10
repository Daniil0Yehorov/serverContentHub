package ua.nure.serverContentHub.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.nure.serverContentHub.Entity.subscription;

public interface subscriptionRepository extends JpaRepository<subscription,Long> {
}
