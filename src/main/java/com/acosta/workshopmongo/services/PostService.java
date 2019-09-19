package com.acosta.workshopmongo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acosta.workshopmongo.domain.Post;
import com.acosta.workshopmongo.exception.ObjectNotFoundException;
import com.acosta.workshopmongo.repository.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	
	public Optional<Post> findById(String id) {
		Optional<Post> user = repo.findById(id);
		if (user == null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
	}
	
	return user;
	
}
	
	public List<Post> findByTitle(String text) {
		return repo.serchTitle(text);
}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return repo.fullSearch(text, minDate, maxDate);



	}
}
