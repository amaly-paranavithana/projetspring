package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import metier.Adresse;
import metier_martial.Adherent;
import repository.AdherentRepository;
import repository.AdresseRepository;


	
	@Service
	public class AdresseService {

		@Autowired
		private AdresseRepository adresseRepository;
		

		public boolean insert(Adresse adresse) {
			if (adresse.getId() == null || adresse.getId() != 0) {
				return false;
			}
			adresseRepository.save(adresse);
			return true;
		}

		public void delete(Adresse adresse) {
		Optional<Adresse> opt = adresseRepository.findById(adresse.getId());
		if (opt.isPresent()) {
			adresseRepository.delete(opt.get());
		}
		}

	
		public void update(Adresse adresse) {

			Optional<Adresse> opt = adresseRepository.findById(adresse.getId());
			if (opt.isPresent()) {
				adresseRepository.save(opt.get());
				
			}
			
		}

		
	

}
