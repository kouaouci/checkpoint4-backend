package com.portfolio.portfolio.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.portfolio.portfolio.Dto.CompetencesDto;
import com.portfolio.portfolio.Model.Competences;
import com.portfolio.portfolio.service.CompetencesService;

@RestController
@RequestMapping("/portofolio/competences")
public class CompetencesController {
	@Autowired
	CompetencesService competencesService;

	 // Get All()
		@GetMapping
		public List<Competences> findAll() {
			return competencesService.findAll();
		}

	    // Get By Id()
		@GetMapping("/{id}")
		public Competences findOne(@PathVariable(required = true) Long id) {
			return competencesService.findOne(id);
		}
		// creer
		@PostMapping
		public Competences save(@Valid @RequestBody CompetencesDto competencesDto)
				throws IllegalStateException, IOException {
			return competencesService.save(competencesDto);
		}
		// Update()
		@PutMapping( path = "/{id}")
		public Competences update(@Valid CompetencesDto competencesDto, @RequestParam(required = false)
				@PathVariable(required = true) Long id) throws IllegalStateException, IOException {
			return competencesService.update(id,competencesDto);
		}
		
		
		//delete
		@DeleteMapping("/{id}")
		
		public void delete(@PathVariable(required = true) Long id) throws IOException {
			competencesService.delete(id);
		}
		
		
		

}
