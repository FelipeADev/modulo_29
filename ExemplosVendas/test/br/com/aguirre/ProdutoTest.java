package br.com.aguirre;
import br.com.faguirre.dao.IProdutoDAO;
import br.com.faguirre.dao.ProdutoDAO;
import br.com.faguirre.domain.Produto;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class ProdutoTest {

    private IProdutoDAO produtoDAO;

    @Test
    public void cadastrarTest() throws Exception{
        IProdutoDAO dao = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("01");
        produto.setNome("Felipe Aguirre");

        Integer qtd = dao.cadastrar(produto);
        assertTrue(qtd == 1);

        Produto produtoBD = dao.consultar(produto.getCodigo());
        assertNotNull(produtoBD);
        assertNotNull(produtoBD.getId());
        assertEquals(produto.getCodigo(), produtoBD.getCodigo());
        assertEquals(produto.getNome(), produtoBD.getNome());
        assertNotNull(produtoBD);

        Integer qtdDel = dao.excluir(produtoBD);
        assertNotNull(qtdDel);
    }

    @Test
    public void consultarTest() throws Exception {
        produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("10");
        produto.setNome("Felipe Aguirre");
        Integer countCad = produtoDAO.cadastrar(produto);
        assertTrue(countCad == 1);

        Produto produtoBD = produtoDAO.consultar("10");
        assertNotNull(produtoBD);
        assertEquals(produto.getCodigo(), produtoBD.getCodigo());
        assertEquals(produto.getNome(), produtoBD.getNome());

        Integer countDel = produtoDAO.excluir(produtoBD);
        assertTrue(countDel == 1);
    }

    @Test
    public void excluirTest() throws Exception {
        produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("10");
        produto.setNome("Felipe Aguirre");
        Integer countCad = produtoDAO.cadastrar(produto);
        assertTrue(countCad == 1);

        Produto produtoBD = produtoDAO.consultar("10");
        assertNotNull(produtoBD);
        assertEquals(produto.getCodigo(), produtoBD.getCodigo());
        assertEquals(produto.getNome(), produtoBD.getNome());

        Integer countDel = produtoDAO.excluir(produtoBD);
        assertTrue(countDel == 1);
    }

    @Test
    public void buscarTodosTest() throws Exception {
        produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("10");
        produto.setNome("Felipe Aguirre");
        Integer countCad = produtoDAO.cadastrar(produto);
        assertTrue(countCad == 1);

        Produto produtos = new Produto();
        produtos.setCodigo("20");
        produtos.setNome("Teste");
        Integer countCad2 = produtoDAO.cadastrar(produtos);
        assertTrue(countCad2 == 1);

        List<Produto> list = produtoDAO.buscarTodos();
        assertNotNull(list);
        assertEquals(2, list.size());

        int countDel = 0;
        for (Produto prod : list) {
            produtoDAO.excluir(prod);
            countDel++;
        }
        assertEquals(list.size(), countDel);

        list = produtoDAO.buscarTodos();
        assertEquals(list.size(), 0);

    }

    @Test
    public void atualizarTest() throws Exception {
        produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("10");
        produto.setNome("Felipe Aguirre");
        Integer countCad = produtoDAO.cadastrar(produto);
        assertTrue(countCad == 1);

        Produto produtoBD = produtoDAO.consultar("10");
        assertNotNull(produtoBD);
        assertEquals(produto.getCodigo(), produtoBD.getCodigo());
        assertEquals(produto.getNome(), produtoBD.getNome());

        produtoBD.setCodigo("20");
        produtoBD.setNome("Outro nome");
        Integer countUpdate = produtoDAO.atualizar(produtoBD);
        assertTrue(countUpdate == 1);

        Produto produtoBD1 = produtoBD;
        assertNotNull(produtoBD1);

        Produto produtoBD2 = produtoBD1;
        assertNotNull(produtoBD2);
        assertEquals(produtoBD.getId(), produtoBD2.getId());
        assertEquals(produtoBD.getCodigo(), produtoBD2.getCodigo());
        assertEquals(produtoBD.getNome(), produtoBD2.getNome());

        List<Produto> list = produtoDAO.buscarTodos();
        for (Produto prod : list) {
            produtoDAO.excluir(prod);
            produtoDAO.excluir(prod);
        }
    }
}
