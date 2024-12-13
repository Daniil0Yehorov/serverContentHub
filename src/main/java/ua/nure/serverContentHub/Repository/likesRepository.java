package ua.nure.serverContentHub.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ua.nure.serverContentHub.Entity.Likes;

public interface likesRepository extends JpaRepository<Likes,Long> {

}
