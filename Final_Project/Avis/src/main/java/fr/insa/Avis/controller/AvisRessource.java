package fr.insa.Avis.controller;

import fr.insa.Avis.model.*; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import BDD.SpecificMethod.AvisHelpSeekerDOA;
import BDD.SpecificMethod.AvisSuperUserDOA;
import BDD.SpecificMethod.AvisVolunteerDOA;

@RestController
@RequestMapping("/avis")
public class AvisRessource {
	
	//AvisHelpSeeker
	@PostMapping("/avishelseeker")
	public void createAvisHelpSeeker(@RequestBody AvisHelpSeeker avisHelpSeeker) {
		AvisHelpSeekerDOA.createAvisHelpSeeker(avisHelpSeeker);
	}
    @GetMapping("/avishelpseeker/{id}")
    public AvisHelpSeeker getAvisHelpSeeker(@PathVariable String id) {
        
        return AvisHelpSeekerDOA.getAvisHelpSeeker(id);
    }
    
    @PostMapping("/avishelpseeker/{rating}/{id}")
    public void updateAvisHelpSeeker(@PathVariable int rating, @PathVariable String id) {
    	AvisHelpSeekerDOA.updateAvisHelpSeekerRating(rating, id);
    }
    //AvisSuperUser
	@PostMapping("/avissuperuser")
	public void createAvisSuperUser(@RequestBody AvisSuperUser avisSuperUser) {
		AvisSuperUserDOA.createAvisSuperUser(avisSuperUser);
	}
    @GetMapping("/avissuperuser/{id}")
    public AvisSuperUser getAvisSuperUser(@PathVariable String id) {
       
        return AvisSuperUserDOA.getAvisSuperUser(id);
    }
    @PostMapping("/avissuperuser/{commentaire}/{id}")
    public void updateAvisSuperUser(@PathVariable String commentaire, @PathVariable String id) {
    	AvisSuperUserDOA.updateSuperUserCommentaire(commentaire, id);
    }
    
    //AvisVolunteer
	@PostMapping("/avisvolunteer")
	public void createAvisVolunteer(@RequestBody AvisVolunteer avisVolunteer) {
		AvisVolunteerDOA.createAvisVolunteer(avisVolunteer);
	}
    @GetMapping("/avisvolunteer/{id}")
    public AvisVolunteer getAvisVolunteer(@PathVariable String id) {

        return AvisVolunteerDOA.getAvisVolunteer(id);
    }
    
    @PostMapping("/avisvolunteer/{commentaire}/{utilisateur}")
    public void updateAvisVolunteer(@PathVariable String commentaire, @PathVariable String utilisateur) {
    	AvisVolunteerDOA.updateVolunteerCommentaire(commentaire, utilisateur);
    }
}

