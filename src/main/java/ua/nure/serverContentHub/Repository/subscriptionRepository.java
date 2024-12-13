package ua.nure.serverContentHub.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.nure.serverContentHub.Entity.Subscription;

public interface subscriptionRepository extends JpaRepository<Subscription,Long> {

    Subscription findByCreator_IdAndUser_Id(int creatorId, int UserId);
}
