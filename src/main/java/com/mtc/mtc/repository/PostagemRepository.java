package com.mtc.mtc.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mtc.mtc.model.Postagem;


@Repository
public interface PostagemRepository extends MongoRepository<Postagem, String>{
	List<Postagem> findByTitulo(String titulo);
}
