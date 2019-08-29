package main;

import java.util.List;
import javax.swing.JOptionPane;
import dao.AlunoDAO;
import modelo.Aluno;

public class teste {

	static AlunoDAO dao = new AlunoDAO();

	public static void main(String[] args) {
		int rm;
		String nome;
		String text = "1. Listar \n 2. Inserir \n 3. Pesquisar \n 4. Excluir \n 5. Atualizar \n 6.Sair";

		int op = Integer.parseInt(JOptionPane.showInputDialog(text));
		while (op != 6) {
			switch (op) {
			case 1:
				Listar();
				op = Integer.parseInt(JOptionPane.showInputDialog(text));
				break;
			case 2:
				rm = Integer.parseInt(JOptionPane.showInputDialog("Inserir RM: "));
				nome = JOptionPane.showInputDialog("Inserir Nome,: ");
				Inserir(rm, nome);
				op = Integer.parseInt(JOptionPane.showInputDialog(text));
				break;
			case 3:
				rm = Integer.parseInt(JOptionPane.showInputDialog("Inserir RM para pesquisa: "));
				Pesquisar(rm);
				op = Integer.parseInt(JOptionPane.showInputDialog(text));
				break;
			case 4:
				rm = Integer.parseInt(JOptionPane.showInputDialog("Inserir RM para exclusão: "));
				Excluir(rm);
				op = Integer.parseInt(JOptionPane.showInputDialog(text));
				break;
			case 5:
				rm = Integer.parseInt(JOptionPane.showInputDialog("Inserir RM para atualizar: "));
				nome = JOptionPane.showInputDialog("Inserir Nome,: ");
				Atualizar(rm, nome);
				op = Integer.parseInt(JOptionPane.showInputDialog(text));
				break;
			default:
				break;
			}
		}

	}

	public static void Listar() {
		List<Aluno> lista = dao.listar();

		String text = "---- Lista de Aluno ---- \n";
		for (Aluno aluno : lista) {
			text += aluno + "\n";
		}
		System.out.println(text + "\n");
	}

	public static void Inserir(int rm, String nome) {
		dao.inserir(new Aluno(rm, nome));
		Listar();
	}

	public static void Pesquisar(int rm) {

		if (dao.pesquisa(rm)) {
			System.out.println("Valor encontrado\n");
		} else {
			System.out.println("Valor não encontrado\n");
		}
	}

	public static void Excluir(int rm) {
		if (dao.excluir(rm)) {
			System.out.println("Aluno com rm " + rm + " foi EXCLUIDO com sucesso!\n");
		} else {
			System.out.println("Aluno não encontrado\n");
		}
	}

	private static void Atualizar(int rm, String nome) {
		if (dao.atualicao(rm, nome)) {
			System.out.println("Aluno " + nome + " com rm " + rm + " foi ATUALIZADO com sucesso!\n");
		} else {
			System.out.println("Aluno não encontrado\n");
		}

	}

}
