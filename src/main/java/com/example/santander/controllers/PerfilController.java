package com.example.santander.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.santander.models.Perfil;
import com.example.santander.repositories.PerfilRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping("/api")
@Api(value = "profile", description = "Rest API for profile operations", tags = "Profile API")
@CrossOrigin(origins = "http://localhost:4200")
public class PerfilController {
	
	@Autowired
	PerfilRepository perfilRepository;
	
	@CrossOrigin(exposedHeaders="Access-Control-Allow-Origin")
	@GetMapping("/perfiles")
	@ApiOperation(value = "Display prfiles list", response = Perfil.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "The resource not found") })
	public List<Perfil> getAllPerfiles() {
		Sort sortByFechaNacDesc = new Sort(Sort.Direction.DESC, "fechaNac");
		return perfilRepository.findAll(sortByFechaNacDesc);
	}
	
	@PostMapping("/perfiles")
	public Perfil createPerfil(@Valid @RequestBody Perfil perfil) {
		return perfilRepository.save(perfil);
	}
	
	@GetMapping(value="/perfiles/{id}")
	public ResponseEntity<Perfil> getPerfilById(@PathVariable("id") String id) {
		return perfilRepository.findById(id)
				.map(perfil -> ResponseEntity.ok().body(perfil))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping(value="perfiles/{id}")
	public ResponseEntity<Perfil> updatePerfiles(@PathVariable("id") String id,
												   @Valid @RequestBody Perfil perfil) {
		return perfilRepository.findById(id)
				.map(perfilData -> {
					perfilData.setNombre(perfil.getNombre());
					perfilData.setAppPat(perfil.getAppPat());
					perfilData.setAppMat(perfil.getAppMat());
					
					Perfil updatePerfil = perfilRepository.save(perfilData);
					return ResponseEntity.ok().body(updatePerfil);
					
				}).orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping(value="/perfiles/{id}")
	public ResponseEntity<?> deletePerfil(@PathVariable("id") String id) {
		return perfilRepository.findById(id)
				.map(perfil -> {
					perfilRepository.deleteById(id);
					return ResponseEntity.ok().build();
				}).orElse(ResponseEntity.notFound().build());
	}
	
}
