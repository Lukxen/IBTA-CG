package transformacoes;

import java.awt.Polygon;

public class rotacao {

	public Polygon rotacaoHorario(Polygon p, float teta) {
		int[] xpontos = p.xpoints;
		int[] ypontos = p.ypoints;

		for (int i = 0; i < p.npoints; i++) {
			System.out.print("[" + i + "]");
			System.out.println("Anterior: (" + xpontos[i] + ", " + ypontos[i]
					+ ")  |");
		}

		for (int i = 0; i < p.npoints; i++) {
			xpontos[i] = (int) ((xpontos[i] * Math.cos(teta)) - (ypontos[i] * Math.sin(teta)));
			ypontos[i] = (int) ((xpontos[i] * Math.sin(teta)) + (ypontos[i] * Math.cos(teta)));
		}

		for (int i = 0; i < p.npoints; i++) {
			System.out.print("[" + i + "]");
			System.out.println("  Posterior[" + i + "]: (" + xpontos[i] + ", "
					+ ypontos[i] + ")");
		}

		return (new Polygon(xpontos, ypontos, p.npoints));
	}

}
