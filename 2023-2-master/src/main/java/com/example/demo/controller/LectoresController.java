package com.example.demo.controller;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.demo.commons.GlobalConstants.API_LECTORES;

import com.example.demo.entity.LectoresEntity;
import com.example.demo.service.LectoresService;



@RestController
@RequestMapping(API_LECTORES)
public class LectoresController {

	@Autowired
	private LectoresService lectoresService;

	@GetMapping("/all")
	public List<LectoresEntity> listar() {
		return lectoresService.readAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<LectoresEntity> listar2(@PathVariable("id") long id) {
		LectoresEntity lect =lectoresService.read(id);
		if (lect!=null) {
			return new ResponseEntity<>(lect, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/add")
	  public ResponseEntity<LectoresEntity> createTutorial(@Valid @RequestBody LectoresEntity l) {
	    try {
	    	LectoresEntity lect = lectoresService.create(l);

	      return new ResponseEntity<>(lect, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	@PutMapping("editar/{id}")
	  public ResponseEntity<LectoresEntity> updateTutorial(@PathVariable("id") long id, @RequestBody LectoresEntity lect) {
		LectoresEntity lectores = lectoresService.read(id);

	    if (lectores!=null) {
	    	lectores.setId(lect.getId());
	    	lectores.setNombre(lect.getNombre());
	    	lectores.setTelefono(lect.getTelefono());
	    	lectores.setDireccion(lect.getDireccion());
	    	lectores.setCodigoPostal(lect.getCodigoPostal());
	    	lectores.setObservaciones(lect.getObservaciones());
	    	
	      return new ResponseEntity<>(lectoresService.create(lectores), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	@DeleteMapping("/delete/{id}")
	  public ResponseEntity<HttpStatus> deleteDocumento(@PathVariable("id") long id) {
	    try {
	    	lectoresService.delete(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

}