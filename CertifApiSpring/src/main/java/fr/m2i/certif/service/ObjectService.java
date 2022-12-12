package fr.m2i.certif.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public abstract class ObjectService<T>  {
	
	@Autowired 
	protected JpaRepository<T, Long> classRepository;
	
	private Class<T> className;
	
	//GET List
	public List<T> getAll(){
		return classRepository.findAll();
	}
	
	//GET By Id
	public Optional<T> getById(Long id){
		Optional<T> className = classRepository.findById(id);
		return className;
	}
	
	//POST & PUT => save
	public void saveObject(T t) {
		classRepository.save(t);
	}
	
	//DELETE By Id
	public void deleteObject(Long id) {
		classRepository.deleteById(id);
	}
	
	
}
