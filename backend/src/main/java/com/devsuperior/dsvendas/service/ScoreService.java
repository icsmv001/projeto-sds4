package com.devsuperior.dsvendas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsvendas.dto.MovieDTO;
import com.devsuperior.dsvendas.dto.ScoreDTO;
import com.devsuperior.dsvendas.entities.Movie;
import com.devsuperior.dsvendas.entities.Score;
import com.devsuperior.dsvendas.entities.User;
import com.devsuperior.dsvendas.repositories.MovieRepository;
import com.devsuperior.dsvendas.repositories.ScoreRepository;
import com.devsuperior.dsvendas.repositories.UserRepository;

@Service
public class ScoreService {
	
	
	//metodo repository, que fara o acesso ao dados do banco, para repassar a camada de servico
	@Autowired
	private MovieRepository movieRepository;
	
	
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ScoreRepository scoreRepository;
	
	
	// metodo para salvar novo score no bd, a partir objeto scoreDTO criado no controlador
	// metodo saveScore
	@Transactional
	public MovieDTO saveScore(ScoreDTO dto) {
		
		
		User user = userRepository.findByEmail(dto.getEmail());
		
		// testa se usario existe sim ou nao
		if (user == null) {
			// se retorno null, nao existe no banco,
			// set valor novo para gravar no banco de dados
			user = new User();
			user.setEmail(dto.getEmail());
			//-------
			user = userRepository.saveAndFlush(user);
		}
		
		//objeto que recebe os dados do filme do banco de dado
	    Movie movie = movieRepository.findById(dto.getMovieID()).get();
	    
	    
	    // criar objeto score par receber os dados de user e movie
	    Score score = new Score();
	    score.setMovie(movie);
	    score.setUser(user);
	    // salvar a nota data para o filme
	    score.setValue(dto.getScore());
	    
	    
	    // salvando o objeto score no banco de dados
	    score = scoreRepository.saveAndFlush(score);
	    
	    //acessado a lista de scores de um filme e calculando o score medio
	    double sum = 0.0;
	    for (Score s : movie.getScores()) {
	    	// calculando soma de score
	    	sum = sum + s.getValue();
	    }
	    // media, divide a soma dos totais pela quantidade
	    double avg = sum / movie.getScores().size();
	    
		
		//salvar nova media e contagem 
	    movie.setScore(avg);
		movie.setCount(movie.getScores().size());
		
		// salvar no banco de dados
		movie = movieRepository.save(movie);
		return new  MovieDTO( movie);
		
		
	}

}
