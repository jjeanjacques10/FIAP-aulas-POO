package main;

import javax.swing.JOptionPane;

import dao.UsuarioDAO;
import model.Usuario;

public class Main {

	public static UsuarioDAO usuarioDao = new UsuarioDAO();

	public static void main(String[] args) {
		int id;
		String email;
		String senha;
		String text = "1. Listar \n 2. Inserir \n 3.Logar \n 4.Pesquisa \n 5.Sair";

		int op = Integer.parseInt(JOptionPane.showInputDialog(text));
		while (op != 6) {
			switch (op) {
			case 1:
				Listar();
				op = Integer.parseInt(JOptionPane.showInputDialog(text));
				break;
			case 2:
				id = Integer.parseInt(JOptionPane.showInputDialog("Inserir RM: "));
				email = JOptionPane.showInputDialog("Inserir Email: ");
				senha = JOptionPane.showInputDialog("Inserir Senha: ");
				Inserir(id, email, senha);
				op = Integer.parseInt(JOptionPane.showInputDialog(text));
				break;
			case 3:
				email = JOptionPane.showInputDialog("Login \n\n Inserir Email: ");
				senha = JOptionPane.showInputDialog("Login \n\n Inserir Senha: ");
				Logar(email, senha);
				op = Integer.parseInt(JOptionPane.showInputDialog(text));
				break;
			case 4:
				id = Integer.parseInt(JOptionPane.showInputDialog("Inserir RM para pesquisa: "));
				Pesquisar(id);
				op = Integer.parseInt(JOptionPane.showInputDialog(text));
				break;

			default:
				break;
			}
		}

	}

	private static void Logar(String email, String senha) {
		System.out.println(usuarioDao.logar(email, senha));
	}

	private static void Inserir(int id, String email, String senha) {
		Usuario usuario = new Usuario(id, email, senha);
		boolean verificado = usuarioDao.verificarRm(usuario.getId());
		if (!verificado) {
			System.out.println(usuarioDao.inserir(usuario));
		} else {
			System.out.println("Usuario com Id " + usuario.getId() + " já existe!");
		}
	}

	private static void Listar() {
		String text = "\n\n----- Lista de Usuario -----\n";
		for (Usuario usuario : usuarioDao.listar()) {
			text += usuario + "\n";
		}
		System.out.println(text);
	}

	public static void Pesquisar(int id) {
		if (usuarioDao.pesquisa(id)) {
			System.out.println("Valor encontrado\n");
		} else {
			System.out.println("Valor não encontrado\n");
		}
	}

}
