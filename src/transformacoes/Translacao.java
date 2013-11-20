package transformacoes;

import java.awt.Polygon;

public class Translacao {

	public Polygon translacaoX(Polygon p, float xAnda){
		int[] xpontos = p.xpoints;

		for(int i = 0; i<xpontos.length; i++){
			xpontos[i] += xAnda;
		}
		
		return (new Polygon(xpontos, p.ypoints, p.npoints));
	}//Translação x

	public Polygon translacaoY(Polygon p, float yAnda){
		int[] ypontos = p.ypoints;
		
		for(int i = 0; i<ypontos.length; i++){
			ypontos[i] +=yAnda;
		}
		
		return (new Polygon(p.xpoints, ypontos, p.npoints));
	}//Translação y

}
