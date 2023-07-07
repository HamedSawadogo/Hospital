package hopital.com.hopital.com.services;

import hopital.com.hopital.com.entities.Dto.PatientDTO;
import hopital.com.hopital.com.entities.Patient;
import hopital.com.hopital.com.execptions.InvalidPatientException;
import hopital.com.hopital.com.execptions.PatientNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IHospitalService<T> {

    /**
     * ajouter une entité dans la base de donnée
     * @param entity
     * @return
     */
    T addEntity(T entity) throws PatientNotFoundException, InvalidPatientException;

    /**
     * @param id
     * @return recuperer une entité par son Id
     */
    T findEntityById(String id) throws PatientNotFoundException;

    /**
     * supprimer une entité par son id
     * @param id
     */
    void deleteEntityById(String id) throws PatientNotFoundException;

    /**
     * @return renvoie la liste des entités
     */
    List<T>getAllEntity();

    /**
     * mettre a jour une entité
     * @param id
     * @param entyity
     */
    void updateEntity(String id,T entyity);

    /**
     * rechercher une entité par son Nom
     * @param name
     * @return
     */
    T findEntityByName(String name) throws PatientNotFoundException;

}
