
public class Launcher {

	public static void main(String[] args) {
		GUI gui = new GUI();
		
		Reloj reloj = new Reloj();
		Juego juego = new Juego(gui,reloj);
		gui.setJuego(juego);
		reloj.setJuego(juego);
		gui.setVisible(true);
		reloj.run();
		
	}

}
