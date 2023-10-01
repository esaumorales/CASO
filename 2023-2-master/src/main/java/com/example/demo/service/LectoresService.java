package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.LectoresEntity;

public interface LectoresService{
	LectoresEntity create(LectoresEntity lect);
	LectoresEntity update(LectoresEntity lect);
	void delete(Long id);
	LectoresEntity read(Long id);
	List<LectoresEntity> readAll();

}
