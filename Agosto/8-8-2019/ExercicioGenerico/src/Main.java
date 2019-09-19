import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList<Car> lista = new ArrayList<Car>();
		
		Car carro1 = new Car("FIAT", "Uno", 7000);
		Car carro2 = new Car("Ford", "Mustang", 8000);
		Car carro3 = new Car("Tesla", "Model X", 100001);
		
		lista.add(carro1);
		lista.add(carro2);
		lista.add(carro3);

		System.out.println(maior(lista).getMarca());
	}
	
	public static <T extends Comparable<T>> T maior(ArrayList<T> lista) {
		T maior = lista.get(0);
		for(T carro : lista) {
			if(carro.compareTo(maior) > 0) {
				maior = carro;
			}
		}
		return maior;
	}

}
