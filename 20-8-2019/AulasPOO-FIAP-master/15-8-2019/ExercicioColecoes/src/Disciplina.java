import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Map;

public class Disciplina {
	private String nome;
	private String professor;
	private List<Aula> listaAula;
	private Set<Aluno> listaAluno;
	private Map<Integer, Aluno> listaMatricula;
	
	public Disciplina(String nome, String professor) {
		super();
		this.nome = nome;
		this.professor = professor;
		this.listaAula = new ArrayList<>();
		this.listaAluno = new HashSet<Aluno>();
		this.listaMatricula = new HashMap<Integer, Aluno>();
	}
	
	public void adicionarAula(Aula aula) {
		listaAula.add(aula);
	}
	
	public void matricularAluno(Aluno aluno) {
		listaAluno.add(aluno);
		listaMatricula.put(aluno.getRm(), aluno);
	}
	
	public Aluno localizarAluno(int rm) {
		return listaMatricula.get(rm);
	}
	
	public boolean estaMatriculado(Aluno aluno) {
		return listaAluno.contains(aluno);
	}
	
	public void imprimirAluno() {
		System.out.println(listaAluno);
	}
	
	public int getDuracaoTotal() {
		int aux = 0;
		for(Aula aula : listaAula) {
			aux += aula.getDuracao();
		}
		return aux;
	}
	
	
}


