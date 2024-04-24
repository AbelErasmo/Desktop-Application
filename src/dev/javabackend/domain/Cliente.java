package dev.javabackend.domain;
import java.util.Objects;

public class Cliente {
	
	private String name;
	private Long nuit;
	private Long tell;
	private String genero;
	private int idade;
	private Integer numero;
	private String dataNascimento;
	private String morada;
	 
	public Cliente(String name, String nuit, String tell, String genero, String idade, String numero, String dataNascimento,
			String morada) {
		this.name = name;
		this.nuit = Long.valueOf(nuit.trim());
		this.tell = Long.valueOf(tell.trim());
		this.genero = genero;
		this.idade = Integer.valueOf(idade.trim());
		this.numero = Integer.valueOf(numero.trim());
		this.dataNascimento = dataNascimento;
		this.morada = morada;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getNuit() {
		return nuit;
	}

	public void setNuit(Long nuit) {
		this.nuit = nuit;
	}

	public Long getTell() {
		return tell;
	}

	public void setTell(Long tell) {
		this.tell = tell;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getMorada() {
		return morada;
	}

	public void setMorada(String morada) {
		this.morada = morada;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nuit);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(nuit, other.nuit);
	}

	@Override
	public String toString() {
		return "Cliente [name=" + name + ", nuit=" + nuit + "]";
	}

	

}
