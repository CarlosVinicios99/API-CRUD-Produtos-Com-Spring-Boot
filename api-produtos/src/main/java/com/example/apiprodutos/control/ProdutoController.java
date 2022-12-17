package com.example.apiprodutos.control;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
	
	@GetMapping(path = "/ola")
	public String ola() {
		return "ola";
	}
	
}
