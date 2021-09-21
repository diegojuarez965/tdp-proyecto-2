
public class Bloque {

	protected String color;
	protected int posEnGrillaX, posEnGrillaY;

	public Bloque(int posEnGrillaX, int posEnGrillaY) {

		this.posEnGrillaX = posEnGrillaX;
		this.posEnGrillaY = posEnGrillaY;
		color= "/images/FondoNegro.png";
	}

	public int obtenerPosEnGrillaX() {
		return posEnGrillaX;
	}

	public int obtenerPosEnGrillaY() {
		return posEnGrillaY;
	}

	public String obtenerColor() {
		return color;
	}

	public void actualizarColor(String i) {
		this.color = i;
	}
}
