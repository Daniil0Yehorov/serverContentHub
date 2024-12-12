package ua.nure.serverContentHub.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.nure.serverContentHub.Entity.subscription;

public interface subscriptionRepository extends JpaRepository<subscription,Long> {
    /*@Query("SELECT s FROM subscription s WHERE s.creator.id = :CreatorID")
    subscription findByCreatorID(@Param("CreatorID") int CreatorID);
*/
    subscription findByCreator_Id(int CreatorID);
    subscription findByCreator_IdAndUser_Id(int creatorId, int UserId);
}
