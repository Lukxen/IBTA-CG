package screen;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class CGFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	CGPainel painel;

	public CGFrame() {
		super("Polígonos");
		setSize(1000, 660);
		setResizable(false);
		painel = new CGPainel();
		addMouseListener(painel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(painel);
	}

	public void init() {
		setVisible(true);
		center();
	}

	private void center() {
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();

		int screenWidth = screenSize.width - this.getWidth();
		int screenHeight = screenSize.height - this.getHeight();

		setLocation(screenWidth / 2, screenHeight / 2);
	}

}