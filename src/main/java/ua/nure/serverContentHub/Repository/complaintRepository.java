package ua.nure.serverContentHub.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.nure.serverContentHub.Entity.Complaint;

public interface complaintRepository extends JpaRepository<Complaint,Long> {

}
