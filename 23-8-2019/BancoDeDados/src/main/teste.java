package main;

import dao.AlunoDAO;
import modelo.Aluno;

public class teste {

	public static void main(String[] args) {
		
		//Aluno aluno = new Aluno(1,"Jean Jacques");
		AlunoDAO dao = new AlunoDAO();
		//dao.inserir(aluno);
		System.out.println(dao.pesquisa(81524));
	}

}
