package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.LibrosEntity;
import com.example.demo.repository.LibrosRepository;
import com.example.demo.service.LibrosService;
@Service
public class LibrosServiceImpl implements LibrosService{
	
	@Autowired
	private LibrosRepository librosRepository;

	@Override
	public LibrosEntity create(LibrosEntity libr) {
		// TODO Auto-generated method stub
		return librosRepository.save(libr);
	}

	@Override
	public List<LibrosEntity> readAll() {
		// TODO Auto-generated method stub
		return librosRepository.findAll();
	}

	@Override
	public LibrosEntity update(LibrosEntity libr) {
		// TODO Auto-generated method stub
		return librosRepository.save(libr);
	}

	@Override
	public void delete(Long id) {
		librosRepository.deleteById(id);
		// TODO Auto-generated method stub
		
	}

	@Override
	public LibrosEntity read(Long id) {
		// TODO Auto-generated method stub
		return librosRepository.findById(id).get();
	}

}
