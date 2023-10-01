package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.EditorialesEntity;
import com.example.demo.repository.EditorialesRepository;
import com.example.demo.service.EditorialesService;
@Service
public class EditorialesServiceImpl implements EditorialesService{
	
	@Autowired
	private EditorialesRepository editorialesRepository;

	@Override
	public EditorialesEntity create(EditorialesEntity edit) {
		// TODO Auto-generated method stub
		return editorialesRepository.save(edit);
	}

	@Override
	public List<EditorialesEntity> readAll() {
		// TODO Auto-generated method stub
		return editorialesRepository.findAll();
	}

	@Override
	public EditorialesEntity update(EditorialesEntity edit) {
		// TODO Auto-generated method stub
		return editorialesRepository.save(edit);
	}

	@Override
	public void delete(Long id) {
		editorialesRepository.deleteById(id);
		// TODO Auto-generated method stub
		
	}

	@Override
	public EditorialesEntity read(Long id) {
		// TODO Auto-generated method stub
		return editorialesRepository.findById(id).get();
	}

}
