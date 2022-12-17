package com.example.apiprodutos.control;


import com.example.apiprodutos.model.entities.Produto;
import com.example.apiprodutos.model.repositories.ProdutoRepository;

import jakarta.validation.Valid;

import java.util.Optional;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	
	//CREATE
	@PostMapping
	public Produto inserirNovoProduto(@Valid Produto produto) {
		produtoRepository.save(produto);
		return produto;
	}
	
	//READ 1
	@GetMapping(path = "id/{id}")
	public Optional<Produto> consultarProdutoPorId(@PathVariable int id) {
		return produtoRepository.findById(id);
	}
	
	//READ 2
	@GetMapping(path = "/nome/{nome}")
	public Iterable<Produto> consultarProdutoPorNome(@PathVariable String nome){
		return produtoRepository.findByNomeContaining(nome);
	}
	
	//UPDATE
	@PutMapping
	public @ResponseBody Produto atualizarProduto(@Valid Produto produto){
		produtoRepository.save(produto);
		return produto;
	}
	
	//DELETE
	@DeleteMapping(path = "/{id}")
	public void removerProdutoPorId(@PathVariable int id) {
		produtoRepository.deleteById(id);
	}
}
