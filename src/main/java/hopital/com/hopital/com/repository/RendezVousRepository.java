package hopital.com.hopital.com.repository;

import hopital.com.hopital.com.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RendezVousRepository extends JpaRepository<RendezVous,String> {
}
