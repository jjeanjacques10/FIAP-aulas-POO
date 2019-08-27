package main;

import dao.AlunoDAO;
import modelo.Aluno;

public class teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Aluno aluno = new Aluno(20,"Vinicius");
		AlunoDAO dao = new AlunoDAO();
		//dao.inserir(aluno);
		System.out.println(dao.pesquisa(81524));
	}

}
