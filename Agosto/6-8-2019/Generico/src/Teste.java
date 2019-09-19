
public class Teste {

	public static void main(String[] args) {
	
		//Devemos usar um Integer/Double por não ser um tipo primitivo
		Integer[] v1 = {3, 6, 8, 10, 0, 1};
		Double[] v2 = {3.00, 8.0, 7.76, 0.0};
		//imprimir(v1);
		
		System.out.println("maior = "+ maior(5, 8, 1));
		//Trabalhando com ASCII
		System.out.println("maior = "+ maior("Ana", "ana", "ANA"));
	}
	
	public static <T> void imprimir(T[] v) {
		for(T e : v) {
			System.out.printf("%s ", e);
		}
	}

	public static <T extends Comparable<T>> T maior(T x, T y, T z) {
		T maior = x;
		
		if(y.compareTo(maior) > 0) {
			maior = y;
		}
		
		if(z.compareTo(maior) > 0) {
			maior = z;
		}
		
		return maior;
		
	}
}

