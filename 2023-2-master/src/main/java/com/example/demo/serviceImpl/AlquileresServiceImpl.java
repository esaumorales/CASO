package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.AlquileresEntity;
import com.example.demo.repository.AlquileresRepository;
import com.example.demo.service.AlquileresService;
@Service
public class AlquileresServiceImpl implements AlquileresService{
	
	@Autowired
	private AlquileresRepository alquileresRepository;

	@Override
	public AlquileresEntity create(AlquileresEntity alqu) {
		// TODO Auto-generated method stub
		return alquileresRepository.save(alqu);
	}

	@Override
	public List<AlquileresEntity> readAll() {
		// TODO Auto-generated method stub
		return alquileresRepository.findAll();
	}

	@Override
	public AlquileresEntity update(AlquileresEntity alqu) {
		// TODO Auto-generated method stub
		return alquileresRepository.save(alqu);
	}

	@Override
	public void delete(Long id) {
		alquileresRepository.deleteById(id);
		// TODO Auto-generated method stub
		
	}

	@Override
	public AlquileresEntity read(Long id) {
		// TODO Auto-generated method stub
		return alquileresRepository.findById(id).get();
	}

}
