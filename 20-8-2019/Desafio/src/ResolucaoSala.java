import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ResolucaoSala {
	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		Map<String, Integer> mapa = new HashMap<String, Integer>();
		String palavra;
		int total;
		
		System.out.println("Informe uma frase");
		String frase = teclado.nextLine();
		
		StringTokenizer token = new StringTokenizer(frase);
		while(token.hasMoreTokens()) {
			palavra = token.nextToken().toLowerCase();
			if(mapa.containsKey(palavra)) {
				total = mapa.get(palavra);
				mapa.put(palavra, total+1);
			}else {
				mapa.put(palavra, 1);
			}
		}
		
		System.out.println(mapa);
		
	}
}
