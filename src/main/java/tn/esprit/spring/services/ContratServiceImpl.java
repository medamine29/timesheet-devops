package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.repository.ContratRepository;

@Service
public class ContratServiceImpl implements IContratService {

	
	@Autowired
	 ContratRepository contratRepository;
	
	


	private static final Logger l = LogManager.getLogger(ContratServiceImpl.class);
	
	@Override
	public List<Contrat> retrieveAllContrats() { 
		List<Contrat> contrats = null; 
		try {
			l.info("In retrieveAllContrats() : ");
			contrats = (List<Contrat>) contratRepository.findAll();  
			for (Contrat contrat : contrats) {
				l.debug("contrat +++ : ", contrat);
			} 
			l.info("Out of retrieveAllContrats() : ");

		}catch (Exception e) {
			l.error("Error in retrieveAllUsers() : ", e);
		}

		return contrats;
	}


	@Override
	public Contrat addContrat(Contrat c) {
		
		Contrat contratSaved = new Contrat();
		try {
			l.info("In addContrat() : ");
			contratSaved = contratRepository.save(c);
			l.debug("contrat added +++ : ", contratSaved);
			
			l.info("Out of addContrat() : ");

		}catch (Exception e) {
			l.error("Error in addContrat() : ", e);
		}
		
		return contratSaved;
	}


	@Override
	public Contrat updateContrat(Contrat c) {
		
		l.info("In updateContrat() : ");
		Contrat contratSaved = contratRepository.save(c);
		l.debug("contrat updated  +++ : ",contratSaved);

		l.info("Out of updateContrat() : ");
		return contratSaved;
	}

	
	@Override
	public Contrat retrieveContrat(String id) {
		Contrat contratRetrieved = null; 
		l.info("In retrieveContrat() : ");
		
		try{
			contratRetrieved = contratRepository.findById(Integer.parseInt(id)).get();
			l.debug("contrat retrieved  +++ : ", contratRetrieved);
			l.info("Out retrieveContrat() : ");

		}
		catch (Exception e) {
			l.error("Error in retrieveContrat() :: ",e);
		}
		
		return contratRetrieved;
	}
	
	@Override
	public void deleteContrat(String id) {

		l.info("In deleteContrat() : ");
		contratRepository.deleteById(Integer.parseInt(id));
		l.debug("contrat deleted with id: ", id);
		l.info("Out of deleteContrat() : ");
	}
}
