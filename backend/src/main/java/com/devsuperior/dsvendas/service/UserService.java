package com.devsuperior.dsvendas.service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsvendas.dto.UserDTO;
import com.devsuperior.dsvendas.entities.User;
import com.devsuperior.dsvendas.repositories.UserRepository;


@Service
// objeto de servico 
public class UserService {
	
	// declarar a dependencia com repositoriouserRepository
	@Autowired
	private UserRepository userRepository;
	
	//criar um metodo para retornar uma lista deuser, retorna lista sem paginacao
	@Transactional(readOnly = true)
	public Page<UserDTO> findAll(Pageable pageable) {
		//para retornar uma lista deuser
		Page<User> result =userRepository.findAll(pageable );
		return result.map(x -> new UserDTO());
	}
	
	@Transactional(readOnly=true)
	public List<UserDTO> findByEmailContaining(String email){
		//para retornar uma lista deuser
				List<User> result =userRepository.getUserEmailContaining(email);
				return result.stream().map(x -> new UserDTO()).collect(Collectors.toList());
	}

	@Transactional(readOnly=true)
	public Optional<Object> findById(Long id) {
		Optional<User> result =userRepository.findById(id);
		return result.map(x -> new UserDTO());
	}

	public List<UserDTO> findByAll() {
		//para retornar uma lista deuser
		List<User> result =userRepository.findAll();
		return result.stream().map(x -> new UserDTO()).collect(Collectors.toList());
	}

	
	
	
 
	
	

	

	
	public List<UserDTO> findByEmail(String email) {
		//para retornar uma lista de artist
		List<User> result =userRepository.getUserEmailContaining(email);
		return result.stream().map(x -> new UserDTO()).collect(Collectors.toList());
}

 
	 
	
}
