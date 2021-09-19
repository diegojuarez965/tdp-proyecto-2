import java.awt.Image;

public class Bloque {

	protected Image color;
	protected int posEnGrillaX, posEnGrillaY;
	
	public Bloque(int posEnGrillaX, int posEnGrillaY, Image color) {
		
		this.posEnGrillaX = posEnGrillaX;
		this.posEnGrillaY = posEnGrillaY;
		this.color = color;
	}
	
	public int obtenerPosEnGrillaX() {
		return posEnGrillaX;
	}
	
	public int obtenerPosEnGrillaY() {
		return posEnGrillaY;
	}
	
	public Image obtenerColor() {
		return color;
	}
	
	public void actualizarColor(Image i) {
		this.color = i;
	}
}
