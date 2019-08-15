import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Aula> listaAula = new LinkedList<Aula>() ;
		
		Disciplina disciplina = new Disciplina("POO", "Ismael");
		
		Aluno aluno = new Aluno(81000, "Jean");
		disciplina.matricularAluno(aluno);		
		disciplina.matricularAluno(aluno);
		disciplina.matricularAluno(new Aluno(81001, "Gustavo"));
		disciplina.matricularAluno(new Aluno(81002, "Alice"));
		
		disciplina.imprimirAluno();
		
		System.out.println(disciplina.estaMatriculado(new Aluno(81000, "Jean")));
	}

}
