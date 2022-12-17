package com.example.apiprodutos.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apiprodutos.model.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
	
	public Iterable<Produto> findByNomeContaining(String nome);
	
}
