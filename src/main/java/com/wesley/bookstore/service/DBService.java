package com.wesley.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wesley.bookstore.domain.Categoria;
import com.wesley.bookstore.domain.Livro;
import com.wesley.bookstore.repositories.CategoriaRepository;
import com.wesley.bookstore.repositories.LivroRepository;

@Service
public class DBService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private LivroRepository livroRepository;
	
	public void instanciaBaseDeDados() {
		Categoria cat1 = new Categoria(null, "desenvolvimento", "Livros de programação");
		Categoria cat2 = new Categoria(null, "inglês", "Livros de inglês");
		Categoria cat3 = new Categoria(null, "ficção científica", "Livros de ficção científica");
		
		Livro l1 = new Livro(null, "Clean code", "Robert Cecil Martin", "loren ipsun...", cat1);
		Livro l2 = new Livro(null, "Use a cabeça!: Java", "Kathy Sierra", "loren ipsun...", cat1);
		Livro l3 = new Livro(null, "Pratice Makes Perfect: Basic English", "Julia Lachance", "loren ipsun...", cat2);
		Livro l4 = new Livro(null, "Inglês na ponta da língua", "Denilso de Lima", "loren ipsun...", cat2);
		Livro l5 = new Livro(null, "Duna", "Frank Herbert", "loren ipsun...", cat3);
		
		cat1.getLivros().addAll(Arrays.asList(l1, l2));
		cat2.getLivros().addAll(Arrays.asList(l3, l4));
		cat3.getLivros().addAll(Arrays.asList(l5));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5));
	}

}
