
public class Aluno {

	private int rm;
	private String nome;

	public Aluno(int rm, String nome) {
		this.rm = rm;
		this.nome = nome;
	}

	public int getRm() {
		return rm;
	}

	public void setRm(int rm) {
		this.rm = rm;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "RM" + rm + " - " + nome;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Aluno) {
			Aluno aluno = (Aluno)obj;
			if(rm == aluno.getRm() && nome.equalsIgnoreCase(aluno.getNome())) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return nome.hashCode();
	}
	

}
