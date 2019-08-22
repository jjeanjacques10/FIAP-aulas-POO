
public class Aula {
	private String conteudo;
	private int duracao;
	
	public Aula(String conteudo, int duracao) {
		super();
		this.conteudo = conteudo;
		this.duracao = duracao;
	}

	@Override
	public String toString() {
		return duracao+" "+conteudo;
	}
	
	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	
}
