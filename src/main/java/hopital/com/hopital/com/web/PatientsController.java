package hopital.com.hopital.com.web;

import hopital.com.hopital.com.entities.Dto.PatientDTO;
import hopital.com.hopital.com.entities.Patient;
import hopital.com.hopital.com.execptions.InvalidPatientException;
import hopital.com.hopital.com.execptions.PatientNotFoundException;
import hopital.com.hopital.com.services.PatientServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientsController {

    PatientServiceImpl service;

    public  PatientsController(PatientServiceImpl service){
        this.service=service;
    }
    @GetMapping("/api/patients")
    public List<PatientDTO>getPatients(){
        return  this.service.getAllEntity();
    }
    @PostMapping("/api/patient")
    public ResponseEntity addPatient(@RequestBody PatientDTO patientDTO) {
        try {
            return ResponseEntity.ok().body(this.service.addEntity(patientDTO));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
