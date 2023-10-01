package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.LectoresEntity;
import com.example.demo.repository.LectoresRepository;
import com.example.demo.service.LectoresService;
@Service
public class LectoresServiceImpl implements LectoresService{
	
	@Autowired
	private LectoresRepository lectoresRepository;

	@Override
	public LectoresEntity create(LectoresEntity lect) {
		// TODO Auto-generated method stub
		return lectoresRepository.save(lect);
	}

	@Override
	public List<LectoresEntity> readAll() {
		// TODO Auto-generated method stub
		return lectoresRepository.findAll();
	}

	@Override
	public LectoresEntity update(LectoresEntity lect) {
		// TODO Auto-generated method stub
		return lectoresRepository.save(lect);
	}

	@Override
	public void delete(Long id) {
		lectoresRepository.deleteById(id);
		// TODO Auto-generated method stub
		
	}

	@Override
	public LectoresEntity read(Long id) {
		// TODO Auto-generated method stub
		return lectoresRepository.findById(id).get();
	}

}
