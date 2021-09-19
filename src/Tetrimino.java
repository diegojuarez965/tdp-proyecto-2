import java.awt.Image;

public abstract class Tetrimino {
	
	protected Image color;
	protected Image icono;
	protected int orientacion;
	protected Bloque[][] grilla;
	protected Bloque[] bloques;
	
	public Tetrimino(Bloque grilla[][]) {
		
		this.grilla = grilla;
		bloques = new Bloque[4];
	}
	
	public Image obtenerColor() {
		return color;
	}
	
	public Image obtenerIcono() {
		return icono;
	}
	
	public int obtenerOrientacion() {
		return orientacion;
	}
	
	abstract void actualizarPos();
	
	abstract Bloque[] moverTetriminoIzq();
	
	abstract Bloque[] moverTetriminoDer();
	
	abstract Bloque[] rotarTetrimino();
}
