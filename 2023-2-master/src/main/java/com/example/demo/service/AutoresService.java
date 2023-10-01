package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.AutoresEntity;

public interface AutoresService{
	AutoresEntity create(AutoresEntity auto);
	AutoresEntity update(AutoresEntity auto);
	void delete(Long id);
	AutoresEntity read(Long id);
	List<AutoresEntity> readAll();

}
