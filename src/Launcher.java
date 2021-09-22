
public class Launcher {

	public static void main(String[] args) {
		Reloj reloj = new Reloj();
		Juego juego = new Juego(reloj);
		GUI gui = new GUI(juego);
		juego.setGui(gui);
		juego.crearTetrimino();
		reloj.setJuego(juego);
		gui.setVisible(true);
		reloj.run();
		
	}

}
