package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.AutoresEntity;
import com.example.demo.repository.AutoresRepository;
import com.example.demo.service.AutoresService;
@Service
public class AutoresServiceImpl implements AutoresService{
	
	@Autowired
	private AutoresRepository autoresRepository;

	@Override
	public AutoresEntity create(AutoresEntity auto) {
		// TODO Auto-generated method stub
		return autoresRepository.save(auto);
	}

	@Override
	public List<AutoresEntity> readAll() {
		// TODO Auto-generated method stub
		return autoresRepository.findAll();
	}

	@Override
	public AutoresEntity update(AutoresEntity auto) {
		// TODO Auto-generated method stub
		return autoresRepository.save(auto);
	}

	@Override
	public void delete(Long id) {
		autoresRepository.deleteById(id);
		// TODO Auto-generated method stub
		
	}

	@Override
	public AutoresEntity read(Long id) {
		// TODO Auto-generated method stub
		return autoresRepository.findById(id).get();
	}

}
