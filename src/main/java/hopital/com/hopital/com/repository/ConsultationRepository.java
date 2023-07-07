package hopital.com.hopital.com.repository;

import hopital.com.hopital.com.entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultationRepository extends JpaRepository<Consultation,String> {
}
