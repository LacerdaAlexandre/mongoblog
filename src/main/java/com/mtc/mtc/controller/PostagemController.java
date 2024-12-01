package com.mtc.mtc.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mtc.mtc.model.Postagem;
import com.mtc.mtc.service.PostagemService;

@RestController
@RequestMapping("/postagem")
public class PostagemController {
	private final PostagemService postagemService;

	public PostagemController(PostagemService postagemService) {
		this.postagemService = postagemService;
	}
	
	@GetMapping
	public ResponseEntity<List<Postagem>> listarPostagens(){
		List<Postagem> postagens = postagemService.listarTodos();
		return ResponseEntity.ok(postagens);
	}
	
	@GetMapping("/id")
	public ResponseEntity<Postagem> buscaPostagemById(@PathVariable String id) {
		Postagem postagem= postagemService.buscaPostagemById(id);
		return ResponseEntity.ok(postagem);
	}
	
	@PostMapping
	public ResponseEntity<Postagem> salvarPostagem(@RequestBody Postagem postagem) {
		Postagem novaPostagem = postagemService.salvarPostagem(postagem);
		return ResponseEntity.ok(novaPostagem);
	}
	
	@PutMapping("/id")
	public ResponseEntity<Postagem> atualizaPostagem(@PathVariable String id, @RequestBody Postagem postagemAtualizada){
		Postagem postagem=postagemService.buscaPostagemById(id);
		postagem.setAutor(postagemAtualizada.getAutor());
		postagem.setTitulo(postagemAtualizada.getTitulo());
		postagem.setTexto(postagemAtualizada.getTexto());
		postagem.setImagens(postagemAtualizada.getImagens());
		Postagem postagemSalva = postagemService.salvarPostagem(postagem);
		
		return ResponseEntity.ok(postagemSalva);
	}
	
	@DeleteMapping("/id")
	public ResponseEntity<Void> removePostagemById(@PathVariable String id){
		postagemService.removePostagemById(id);
		return ResponseEntity.noContent().build();
	}
}
