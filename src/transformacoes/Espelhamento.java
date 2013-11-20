package transformacoes;

import java.awt.Polygon;

public class Espelhamento {

	public Polygon espelhamentoX(Polygon p){
		int[] xpontos = p.xpoints;

		for(int i = 0; i<xpontos.length; i++){
			xpontos[i] = 700 - xpontos[i];
		}

		return (new Polygon(xpontos, p.ypoints, p.npoints));

	}//Espelhamento x

	public Polygon espelhamentoY(Polygon p){
		
		int[] ypontos = p.ypoints;
		
		for(int i = 0; i<ypontos.length; i++){
			ypontos[i] = 700 - ypontos[i];
		}
		
		return (new Polygon(p.xpoints, ypontos, p.npoints));
	}//Espelhamento y

}
