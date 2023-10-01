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

import com.example.demo.entity.EditorialesEntity;
import com.example.demo.service.EditorialesService;

import static com.example.demo.commons.GlobalConstants.API_EDITORIALES;





@RestController
@RequestMapping(API_EDITORIALES)
public class EditorialesController {

	@Autowired
	private EditorialesService editorialesService;

	@GetMapping("/all")
	public List<EditorialesEntity> listar() {
		return editorialesService.readAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<EditorialesEntity> listar2(@PathVariable("id") long id) {
		EditorialesEntity edit = editorialesService.read(id);
		if (edit!=null) {
			return new ResponseEntity<>(edit, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/add")
	  public ResponseEntity<EditorialesEntity> createTutorial(@Valid @RequestBody EditorialesEntity l) {
	    try {
	    	EditorialesEntity edit = editorialesService.create(l);

	      return new ResponseEntity<>(edit, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	@PutMapping("/editar/{id}")
	  public ResponseEntity<EditorialesEntity> updateTutorial(@PathVariable("id") long id, @RequestBody EditorialesEntity edit) {
		EditorialesEntity editoriales = editorialesService.read(id);

	    if (editoriales!=null) {
	    	editoriales.setId(edit.getId());
	    	editoriales.setEditorial(edit.getEditorial());
	    	
	      return new ResponseEntity<>(editorialesService.create(editoriales), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	@DeleteMapping("/delete/{id}")
	  public ResponseEntity<HttpStatus> deleteEditoriales(@PathVariable("id") long id) {
	    try {
	    	editorialesService.delete(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

}