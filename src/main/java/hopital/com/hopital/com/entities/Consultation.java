package hopital.com.hopital.com.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.Date;

@Data
@Entity
@Table
@NoArgsConstructor @AllArgsConstructor
public class Consultation {

    @Id
    private String id;

    private Date date;

    private LocalTime heureDebut;

    private int duree;

    private String objet;

    @OneToOne(mappedBy = "consultation")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private RendezVous rendezVous;
}
