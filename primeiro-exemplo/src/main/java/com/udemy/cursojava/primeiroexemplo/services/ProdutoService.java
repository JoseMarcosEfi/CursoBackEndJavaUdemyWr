package com.udemy.cursojava.primeiroexemplo.services;

import java.util.List;
import java.util.Optional;

import com.udemy.cursojava.primeiroexemplo.model.Produto;
import com.udemy.cursojava.primeiroexemplo.repository.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    /**
     * Metodo para Retornar uma lista de produtos
     * 
     * @return lista de produtos.
     */
    public List<Produto> obterTodos() {
        return produtoRepository.obterTodos();
    }

    /**
     * Metodo que retorna o produto encontrado pelo seu id
     * 
     * @param id do produto que sera localizado
     * @return Retorna um produto caso tenha encontrado.
     */
    public Optional<Produto> obterPorId(Integer id) {
        return produtoRepository.obterPorId(id);
    }

    /**
     * Metodo para adicionar produto na lista.
     * 
     * @param produto que ser adicionado.
     * @return Retorna o produto que foi adicionado na lista.
     */
    public Produto adicionar(Produto produto) {
        // poderia ter alguma regra de negocio para validar o produto.
        return produtoRepository.adicionar(produto);
    }

    /**
     * Metodo para deletar produto por id.
     * 
     * @param id do produto a ser deletado.
     */
    public void deletar(Integer id) {
        // aqui poderia ter alguma logica de validação.
        produtoRepository.deletar(id);
    }

    /**
     * Metodo para atualizar o produto na lista
     * 
     * @param produto que sera atualizado
     * @param id      do produto
     * @return Retorna o produto após atualizar a lista
     */
    public Produto atualizar(Integer id, Produto produto) {
        // ter alguma validação id
        produto.setId(id);

        return produtoRepository.atualizar(produto);
    }

}
