package hopital.com.hopital.com.entities.Dto;

import hopital.com.hopital.com.entities.Adresse;
import hopital.com.hopital.com.entities.Medecin;
import hopital.com.hopital.com.entities.RendezVous;
import hopital.com.hopital.com.enums.Sexe;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor @AllArgsConstructor
public class PatientDTO extends PersonneDTO{

    private Date dateNais;
    @Enumerated(EnumType.STRING)
    private Sexe sexe;

}
