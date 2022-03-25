package com.udemy.cursojava.primeiroexemplo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.udemy.cursojava.primeiroexemplo.model.Produto;
import com.udemy.cursojava.primeiroexemplo.model.exception.ResourceNotFoundException;

import org.springframework.stereotype.Repository;

@Repository
public class ProdutoRepository {
    private ArrayList<Produto> produtos = new ArrayList<Produto>();
    private Integer ultimoId = 0;

    /**
     * Metodo para Retornar uma lista de produtos
     * 
     * @return lista de produtos.
     */
    public List<Produto> obterTodos() {
        return produtos;

    }

    /**
     * Metodo que retorna o produto encontrado pelo seu id
     * 
     * @param id do produto que sera localizado
     * @return Retorna um produto caso tenha encontrado.
     */
    public Optional<Produto> obterPorId(Integer id) {
        return produtos
                .stream()
                .filter(produto -> produto.getId() == id)
                .findFirst();
    }

    /**
     * Metodo para adicionar produto na lista.
     * 
     * @param produto que ser adicionado.
     * @return Retorna o produto que foi adicionado na lista.
     */
    public Produto adicionar(Produto produto) {
        ultimoId++;
        produto.setId(ultimoId);
        produtos.add(produto);
        return produto;
    }

    /**
     * Metodo para deletar produto por id.
     * 
     * @param id do produto a ser deletado.
     */
    public void deletar(Integer id) {
        produtos.removeIf(produto -> produto.getId() == id);
    }

    /**
     * Metodo para atualizar o produto na lista
     * 
     * @param produto que sera atualizado
     * @return Retorna o produto após atualizar a lista
     */
    public Produto atualizar(Produto produto) {
        // Encontrar o produto da lista
        Optional<Produto> produtoEncontrado = obterPorId(produto.getId());

        if (produtoEncontrado.isEmpty()) {
            throw new ResourceNotFoundException("Produto não encontrado");
        }
        // Eu tenho que remover o produto antigo da lista
        deletar(produto.getId());
        // Depois adicionar o novo produto
        produtos.add(produto);

        return produto;
    }
}
