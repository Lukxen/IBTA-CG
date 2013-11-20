package transformacoes;

import java.util.ArrayList;

import entity.*;

public class VerificaCoordenadas {

	public ArrayList<CGPoint> verificaPontos(ArrayList<CGPoint> pontos) {

		ArrayList<CGPoint> retorno = new ArrayList<CGPoint>();
		CGPoint a = null;
		CGPoint b = null;
		CGPoint c = null;

		for (short i = 0; i < pontos.size(); i++) {
			a = pontos.get(i);
			b = pontos.get((i + 1) == pontos.size() ? 0 : (i + 1));
			boolean tipo = true;
			boolean saiu = false;
			boolean primeiro = true;

			for (CGPoint p : pontos) {
				c = p;

				if (primeiro) {

					tipo = equacaoReta(a, b, c);
					primeiro = false;

				} else {

					if (tipo != equacaoReta(a, b, c)) {
						saiu = true;
						break;
					}
				}
			}// for
			if (saiu) {
				b.setConcave(true);
				retorno.add(b);
			} else {
				retorno.remove(b);
				retorno.remove(a);
				a.setConcave(false);
				b.setConcave(false);
				retorno.add(b);
				retorno.add(a);
			}
		}// for
		retorno = ajustaVetor(pontos, retorno);
		return retorno;
	}// verficaConvexo

	public ArrayList<CGPoint> ajustaVetor(ArrayList<CGPoint> original,
			ArrayList<CGPoint> pontos) {
		for (CGPoint p : original) {
			for (CGPoint i : pontos) {
				if (p.getX() == i.getX() && p.getY() == i.getY()) {
					p.setConcave(i.isConcave());
					pontos.remove(i);
					break;
				}
			}
		}
		return original;
	}// ajustaVetor

	public boolean equacaoReta(CGPoint a, CGPoint b, CGPoint c) {
		// ( X1 * Y2 )
		// ( Y1 * X )
		// ( X2 * Y ) -
		short principalD = (short) ((a.getX() * b.getY())
				+ (a.getY() * c.getX()) + (b.getX() * c.getY()));

		// ( Y2 * X )
		// ( X1 * Y )
		// ( Y1 * X2 )
		short principalS = (short) ((b.getY() * c.getX())
				+ (a.getX() * c.getY()) + (a.getY() * b.getX()));

		if (principalD - principalS >= 0)
			return true;

		return false;
	}// equacaoReta

	public ArrayList<Triangle> criarTriangulos(ArrayList<CGPoint> pontos) {
		ArrayList<Triangle> listaTriangulo = new ArrayList<Triangle>();
		boolean formaTriangulo = true;
		CGPoint a = null;
		CGPoint b = null;
		CGPoint c = null;
		for (int i = 0; pontos.size() > 3 ;) {
			try {
				a = pontos.get(i);
				b = pontos.get(i + 1 == pontos.size() ? 0 : i + 1);
				c = pontos.get(i + 2 == pontos.size() ? 0 : i + 2 > pontos
						.size() ? 1 : i + 2);
			} catch (Exception e) {
				break;
			}

			if (!b.isConcave()) {
				formaTriangulo = true;
				for (CGPoint p : pontos) {
					if (hasInternalPoint(a, b, c, p)) {
						formaTriangulo = true;
						break;
					}// if
				}// for
				if (formaTriangulo) {
					Triangle tr = new Triangle(a, b, c);
					pontos.remove(b);
					listaTriangulo.add(tr);
					i++;
				}//if 
			} else {
				i++;
			}// else
		}// for
		if(pontos.size() == 3){
			Triangle tr = new Triangle(
					pontos.get(0),
					pontos.get(1),
					pontos.get(2));
			listaTriangulo.add(tr);
		}
		return listaTriangulo;

	}// criarTriangulos

	public boolean hasInternalPoint(CGPoint a, CGPoint b, CGPoint c, CGPoint internal) {
		short abi = calcularDeterminante(a, b, internal);

		short bci = calcularDeterminante(b, c, internal);

		short cai = calcularDeterminante(c, a, internal);

		if (abi >= 0 && bci >= 0 && cai >= 0)
			return false;
		return true;
	}// criarTriangulos

	public short calcularDeterminante(CGPoint a, CGPoint b, CGPoint c) {
		short principalD;
		short principalS;
		principalD = (short) ((a.getX() * b.getY()) + (a.getY() * c.getX()) + (b
				.getX() * c.getY()));
		principalS = (short) ((b.getY() * c.getX()) + (a.getX() * c.getY()) + (a
				.getY() * b.getX()));
		return (short) (principalD - principalS);
	}// calcularDeterminante

}// CLASS