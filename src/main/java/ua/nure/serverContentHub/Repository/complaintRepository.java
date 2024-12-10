package ua.nure.serverContentHub.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.nure.serverContentHub.Entity.complaint;

public interface complaintRepository extends JpaRepository<complaint,Long> {

}
