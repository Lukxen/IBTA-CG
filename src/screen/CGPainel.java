package screen;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.*;
import transformacoes.Cisalhamento;
import transformacoes.Escala;
import transformacoes.Espelhamento;
import transformacoes.Translacao;
import transformacoes.rotacao;

public class CGPainel extends JPanel implements MouseListener {

	private static final long serialVersionUID = 1L;

	Polygon p;
	CanvasPolygon canvas;
	JButton btnTranslacaox, btnTranslacaoy, btnEscalaAumentar,
			btnEscalaDiminuir, btnEspelhamentox, btnEspelhamentoy,
			btnCisalhamentox, btnCisalhamentoy, btnRotacaoHorario,
			btnRotacaoAntiHorario, btnRecebeArquivo, btnEnviaArquivo;
	JTextField jtTranslacaox, jtTranslacaoy, jtEscalaAumentar,
			jtEscalaDiminuir, jtCisalhamentox, jtCisalhamentoy,
			jtRotacaoHorario, jtRotacaoAntiHorario;

	public CGPainel() {
		canvas = new CanvasPolygon();
		canvas.setSize(700, 700);
		canvas.setLocation(250, -65);

		add("Canvas", canvas);
		this.setLayout(null);

		// translação X
		btnTranslacaox = new JButton("Translação X");
		btnTranslacaox.setBounds(80, 50, 159, 25);
		btnTranslacaox.setVisible(true);
		btnTranslacaox.addMouseListener(this);
		this.add(btnTranslacaox);

		jtTranslacaox = new JTextField();
		jtTranslacaox.setBounds(20, 50, 50, 25);
		jtTranslacaox.setVisible(true);
		jtTranslacaox.addMouseListener(this);
		this.add(jtTranslacaox);

		// translação Y
		btnTranslacaoy = new JButton("Translação Y");
		btnTranslacaoy.setBounds(80, 80, 159, 25);
		btnTranslacaoy.setVisible(true);
		btnTranslacaoy.addMouseListener(this);
		this.add(btnTranslacaoy);

		jtTranslacaoy = new JTextField();
		jtTranslacaoy.setBounds(20, 80, 50, 25);
		jtTranslacaoy.setVisible(true);
		jtTranslacaoy.addMouseListener(this);
		this.add(jtTranslacaoy);

		// escala aumentar
		btnEscalaAumentar = new JButton("Zoom +");
		btnEscalaAumentar.setBounds(80, 110, 159, 25);
		btnEscalaAumentar.setVisible(true);
		btnEscalaAumentar.addMouseListener(this);
		this.add(btnEscalaAumentar);

		jtEscalaAumentar = new JTextField();
		jtEscalaAumentar.setBounds(20, 110, 50, 25);
		jtEscalaAumentar.setVisible(true);
		jtEscalaAumentar.addMouseListener(this);
		this.add(jtEscalaAumentar);

		// escala diminuir
		btnEscalaDiminuir = new JButton("Zoom -");
		btnEscalaDiminuir.setBounds(80, 140, 159, 25);
		btnEscalaDiminuir.setVisible(true);
		btnEscalaDiminuir.addMouseListener(this);
		this.add(btnEscalaDiminuir);

		jtEscalaDiminuir = new JTextField();
		jtEscalaDiminuir.setBounds(20, 140, 50, 25);
		jtEscalaDiminuir.setVisible(true);
		jtEscalaDiminuir.addMouseListener(this);
		this.add(jtEscalaDiminuir);

		// cisalhamento X
		btnCisalhamentox = new JButton("Cisalhamento X");
		btnCisalhamentox.setBounds(80, 170, 159, 25);
		btnCisalhamentox.setVisible(true);
		btnCisalhamentox.addMouseListener(this);
		this.add(btnCisalhamentox);

		jtCisalhamentox = new JTextField();
		jtCisalhamentox.setBounds(20, 170, 50, 25);
		jtCisalhamentox.setVisible(true);
		jtCisalhamentox.addMouseListener(this);
		this.add(jtCisalhamentox);

		// cisalhamento y
		btnCisalhamentoy = new JButton("Cisalhamento Y");
		btnCisalhamentoy.setBounds(80, 200, 159, 25);
		btnCisalhamentoy.setVisible(true);
		btnCisalhamentoy.addMouseListener(this);
		this.add(btnCisalhamentoy);

		jtCisalhamentoy = new JTextField();
		jtCisalhamentoy.setBounds(20, 200, 50, 25);
		jtCisalhamentoy.setVisible(true);
		jtCisalhamentoy.addMouseListener(this);
		this.add(jtCisalhamentoy);

		// Rotação sentido horario
		btnRotacaoHorario = new JButton("Rotação (Horário)");
		btnRotacaoHorario.setBounds(80, 230, 159, 25);
		btnRotacaoHorario.setVisible(true);
		btnRotacaoHorario.addMouseListener(this);
		this.add(btnRotacaoHorario);

		jtRotacaoHorario = new JTextField();
		jtRotacaoHorario.setBounds(20, 230, 50, 25);
		jtRotacaoHorario.setVisible(true);
		jtRotacaoHorario.addMouseListener(this);
		this.add(jtRotacaoHorario);

		// Rotação sentido anti horário
		btnRotacaoAntiHorario = new JButton("Rotação (Anti Horário)");
		btnRotacaoAntiHorario.setBounds(80, 260, 159, 25);
		btnRotacaoAntiHorario.setVisible(true);
		btnRotacaoAntiHorario.addMouseListener(this);
		this.add(btnRotacaoAntiHorario);

		jtRotacaoAntiHorario = new JTextField();
		jtRotacaoAntiHorario.setBounds(20, 260, 50, 25);
		jtRotacaoAntiHorario.setVisible(true);
		jtRotacaoAntiHorario.addMouseListener(this);
		this.add(jtRotacaoAntiHorario);

		// espelhamento X
		btnEspelhamentox = new JButton("Espelhamento X");
		btnEspelhamentox.setBounds(20, 290, 219, 25);
		btnEspelhamentox.setVisible(true);
		btnEspelhamentox.addMouseListener(this);
		this.add(btnEspelhamentox);

		// espelhamento Y
		btnEspelhamentoy = new JButton("Espelhamento Y");
		btnEspelhamentoy.setBounds(20, 320, 219, 25);
		btnEspelhamentoy.setVisible(true);
		btnEspelhamentoy.addMouseListener(this);
		this.add(btnEspelhamentoy);

		// Le arquivo
		btnRecebeArquivo = new JButton("Ler txt");
		btnRecebeArquivo.setBounds(20, 350, 219, 25);
		btnRecebeArquivo.setVisible(true);
		btnRecebeArquivo.addMouseListener(this);
		this.add(btnRecebeArquivo);

		// Faz download no arquivo
		btnEnviaArquivo = new JButton("Gerar txt");
		btnEnviaArquivo.setBounds(20, 380, 219, 25);
		btnEnviaArquivo.setVisible(true);
		btnEnviaArquivo.addMouseListener(this);
		this.add(btnEnviaArquivo);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		p = canvas.getPolygon();
		
		if (e.getComponent() == btnTranslacaox) {
			System.out.println("btnTranslacaox");
			Translacao t = new Translacao();
			float x = Float.parseFloat(jtTranslacaox.getText().toString());
			
			p = t.translacaoX(p, x);
		}// Translação em x

		if (e.getComponent() == btnTranslacaoy) {
			System.out.println("btnTranslacaoy");
			Translacao t = new Translacao();
			float y = Float.parseFloat(jtTranslacaoy.getText().toString());

			p = t.translacaoY(p, y);
		}// Translação em y

		if (e.getComponent() == btnEscalaAumentar) {
			System.out.println("btnEscalaAumentar");
			Escala nEscala = new Escala();
			double zoom = Double.parseDouble((jtEscalaAumentar.getText()
					.toString()).replace(",", "."));

			p = nEscala.escalaAumentar(p, zoom);
		}// Escala aumentar

		if (e.getComponent() == btnEscalaDiminuir) {
			System.out.println("btnEscalaDiminuir");
			Escala nEscala = new Escala();
			double aux = Double.parseDouble((jtEscalaDiminuir.getText()
					.toString()).replace(",", "."));
			double zoom = (1 / aux);

			p = nEscala.escalaDiminuir(p, zoom);
		}// Escala diminuir

		if (e.getComponent() == btnCisalhamentox) {
			System.out.println("btnCisalhamentox");
			Cisalhamento cx = new Cisalhamento();
			float cisalhamento = Float.parseFloat((jtCisalhamentox.getText()
					.toString()).replace(",", "."));

			p = cx.cisalhamentoX(p, cisalhamento);
		}// Cisalhamento X

		if (e.getComponent() == btnCisalhamentoy) {
			System.out.println("btnCisalhamentoy");
			Cisalhamento cy = new Cisalhamento();
			float cisalhamento = Float.parseFloat((jtCisalhamentoy.getText()
					.toString()).replace(",", "."));

			p = cy.cisalhamentoY(p, cisalhamento);
		}// Cisalhamento Y

		if (e.getComponent() == btnRotacaoHorario) {
			rotacao r = new rotacao();
			float teta = Float.parseFloat((jtRotacaoHorario.getText()
					.toString()).replace(",", "."));

			p = r.rotacaoHorario(p, teta);
		}// Rotação sentido horário

		if (e.getComponent() == btnRotacaoAntiHorario) {
			rotacao r = new rotacao();
			float teta = Float.parseFloat((jtRotacaoAntiHorario.getText()
					.toString()).replace(",", "."));

			p = r.rotacaoHorario(p, teta);
		}// Rotação sentido anti horário

		if (e.getComponent() == btnEspelhamentox) {
			System.out.println("btnEspelhamentox");
			Espelhamento ex = new Espelhamento();

			p = ex.espelhamentoX(p);
		}// Espelhamento X

		if (e.getComponent() == btnEspelhamentoy) {
			System.out.println("btnEspelhamentoy");
			Espelhamento ey = new Espelhamento();

			p = ey.espelhamentoY(p);
		}// Espelhamento Y

		if (e.getComponent() == btnRecebeArquivo) {
			System.out.println("btnRecebeArquivo");
			ManipulaArquivos ma = new ManipulaArquivos();

			p = ma.recebeArquivo();
		}// Le arquivo

		if (e.getComponent() == btnEnviaArquivo) {
			System.out.println("btnEnviaArquivo");
			ManipulaArquivos ma = new ManipulaArquivos();

			ma.enviaArquivo(p);
		}// Envia arquivo
		
		canvas.setPolygon(p);
		canvas.repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
