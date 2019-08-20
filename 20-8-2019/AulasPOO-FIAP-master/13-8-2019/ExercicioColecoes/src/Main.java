import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Aula> listaAula = new LinkedList<Aula>() ;
		listaAula.add(new Aula("Programação Java", 10));
		listaAula.add(new Aula("Redes de Computadores", 5));
		listaAula.add(new Aula("Python para Web", 20));

		//Opção disponível JAVA 8 ou superior
		listaAula.forEach(aula -> {
			System.out.println(aula);
		});
		
		//ordenação por conteúdo
		listaAula.sort(Comparator.comparing(Aula::getConteudo));
		
		System.out.println(listaAula);
	}

}
