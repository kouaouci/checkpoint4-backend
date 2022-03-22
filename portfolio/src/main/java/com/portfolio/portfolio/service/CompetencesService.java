package com.portfolio.portfolio.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import com.portfolio.portfolio.Dto.CompetencesDto;
import com.portfolio.portfolio.Model.Competences;
import com.portfolio.portfolio.repository.Competencesrepository;

@Service
public class CompetencesService {
	@Autowired
	Competencesrepository competencesRepository;

	// recuperer la listes des competences
	public List<Competences> findAll() {
		return competencesRepository.findAll();
	}

// recuperer une competences avec son id
	public Competences findOne(Long id) {
		Optional<Competences> optEvents = competencesRepository.findById(id);
		if (optEvents.isPresent()) {
			return optEvents.get();
		} else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}

	// creer une competences
	public Competences save(CompetencesDto competencesDto)
			throws IllegalStateException {
		Competences competences = new Competences();
		competences.setName(competencesDto.getName());
		competences.setDescription(competencesDto.getDescription());
		competences.setType(competencesDto.getType());

		return competencesRepository.save(competences);

	}
	// modifier une competences

	public Competences update(Long id, CompetencesDto competencesDto) throws IOException {
		Optional<Competences> optCompetences = competencesRepository.findById(id);
		if (optCompetences.isPresent()) {
			
				Competences competences = optCompetences.get();
				competences.setName(competencesDto.getName());
				competences.setDescription(competencesDto.getDescription());

				competences.setType(competencesDto.getType());

				return competencesRepository.save(competences);}
			
		else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);

	}

	// supprimer une competences
	public void delete(Long id) throws IOException {
		Optional<Competences> optCompetences = competencesRepository.findById(id);
		if (optCompetences.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		Competences competences = optCompetences.get();

		competencesRepository.deleteById(id);
	}

}
