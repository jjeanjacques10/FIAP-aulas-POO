
public class TesteDisciplina {
	public static void main(String[] args) {
		
		Disciplina disciplina = new Disciplina("POO", "Ismael");
		
		disciplina.matricularAluno(new Aluno(10, "Selmini"));
		disciplina.matricularAluno(new Aluno(30, "Maria"));
		disciplina.matricularAluno(new Aluno(20, "Antonio"));
		disciplina.matricularAluno(new Aluno(30, "Maria"));

		disciplina.imprimirAluno();
		System.out.println(disciplina.estaMatriculado(new Aluno(30, "Maria")));
		System.out.println(disciplina.pesquisarAluno(30));
		
	}
}
