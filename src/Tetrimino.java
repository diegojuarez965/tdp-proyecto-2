
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
	
	public Bloque[] obtenerBloques() {
		return bloques;
	}
	
	public boolean posDisponible(int x,int y) {
		boolean disponible=true;
		if(x>20 || x<0  || y>9 || y<0 || !grilla[x][y].obtenerDisponible())
			disponible=false;
		return disponible;
	}

	public void vaciarBloques() {
		bloques[0].actualizarDisponible(true);
		bloques[1].actualizarDisponible(true);
		bloques[2].actualizarDisponible(true);
		bloques[3].actualizarDisponible(true);
	}

	public void ocuparBloques() {
		bloques[0].actualizarDisponible(false);
		bloques[1].actualizarDisponible(false);
		bloques[2].actualizarDisponible(false);
		bloques[3].actualizarDisponible(false);
	}

	public Bloque[] actualizarPos() {
		int x0,x1,x2,x3,y0,y1,y2,y3;
		x0= bloques[0].obtenerPosEnGrillaX();
		x1= bloques[1].obtenerPosEnGrillaX();
		x2= bloques[2].obtenerPosEnGrillaX();
		x3= bloques[3].obtenerPosEnGrillaX();
		y0= bloques[0].obtenerPosEnGrillaY();
		y1= bloques[1].obtenerPosEnGrillaY();
		y2= bloques[2].obtenerPosEnGrillaY();
		y3= bloques[3].obtenerPosEnGrillaY();
		vaciarBloques();
		if(!posDisponible(x0+1,y0) || !posDisponible(x1+1,y1) || !posDisponible(x2+1,y2) || !posDisponible(x3+1,y3)) {
			ocuparBloques();
			return null;
		}
		bloques[0]= grilla[x0+1][y0];
		bloques[1]= grilla[x1+1][y1];
		bloques[2]= grilla[x2+1][y2];
		bloques[3]= grilla[x3+1][y3];
		ocuparBloques();
		return bloques;
	}

	abstract Bloque[] moverTetriminoIzq();

	abstract Bloque[] moverTetriminoDer();

	abstract Bloque[] rotarTetrimino();

}
