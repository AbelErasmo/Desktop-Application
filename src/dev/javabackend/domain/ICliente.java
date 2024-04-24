package dev.javabackend.domain;

import java.util.Collection;

public interface ICliente {
	
	public Boolean cadastrar(Cliente cliente);
	
	public void excluir (Long nuit);
	
	public void alterar(Cliente cliente);
	
	public Cliente consultar(Long nuit);
	
	public Collection<Cliente> buscarTodos();

}
