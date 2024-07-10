/**
 * 
 */
package br.com.faguire.dao;

import br.com.faguire.domain.Cliente;

/**
 * 
 */
public interface IClienteDAO {
	
		
	public Integer cadastrar(Cliente cliente) throws Exception;

	public Cliente consultar(String codigo) throws Exception;

	public Integer excluir(Cliente clienteBD) throws Exception;
}
