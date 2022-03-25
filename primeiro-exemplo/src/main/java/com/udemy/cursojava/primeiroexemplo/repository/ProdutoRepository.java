package com.udemy.cursojava.primeiroexemplo.repository;

import com.udemy.cursojava.primeiroexemplo.model.Produto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
