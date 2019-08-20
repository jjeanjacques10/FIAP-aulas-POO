import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class main {

	public static void main(String[] args) {
		String test = "Hoje é trabalho 3a Hoje trabalho";
		String[] array;
		Map<String, Integer> result;
		result = new HashMap<String, Integer>();
		int qtd = 0;

		array = test.split(" ");
		for(String item : array) {
			for(String item2 : array) {
				if(item.equals(item2)) {
					qtd++;
				}
			}
			result.put(item, qtd);
			qtd = 0;
		}
		System.out.println(result);
	}

}
