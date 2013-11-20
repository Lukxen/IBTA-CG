package entity;

import java.awt.Point;

public class CGPoint extends Point {

	private static final long serialVersionUID = 1L;

	private boolean concave;

	public CGPoint() {
		super();
		concave = false;
	}

	public CGPoint(Point p) {
		super(p);
		concave = false;
	}

	public CGPoint(int x, int y) {
		super(x, y);
		concave = false;
	}

	public boolean isConcave() {
		return concave;
	}

	public void setConcave(boolean concave) {
		this.concave = concave;
	}
	
	public String toString(){
		StringBuilder retorno = new StringBuilder();
		retorno.append("X: "+x);
		retorno.append("\n");
		
		retorno.append("Y: "+y);
		retorno.append("\n");
		retorno.append("Concavo: "+concave);
		retorno.append("\n---");
		return retorno.toString();
	}	

}