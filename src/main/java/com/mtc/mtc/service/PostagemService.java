package com.mtc.mtc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mtc.mtc.model.Postagem;
import com.mtc.mtc.repository.PostagemRepository;

@Service
public class PostagemService {
	private final PostagemRepository postagemRepository;

	public PostagemService(PostagemRepository postagemRepository) {
		super();
		this.postagemRepository = postagemRepository;
	}
	
	public List<Postagem> listarTodos(){
		return postagemRepository.findAll();
	}

	public Postagem buscaPostagemById(String id) {
		return postagemRepository.findById(id)
				.orElseThrow(()->new RuntimeException("Postagem não encontrado. ID: "+id));
	}

	public Postagem salvarPostagem(Postagem postagem) {
		return postagemRepository.save(postagem);
	}
	
	public void removePostagem(Postagem postagem) {
		postagemRepository.delete(postagem);
	}
	
	public void removePostagemById(String id) {
		postagemRepository.deleteById(id);
	}
	
}
