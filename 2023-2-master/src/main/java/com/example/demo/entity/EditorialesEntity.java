package com.example.demo.entity;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="EDITORIALES")
public class EditorialesEntity implements Serializable{
	private static final long serialVersionUID = -2170897015344177815L;

	@Id
	@Column(name = "IdEditorial")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
  
  	@Column(name = "EDITORIAL")
  	private String editorial;
  
  	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "editoriales")
	@JsonIgnore
	private Set<LibrosEntity> libros;
  	
}