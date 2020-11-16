package com.ejemplo.mvc.negocio.RepositorioInterface;

import java.util.List;
import java.util.Optional;

import com.ejemplo.mvc.negocio.User;

public interface UserRepositoryInterface {
	public abstract Optional<User> findById(Long id);
	public abstract User findByName(String name);
	public abstract List<User> findAll();
	public abstract User save(User user);
	public abstract void deleteById(Long id);
	public abstract Long generateSequence();
}
