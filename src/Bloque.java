
public class Bloque {

	protected boolean disponible;
	protected int posEnGrillaX, posEnGrillaY;

	public Bloque(int posEnGrillaX, int posEnGrillaY) {

		this.posEnGrillaX = posEnGrillaX;
		this.posEnGrillaY = posEnGrillaY;
		disponible=true;
	}

	public int obtenerPosEnGrillaX() {
		return posEnGrillaX;
	}

	public int obtenerPosEnGrillaY() {
		return posEnGrillaY;
	}

	public boolean obtenerDisponible() {
		return disponible;
	}

	public void actualizarDisponible(boolean disp) {
		disponible = disp;
	}
}
