
public abstract class Tetrimino {

	protected String color;
	protected String icono;
	protected int orientacion;
	protected Bloque[][] grilla;
	protected Bloque[] bloques;

	public Tetrimino(Bloque grilla[][]) {
		this.grilla = grilla;
		orientacion= 0;
		bloques= new Bloque[4];
	}

	public String obtenerColor() {
		return color;
	}

	public String obtenerIcono() {
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
