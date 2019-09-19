
public class Aula {
	
	private String conteudo;
	private int duracao;
	
	public Aula(String conteudo, int duracao) {
		this.conteudo = conteudo;
		this.duracao = duracao;
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
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return conteudo;
	}
}
