
public class Juego {

	protected int puntos, velocidad;
	protected boolean terminoElJuego;
	protected Tetrimino tetriminoActivo, tetriminoSig;
	protected GUI miGui;
	protected Reloj miReloj;
	protected Bloque[][] grilla;
	
	public Juego(GUI g, Reloj r) {
		puntos = 0;
		velocidad = 0;
		miGui = g;
		miReloj  = r;
		grilla = new Bloque[21][10];
	}
	
	public int obtenerPuntos() {
		return puntos;
	}
	
	public int obtenerVelocidad() {
		return velocidad;
	}
	
	public boolean obtenerTerminoElJuego() {
		return terminoElJuego;
	}
	
	public Reloj obtenerReloj() {
		return miReloj;
	}
	
	public void aumentarVelocidad() {} 
	
	public void aumentarTiempo() {}  
	
	public Tetrimino obtenerTetriminoActivo() {
		
		return tetriminoActivo;
	}
	
	public Tetrimino obtenerTetriminoSig() {
		
		return tetriminoSig;
	}
	
	public void actualizarPosTetrimino() {
		
		tetriminoActivo.actualizarPos();
	}
	
	public void moverTetriminoIzq() {
		
		tetriminoActivo.moverTetriminoIzq();
	}
	
	public void moverTetriminoDer() {
		
		tetriminoActivo.moverTetriminoDer();
	}
	
	public void rotarTetrimino() { 
		
		tetriminoActivo.rotarTetrimino();
	}
	
	public boolean finCaidaTetrimino() {return false;} 
	
	public boolean hayFilaCompleta() {return false;} 
	
	public void eliminarFila(int fila) {} 
	
	public void sumarPuntos(int filaComp) {} 
	
	public void finalizarJuego() {} 
}