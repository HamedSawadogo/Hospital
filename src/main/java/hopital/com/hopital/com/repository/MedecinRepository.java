package hopital.com.hopital.com.repository;

import hopital.com.hopital.com.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedecinRepository extends JpaRepository<Medecin,String> {
}
