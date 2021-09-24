import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import net.miginfocom.swing.MigLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class GUI extends JFrame {

	private Juego juego;
	private JLabel tiempo;
	private JLabel puntos;
	private JLabel proxTetrimino;
	private JLabel[][] labelsTetris;

	public GUI(Juego juego) {
		this.juego = juego;
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {

				case KeyEvent.VK_RIGHT: {
					juego.operar(juego.MOVER_DERECHA);
					break;
				}
				case KeyEvent.VK_LEFT: {
					juego.operar(juego.MOVER_IZQUIERDA);
					break;
				}
				case KeyEvent.VK_DOWN: {
					juego.operar(juego.MOVER_ABAJO);
					break;
				}
				case KeyEvent.VK_SPACE: {
					juego.operar(juego.ROTAR);
					break;
				}
				}
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(450, 591));
		setResizable(false);
		getContentPane().setLayout(new MigLayout("insets 0", "[]0[]0[]0[]0[]0[]0[]0[]0[]0[]0[]0[]0[][][][]0[]0",
				"[]0[]0[]0[]0[]0[]0[]0[]0[]0[]0[]0[]0[]0[]0[]0[]0[]0[]0[]0[]0[]0[]0[]0"));

		proxTetrimino = new JLabel("");
		proxTetrimino.setIcon(new ImageIcon(GUI.class.getResource(this.juego.obtenerTetriminoSig().obtenerIcono())));
		getContentPane().add(proxTetrimino, "cell 16 2, span 2 2");
		getContentPane().add(new JLabel("Proximo Tetrimino:"), "cell 16 1");

		tiempo = new JLabel("00:00:00");
		getContentPane().add(tiempo, "cell 16 6");
		puntos = new JLabel("Puntos: " + 0);
		getContentPane().add(puntos, "cell 16 8");

		labelsTetris = new JLabel[21][10];
		for (int i = 0; i < 12; i++) {
			if (i == 0 || i == 11)
				for (int j = 0; j < 23; j++) {
					JLabel labelTemp = new JLabel("");
					labelTemp.setIcon(new ImageIcon(GUI.class.getResource("/images/BloqueBorde.png")));
					getContentPane().add(labelTemp, "cell " + i + " " + j);
				}
			else
				for (int j = 0; j < 23; j++)
					if (j == 0 || j == 22) {
						JLabel labelTemp = new JLabel("");
						labelTemp.setIcon(new ImageIcon(GUI.class.getResource("/images/BloqueBorde.png")));
						getContentPane().add(labelTemp, "cell " + i + " " + j);
					} else {
						JLabel labelTemp = new JLabel("");
						labelTemp.setIcon(new ImageIcon(GUI.class.getResource("/images/FondoNegro.png")));
						getContentPane().add(labelTemp, "cell " + i + " " + j);
						labelsTetris[j - 1][i - 1] = labelTemp;
					}
		}
	}

	public void actualizarProxTetrimino(String t) {
		proxTetrimino.setIcon(new ImageIcon(GUI.class.getResource(t)));
	}

	public void actualizarTiempo(String t) {
		tiempo.setText(t);
	}

	public void actualizarPuntos(int p) {
		puntos.setText("Puntos: " + p);
	}

	public void actualizarBloque(int x, int y, String imagen) {
		labelsTetris[x][y].setIcon(new ImageIcon(GUI.class.getResource(imagen)));
	}

	public String obtenerImagenBloque(int x, int y) {
		String camino = labelsTetris[x][y].getIcon().toString();
		return "/images/" + camino.substring(camino.lastIndexOf('/') + 1);
	}

	public void finalizar() {
		String t = tiempo.getText().substring(0, 2) + "h " + tiempo.getText().substring(3, 5) + "m "
				+ tiempo.getText().substring(6) + "s";
		JOptionPane.showMessageDialog(getContentPane(),
				"          JUEGO TERMINADO\nConseguiste " + juego.obtenerPuntos() + " puntos en: " + t);
		this.setVisible(false);
		this.dispose();
		System.exit(0);
	}

}
