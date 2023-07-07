package hopital.com.hopital.com.entities.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public abstract class PersonneDTO {

    private String id;
    private String nom;
    private String prenom;
}
