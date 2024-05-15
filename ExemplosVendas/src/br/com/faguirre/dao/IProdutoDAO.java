package br.com.faguirre.dao;


import br.com.faguirre.domain.Produto;

import java.util.List;

public interface IProdutoDAO {

    public Integer cadastrar(Produto produto) throws Exception;

    public Integer atualizar(Produto produto) throws Exception;

    public Produto consultar(String codigo) throws Exception;

    public Integer excluir(Produto produtoBD) throws Exception;

    public List<Produto> buscarTodos() throws Exception;
}
