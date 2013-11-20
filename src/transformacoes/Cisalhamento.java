package transformacoes;//

import java.awt.Polygon;

public class Cisalhamento {

	public Polygon cisalhamentoX(Polygon p, float cisalhamento){
		int[] xpontos = p.xpoints;
		int[] ypontos = p.ypoints;

		for(int i = 0; i<xpontos.length; i++){
			if(i == 0 || i == 3){
				int aux = xpontos[i]; 
				int s = (((int)Math.tan(cisalhamento) * ypontos[i]) + xpontos[i]);
				aux = s - aux;
				xpontos[i] = (((int)Math.tan(cisalhamento) * ypontos[i]) + xpontos[i]) - aux;
			}else{
				xpontos[i] = (((int)Math.tan(cisalhamento) * ypontos[i]) + xpontos[i]);
			}
			//xpontos[i] = (((int)Math.tan(cisalhamento) * ypontos[i]) + xpontos[i]);

		}//for

		return (new Polygon(xpontos, p.ypoints, p.npoints));
	}//cisalhamento x

	public Polygon cisalhamentoY(Polygon p, float cisalhamento){
		int[] xpontos = p.xpoints;
		int[] ypontos = p.ypoints;

		for(int i = 0; i<ypontos.length; i++){
			if(i == 0 || i == 1){
				int aux = ypontos[i];
				int s =  (((int)Math.tan(cisalhamento) * xpontos[i]) + ypontos[i]);
				aux = s - aux;
				ypontos[i] = (((int)Math.tan(cisalhamento) * xpontos[i]) + ypontos[i]) - aux;
			}else{
				ypontos[i] = (((int)Math.tan(cisalhamento) * xpontos[i]) + ypontos[i]);
			}
		}

		return (new Polygon(p.xpoints, ypontos, p.npoints));
	}//cisalhamento y

}
