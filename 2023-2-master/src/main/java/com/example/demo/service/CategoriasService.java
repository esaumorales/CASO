package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.CategoriasEntity;

public interface CategoriasService{
	CategoriasEntity create(CategoriasEntity cate);
	CategoriasEntity update(CategoriasEntity cate);
	void delete(Long id);
	CategoriasEntity read(Long id);
	List<CategoriasEntity> readAll();

}
