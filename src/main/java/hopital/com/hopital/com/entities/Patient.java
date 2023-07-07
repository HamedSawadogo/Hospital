package hopital.com.hopital.com.entities;

import hopital.com.hopital.com.enums.Sexe;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;

@Data
@Entity
@Table
@NoArgsConstructor @AllArgsConstructor
@DiscriminatorValue("PATIENT")
public class Patient extends  Personne{

      @Column(name = "date_naissance")
      private Date dateNais;

      @Enumerated(EnumType.STRING)
      private Sexe sexe;

      @OneToOne(orphanRemoval = true,cascade = CascadeType.ALL)
      private Adresse adresse;

      @OneToMany(mappedBy = "patient")
      private Collection<RendezVous>rendezVous;

      @ManyToOne
      private Medecin medecin;
}
