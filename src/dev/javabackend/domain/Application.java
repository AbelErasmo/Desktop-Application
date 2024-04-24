package dev.javabackend.domain;

import javax.swing.JOptionPane;

public class Application {
	
	private static ICliente iCliente;
	
	public static void main(String[] args) {
		
		iCliente = new ClienteMap();
		
		String opcao = JOptionPane.showInputDialog(null, "Digite 1 para cadastro, 2 para consultar, 3 para excluir"
				+ " 4 para alterar ou 5 para sair do programa", 
				"Cadastro", JOptionPane.INFORMATION_MESSAGE);
		
		while (!isOpcaoValida(opcao)) {
			if("".equals(opcao)) {
				sair();
			}
			opcao = JOptionPane.showInputDialog(null, "Opção inválida digite 1 para cadastro, 2 para consultar, 3 para excluir"
				+ " 4 para alterar ou 5 para sair do programa", 
				"Cadastro", JOptionPane.INFORMATION_MESSAGE);
		}
		
		while (isOpcaoValida(opcao)) {
			if(isOpcaoSair(opcao)) {
				sair();
			} else if(isCadastro(opcao)) {
				String dados = JOptionPane.showInputDialog(null, "Digite os dados separados por vírgula, conforme exemplo:"
						+ " Nome, nuit, tell, genero, idade, numero, data de nascimento, morada", 
						"Cadastro", JOptionPane.INFORMATION_MESSAGE);
				cadastrar(dados);
			} else if(isConsultar(opcao)) {
				String dados = JOptionPane.showInputDialog(null, "Digite o NUIT", 
						"Consultar", JOptionPane.INFORMATION_MESSAGE);
				consultar(dados);
			} else if(isExcluir(opcao)) {
				String dados = JOptionPane.showInputDialog(null, "Digite o NUIT do cliente que pretende excluir", 
						"Excluir", JOptionPane.INFORMATION_MESSAGE);
				excluir(dados);
			}
			
			opcao = JOptionPane.showInputDialog(null, "Digite 1 para cadastro, 2 para consultar, 3 para excluir"
					+ " 4 para alterar ou 5 para sair do programa", 
					"Cadastro", JOptionPane.INFORMATION_MESSAGE);
		} 
		
	}
	
	
	private static void excluir(String dados) {

		iCliente.excluir(Long.parseLong(dados));
		JOptionPane.showMessageDialog(null,  "Cliente excluido com sucesso ", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
		
	}

	
	private static void consultar(String dados) {
		// Validar se for passado somente o NUIT
		Cliente cliente = iCliente.consultar(Long.parseLong(dados));
		
		if(cliente != null) {
			JOptionPane.showMessageDialog(null,  "Cliente encontrado " + cliente.toString(), "Sucesso", JOptionPane.INFORMATION_MESSAGE);
		} else { 
			JOptionPane.showMessageDialog(null,  "Cliente não encontrado ", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
		}
	}
 

	private static void cadastrar(String dados) {
		String [] dadosSeparados = dados.split(",");
		// Tentar validar se todos os campos estiverem preenchidos.
		// Se não estiverem, deve passar null no construtor onde o valor é nulo
		
		Cliente cliente = new Cliente(dadosSeparados[0], dadosSeparados[1], dadosSeparados[2], dadosSeparados[3], dadosSeparados[4], dadosSeparados[5], dadosSeparados[5], dadosSeparados[6]);
		Boolean isCadastrado = iCliente.cadastrar(cliente);
		
		if (isCadastrado) {
			JOptionPane.showMessageDialog(null,  "Cadastrado com suscesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null,  "Ja se encontra cadastrado", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private static boolean isCadastro(String opcao) {
		if("1".equals(opcao)) {
			return true;
		}
		return false;
	}
	
	private static boolean isConsultar(String opcao) {
		if("2".equals(opcao)) {
			return true;
		}
		return false;
	}

	private static boolean isExcluir(String opcao) {
		if("3".equals(opcao)) {
			return true;
		}
		return false;
	}

	private static boolean isOpcaoSair(String opcao) {
		if("5".equals(opcao)) {
			return true;
		}
		return false;
	}
	
	private static void sair() {
		JOptionPane.showMessageDialog(null,  "Encerrando o sistema", "Cadastro", JOptionPane.OK_OPTION);
		System.exit(0);
		
	}

	private static boolean isOpcaoValida(String opcao) {
		if("1".equals(opcao) || "2".equals(opcao) || "3".equals(opcao) 
				|| "4".equals(opcao) || "5".equals(opcao)) {
			return true;
		}
		return false;
	}

	

}
