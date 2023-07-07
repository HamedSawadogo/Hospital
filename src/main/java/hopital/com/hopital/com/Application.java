package hopital.com.hopital.com;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class Application{

	/**
	 * renvoyer une instance de ModellMapper
	 * @return
	 */
	@Bean
	ModelMapper modelMapper(){
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}



		/**Patient patient=patientRepository.findAll().get(0);
		Medecin medecin=medecinRepository.findAll().get(0);
		medecin.setSpecialite(Speciality.GENERALISTE);
		patient.setMedecin(medecin);

		Patient patient1=patientService.addEntity(patient);

		medecin.getPatients().add(patient1);
		medecinRepository.save(medecin);**/

		/**Medecin medecin=medecinRepository.findAll().get(0);
		Patient patient=patientRepository.findAll().get(0);

		Consultation consultation=consultationRepository.findAll().get(1);
		RendezVous rendezVous=new RendezVous();
		rendezVous.setId(UUID.randomUUID().toString());
		rendezVous.setConsultation(consultation);
		rendezVous.setDate(new Date());
		rendezVous.setHeure(LocalTime.now());
		rendezVous.setPatient(patient);
		rendezVous.setMedecin(medecin);

		rendezVousRepository.save(rendezVous);
		patient.getRendezVous().add(rendezVous);
		medecin.getRendezVous().add(rendezVous);

		medecinRepository.save(medecin);
		patientRepository.save(patient);**/
		/**
		//enregistremet de l'adresse
		    Stream.of("Hassan","Ali","Mohamed","Limm")
					.forEach(name->{
						Adresse adresse=new Adresse();
						adresse.setId(UUID.randomUUID().toString());
						adresse.setVille("OUAGADOUGOU");
						adresse.setEmail(name+"773@gmail.com");
						String telephone=Math.random()*0.5>0?"67378883":"773893";
						adresse.setTelephone("+226"+telephone);
						this.adresseRepository.save(adresse);
					});
		 **/
		/**
			//Enregistrement du Patient
			Patient patient=new Patient();
			patient.setId(UUID.randomUUID().toString());
			patient.setNom("Hassan");
			patient.setPrenom("Bilal");
			Sexe sexe= Math.random()*2>.5?Sexe.M:Sexe.F;
			patient.setSexe(sexe);
			Adresse adresse1=this.adresseRepository.findAll().get(0);
			Adresse adresse2=adresseRepository.findById(adresse1.getId()).orElse(null);
			if(adresse2!=null){
				System.err.println(adresse2.getEmail());
				patient.setDateNais(new Date());
				patient.setAdresse(adresse2);
				patientRepository.save(patient);
			}else{
				System.err.println("Adresse Nulle");
			}
		 **/

		/**Stream.of("Ahmad","Ali","Killi","Osias")
				.forEach(name->{
					Medecin medecin=new Medecin();
					medecin.setId(UUID.randomUUID().toString());
					Speciality speciality=Math.random()*.5>0.06?Speciality.GENERALISTE:Speciality.PNEUMOLOGIE;
					medecin.setSpecialite(speciality);
					medecin.setNom(name);
					medecin.setPrenom("LasteNAme"+name);
					medecinRepository.save(medecin);
				});

		for (int i = 0; i <4; i++) {
			Consultation consultation=new Consultation();
			consultation.setId(UUID.randomUUID().toString());
			consultation.setDate(new Date());
			consultation.setDuree(60*i);
			consultation.setObjet("objet de la consultation ...."+i);
			consultation.setHeureDebut(LocalTime.now());
			consultationRepository.save(consultation);
		}**/

}
