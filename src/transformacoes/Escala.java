package transformacoes;

import java.awt.Polygon;

public class Escala {

	public Polygon escalaAumentar(Polygon p, double zoom){
		int[] xpontos = p.xpoints;
		int[] ypontos = p.ypoints;		
		for(int i = 0; i<xpontos.length; i++){
			xpontos[i] = (int)(xpontos[i] * zoom);
			ypontos[i] = (int)(ypontos[i] * zoom);
		}		
		return (new Polygon(xpontos, ypontos, p.npoints));
	}//escala aumentar
	
	
	
	//arrumar float
	
	public Polygon escalaDiminuir(Polygon p, double zoom){
		int[] xpontos = p.xpoints;
		int[] ypontos = p.ypoints;		
		for(int i = 0; i<xpontos.length; i++){
			xpontos[i] = (int)(xpontos[i] * zoom);
			ypontos[i] = (int)(ypontos[i] * zoom);
		}		
		return (new Polygon(xpontos, ypontos, p.npoints));
	}//escala diminuir

}
