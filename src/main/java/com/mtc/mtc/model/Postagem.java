package com.mtc.mtc.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotNull;

@Document(collection = "postagem")
public class Postagem {
//	@Id
//	String id; //Removido pq o mongo cria e gerencia automaticamente
	@NotNull
	private String autor;
	@NotNull
	private String titulo;
	@NotNull
	private String texto;
	private List<String> imagens = new ArrayList<String>();

//	public String getId() {
//		return id;
//	}
//
//	public void setId(String id) {
//		this.id = id;
//	}

	public Postagem() {
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public List<String> getImagens() {
		return imagens;
	}

	public void setImagens(List<String> imagens) {
		this.imagens = imagens;
	}

//	public static Postagem toDTO(String json) {
//		return null;
//	}
//	
//	public static String toJSON(Postagem postagem) {
//		return null;
//	}
	
}
