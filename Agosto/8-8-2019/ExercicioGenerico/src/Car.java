
public class Car implements Comparable<Car>{
	private String marca;
	private String modelo;
	private double valor;
	
	public Car(String marca, String modelo, double valor) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.valor = valor;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	
	@Override
	public int compareTo(Car carro) {
		if(valor == carro.getValor()) {
			return 0;
		}else if(valor > carro.getValor()) {
			return 1;
		}
		return -1;
	}
	
}
