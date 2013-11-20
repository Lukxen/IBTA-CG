package screen;

import java.awt.Canvas;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import entity.CGPoint;

public class CanvasPolygon extends Canvas {

	private static final long serialVersionUID = 1L;

	private Vector<CGPoint> vectors;
	double x0, y0, rWidth = 10.0F, rHeight = 7.5F, pixelSize;
	boolean ready = true;
	int centerX, centerY;

	public CanvasPolygon() {
		vectors = new Vector<CGPoint>();
		setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent evt) {
				double xA = fx(evt.getX()), yA = fy(evt.getY());
				if (ready) {
					vectors.removeAllElements();
					x0 = xA;
					y0 = yA;
					ready = false;
				}
				double dx = xA - x0, dy = yA - y0;
				if (vectors.size() > 0
						&& dx * dx + dy * dy < 4 * pixelSize * pixelSize)
					ready = true;
				else
					vectors.addElement(new CGPoint(iX(xA), iY(yA)));
				repaint();
			}
		});
	}

	private double fx(int x) {
		return (x - centerX) * pixelSize;
	}

	private double fy(int y) {
		return (centerY - y) * pixelSize;
	}

	private int iX(double x) {
		return (int) Math.round(centerX + x / pixelSize);
	}

	private int iY(double y) {
		return (int) Math.round(centerY - y / pixelSize);
	}

	public Polygon getPolygon() {
		Polygon polygon = new Polygon();
		int n = vectors.size();

		if (n == 0)
			return null;

		CGPoint a = (CGPoint) (vectors.elementAt(0));
		for (int i = 0; i <= n; i++) {
			if (i == n+1 && !ready)
				break;
			CGPoint b = (CGPoint) (vectors.elementAt(i % n));
			polygon.addPoint((int) a.getX(), (int) a.getY());
			a = b;
		}
		return polygon;
	}

	private void initgr() {
		Dimension d = getSize();
		int maxX = d.width - 1, maxY = d.height - 1;
		pixelSize = Math.max(rWidth / maxX, rHeight / maxY);
		centerX = maxX / 2;
		centerY = maxY / 2;
	}

	public void paint(Graphics g) {
		initgr();
		int left = iX(-rWidth / 2), right = iX(rWidth / 2), bottom = iY(-rHeight / 2), top = iY(rHeight / 2);

		g.drawRect(left, top, right - left, bottom - top);
		int n = vectors.size();
		if (n == 0)
			return;
		CGPoint a = (CGPoint) (vectors.elementAt(0));
		g.drawRect((int) a.getX() - 2, (int) a.getY() - 2, 4, 4);
		for (int i = 0; i <= n; i++) {
			if (i == n && !ready)
				break;
			CGPoint b = (CGPoint) (vectors.elementAt(i % n));
			g.drawLine((int) a.getX(), (int) a.getY(), (int) b.getX(),
					(int) b.getY());
			a = b;
		}
	}

	public void setPolygon(Polygon p) {
		vectors.removeAllElements();
		for (int i = 0; i < p.npoints; i++) {
			vectors.add(new CGPoint(p.xpoints[i], p.ypoints[i]));
		}
	}

}
