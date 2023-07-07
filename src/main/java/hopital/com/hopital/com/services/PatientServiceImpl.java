package hopital.com.hopital.com.services;

import hopital.com.hopital.com.entities.Dto.PatientDTO;
import hopital.com.hopital.com.entities.Patient;
import hopital.com.hopital.com.execptions.InvalidPatientException;
import hopital.com.hopital.com.execptions.PatientNotFoundException;
import hopital.com.hopital.com.repository.PatientRepository;
import org.apache.commons.validator.routines.EmailValidator;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Transactional
@Service
public class PatientServiceImpl implements  IHospitalService<PatientDTO>, DtoService<PatientDTO,Patient>{

    private PatientRepository patientRepository;
    ModelMapper modelMapper;

    public PatientServiceImpl(PatientRepository patientRepository,ModelMapper modelMapper){
        this.patientRepository=patientRepository;
        this.modelMapper=modelMapper;
    }
    /**
     * enregistrer un patient
     * @param patient
     * @return
     * @throws InvalidPatientException
     * @throws PatientNotFoundException
     */
    @Override
    public PatientDTO addEntity(PatientDTO patientDTO) throws InvalidPatientException, PatientNotFoundException {
        if(Objects.isNull(patientDTO)){
            throw new PatientNotFoundException("une erreur est survenu");
        }
        //convertir en une Entité patient
        Patient patient=this.convertDtoToEntity(patientDTO);
        //Assigner l'id au Patient
        patient.setId(UUID.randomUUID().toString());

       // boolean isValidEmail= EmailValidator.getInstance().isValid(patient.getAdresse().getEmail());
        if(patient.getNom().length()<3&&patient.getPrenom().length()<3){
            throw new InvalidPatientException("veillez bien remplir les informations sur ce patient");
        }
        return this.convertEntiyToDTO(this.patientRepository.save(patient));
    }

    /**
     * rechercher un patient dans la base de donnée
     * @param id
     * @return
     * @throws PatientNotFoundException
     */
    @Override
    public PatientDTO findEntityById(String id) throws PatientNotFoundException {
       Patient patient=this.patientRepository.findById(id)
                 .orElseThrow(()->new PatientNotFoundException("ce patient n'existe pas"));
       return  this.convertEntiyToDTO(patient);
    }

    /**
     * supprimer un patient
     * @param id
     * @throws PatientNotFoundException
     */
    @Override
    public void deleteEntityById(String id) throws PatientNotFoundException {
        this.patientRepository.findById(id).orElseThrow(()->new PatientNotFoundException("ce patient n'existe pas"));
        this.patientRepository.deleteById(id);
    }
    /**
     * renvoyer la liste des patients
     * @return
     */
    @Override
    public List<PatientDTO> getAllEntity() {
        return this.patientRepository.findAll()
                .stream()
                .map(this::convertEntiyToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void updateEntity(String id, PatientDTO entyity) {

    }

    /**
     * rechercher un patient par son Nom
     * @param name
     * @return
     */
    @Override
    public PatientDTO findEntityByName(String name) throws PatientNotFoundException {
        Patient patient=this.patientRepository.findByNom(name);
        if(Objects.isNull(patient)){
            throw new PatientNotFoundException("ce patient n'existe pas");
        }
        return this.convertEntiyToDTO(patient);
    }

    /**
     * convertir un patient en patientDTO
     * @param patient
     * @return
     */
    @Override
    public PatientDTO convertEntiyToDTO(Patient patient) {
        return this.modelMapper.map(patient,PatientDTO.class);
    }

    /**convertir un patientDTO en patient
     * @param entityDto
     * @return
     */
    @Override
    public Patient convertDtoToEntity(PatientDTO patientDTO) {
        return this.modelMapper.map(patientDTO,Patient.class);
    }
}
