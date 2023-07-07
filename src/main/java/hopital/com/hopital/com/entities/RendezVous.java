package hopital.com.hopital.com.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.Date;

@Data
@Table
@Entity
@NoArgsConstructor @AllArgsConstructor
public class RendezVous {

    @Id
    private String id;

    private LocalTime  heure;
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    private Medecin medecin;

    @OneToOne
    private Consultation consultation;
}
