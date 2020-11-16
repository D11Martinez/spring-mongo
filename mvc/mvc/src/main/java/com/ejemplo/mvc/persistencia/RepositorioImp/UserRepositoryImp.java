package com.ejemplo.mvc.persistencia.RepositorioImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.ejemplo.mvc.negocio.User;
import com.ejemplo.mvc.negocio.RepositorioInterface.UserRepositoryInterface;
import com.ejemplo.mvc.persistencia.RepositorioMongo.UserRepository;
import com.ejemplo.mvc.persistencia.ServicioImp.SequenceGeneratorService;

@Component
@Primary
public class UserRepositoryImp implements UserRepositoryInterface {
    
	public static final String SEQUENCE_NAME = "users_sequence";
	
    @Autowired
    @Qualifier("userRepository")
	private UserRepository userRepository;
    
    @Autowired
	private SequenceGeneratorService sequenceGeneratorService;
    
	@Override
	public Optional<User> findById(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}

	@Override
	public User findByName(String name) {
		// TODO Auto-generated method stub
		return userRepository.findByName(name);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub		
		userRepository.deleteById(id);
		return;
	}

	@Override
	public Long generateSequence() {
		// TODO Auto-generated method stub
		return sequenceGeneratorService.generateSequence(SEQUENCE_NAME);
	}

}
