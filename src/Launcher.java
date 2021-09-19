
public class Launcher {

	public static void main(String[] args) {
		GUI gui = new GUI();
		gui.setVisible(true);
		Juego juego = new Juego(); //new Juego(gui);
		gui.setJuego(juego);
	}

}
