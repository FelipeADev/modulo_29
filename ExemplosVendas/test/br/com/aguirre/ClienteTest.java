package br.com.aguirre;

import br.com.faguirre.dao.ClienteDAO;
import br.com.faguirre.dao.IClienteDAO;
import br.com.faguirre.domain.Cliente;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ClienteTest {

    private IClienteDAO clienteDAO;

    @Test
    public void cadastrarTest() throws Exception{
        IClienteDAO dao = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("01");
        cliente.setNome("Felipe Aguirre");
        cliente.setCpf(123);

        Integer qtd = dao.cadastrar(cliente);
        assertTrue(qtd == 1);

        Cliente clienteBD = dao.consultar(cliente.getCodigo());
        assertNotNull(clienteBD);
        assertNotNull(clienteBD.getId());
        assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
        assertEquals(cliente.getNome(), clienteBD.getNome());
        assertEquals(cliente.getCpf(), clienteBD.getCpf());

        Integer qtdDel = dao.excluir(clienteBD);
        assertNotNull(qtdDel);
    }

    @Test
    public void consultarTest() throws Exception {
        clienteDAO = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("10");
        cliente.setNome("Felipe Aguirre");
        cliente.setCpf(123);

        Integer countCad = clienteDAO.cadastrar(cliente);
        assertTrue(countCad == 1);

        Cliente clienteBD = clienteDAO.consultar("10");
        assertNotNull(clienteBD);
        assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
        assertEquals(cliente.getNome(), clienteBD.getNome());
        assertEquals(cliente.getCpf(), clienteBD.getCpf());

        Integer countDel = clienteDAO.excluir(clienteBD);
        assertTrue(countDel == 1);
    }

    @Test
    public void excluirTest() throws Exception {
        clienteDAO = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("10");
        cliente.setNome("Felipe Aguirre");
        cliente.setCpf(123);

        Integer countCad = clienteDAO.cadastrar(cliente);
        assertTrue(countCad == 1);

        Cliente clienteBD = clienteDAO.consultar("10");
        assertNotNull(clienteBD);
        assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
        assertEquals(cliente.getNome(), clienteBD.getNome());
        assertEquals(cliente.getCpf(), clienteBD.getCpf());

        Integer countDel = clienteDAO.excluir(clienteBD);
        assertTrue(countDel == 1);
    }

    @Test
    public void buscarTodosTest() throws Exception {
        clienteDAO = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("10");
        cliente.setNome("Felipe Aguirre");
        cliente.setCpf(123);

        Integer countCad = clienteDAO.cadastrar(cliente);
        assertTrue(countCad == 1);

        Cliente clientes = new Cliente();
        clientes.setCodigo("20");
        clientes.setNome("Teste");
        clientes.setCpf(321);

        Integer countCad2 = clienteDAO.cadastrar(clientes);
        assertTrue(countCad2 == 1);

        List<Cliente> list = clienteDAO.buscarTodos();
        assertNotNull(list);
        assertEquals(2, list.size());

        int countDel = 0;
        for (Cliente cli : list) {
            clienteDAO.excluir(cli);
            countDel++;
        }
        assertEquals(list.size(), countDel);

        list = clienteDAO.buscarTodos();
        assertEquals(list.size(), 0);

    }

    @Test
    public void atualizarTest() throws Exception {
        clienteDAO = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("10");
        cliente.setNome("Felipe Aguirre");
        cliente.setCpf(123);

        Integer countCad = clienteDAO.cadastrar(cliente);
        assertTrue(countCad == 1);

        Cliente clienteBD = clienteDAO.consultar("10");
        assertNotNull(clienteBD);
        assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
        assertEquals(cliente.getNome(), clienteBD.getNome());
        assertEquals(cliente.getCpf(), clienteBD.getCpf());

        Integer countUpdate = clienteDAO.cadastrar(cliente);
        assertTrue(countUpdate == 1);

        clienteBD.setCodigo("20");
        clienteBD.setNome("Outro nome");
        cliente.setCpf(312);

        Cliente clienteBD1 = clienteBD;
        assertNotNull(clienteBD1);

        Cliente clienteBD2 = clienteBD1;
        assertNotNull(clienteBD2);
        assertEquals(clienteBD.getId(), clienteBD2.getId());
        assertEquals(clienteBD.getCodigo(), clienteBD2.getCodigo());
        assertEquals(clienteBD.getNome(), clienteBD2.getNome());
        assertEquals(clienteBD.getCpf(), clienteBD2.getCpf());

        List<Cliente> list = clienteDAO.buscarTodos();
        for (Cliente cli : list) {
            clienteDAO.excluir(cli);
        }
    }
}
