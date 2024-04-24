package dev.javabackend.domain;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ClienteMap implements ICliente{
   
	private Map<Long, Cliente> map;
	
	public ClienteMap() {
		this.map = new HashMap<>();
	}
	
	
	@Override
	public Boolean cadastrar(Cliente cliente) {
		if(this.map.containsKey(cliente.getNuit())) {
			return false;
		}
		this.map.put(cliente.getNuit(), cliente);
		return true;
	}

	@Override
	public void excluir(Long nuit) {
		Cliente clienteCadastrar = this.map.get(nuit);
		
		if(clienteCadastrar != null)
			this.map.remove(clienteCadastrar.getNuit(), clienteCadastrar);
		
	}

	@Override
	public void alterar(Cliente cliente) {
		Cliente clienteCadastrado = this.map.get(cliente.getNuit());
		
		if(clienteCadastrado != null) {
			clienteCadastrado.setName(cliente.getName());
			clienteCadastrado.setDataNascimento(cliente.getDataNascimento());
			clienteCadastrado.setGenero(cliente.getGenero());
			clienteCadastrado.setIdade(cliente.getIdade());
			clienteCadastrado.setMorada(cliente.getMorada());
			clienteCadastrado.setNuit(cliente.getNuit());
			clienteCadastrado.setNumero(cliente.getNumero());
			clienteCadastrado.setTell(cliente.getTell());
		}
	}

	@Override
	public Cliente consultar(Long nuit) {
		return this.map.get(nuit);
	}

	@Override
	public Collection<Cliente> buscarTodos() {
		return this.map.values();
	}

}
