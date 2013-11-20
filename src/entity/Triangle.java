package entity;

public class Triangle {

	private CGPoint a, b, c;

	public Triangle() {
		this.a = null;
		this.b = null;
		this.c = null;
	}

	public Triangle(CGPoint a, CGPoint b, CGPoint c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public double calcularArea() {
		int soma = (a.x * b.y) + (a.y * c.x) + (b.x * c.y);
		int sub = (b.y * c.x) + (a.x * c.y) + (a.y * b.x);
		return (soma - sub) / 2;
	}
		
	public String toString(){
		StringBuilder retorno = new StringBuilder();
		retorno.append("TRIANGULO");
		retorno.append("\n"+a.toString());
		retorno.append("\n"+b.toString());
		retorno.append("\n"+c.toString());
		retorno.append("\n"+"###########");
		return retorno.toString();
	}
}