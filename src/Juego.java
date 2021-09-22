import java.time.LocalTime;
import java.util.Random;

public class Juego {

	protected int puntos;
	protected int velocidad; //Cantida de veces que se actualiza por segundo.
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
		for(int i = 0; i<21; i++)
			for(int j = 0; j<10; j++)
				grilla[i][j] = new Bloque(i,j);
		
		tetriminoActivo = randomTetrimino();
		tetriminoSig = randomTetrimino();
		Bloque[] bloquesActivo = tetriminoActivo.obtenerBloques();
		for(int i = 0; i<4; i++)
			miGui.actualizarBloque(bloquesActivo[i].obtenerPosEnGrillaX(), bloquesActivo[i].obtenerPosEnGrillaY(), tetriminoActivo.obtenerColor());
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
	
	public void aumentarVelocidad() {
		velocidad++;
	} 
	
	public void aumentarTiempo(long tiempo) {
		miGui.actualizarTiempo(LocalTime.MIN.plusSeconds(tiempo).toString());
	}  
	
	public Tetrimino obtenerTetriminoActivo() {
		
		return tetriminoActivo;
	}
	
	public Tetrimino obtenerTetriminoSig() {
		
		return tetriminoSig;
	}
	
	public void actualizarPosTetrimino() {
		Bloque[] bloquesT = tetriminoActivo.obtenerBloques();
		Bloque[] bloquesViejos = {bloquesT[0],bloquesT[1],bloquesT[2],bloquesT[3]};
		Bloque[] bloquesNuevos = tetriminoActivo.actualizarPos();
		if(bloquesNuevos!=null) {
			for(int i = 0; i<4; i++) {
				miGui.actualizarBloque(bloquesViejos[i].obtenerPosEnGrillaX(), bloquesViejos[i].obtenerPosEnGrillaY(), "\\images\\FondoNegro.png");
				miGui.actualizarBloque(bloquesNuevos[i].obtenerPosEnGrillaX(), bloquesNuevos[i].obtenerPosEnGrillaY(), tetriminoActivo.obtenerColor());
			}
		}
	}
	
	public void moverTetriminoIzq() {
		Bloque[] bloquesT = tetriminoActivo.obtenerBloques();
		Bloque[] bloquesViejos = {bloquesT[0],bloquesT[1],bloquesT[2],bloquesT[3]};
		Bloque[] bloquesNuevos = tetriminoActivo.moverTetriminoIzq();
		if(bloquesNuevos!=null) {
			for(int i = 0; i<4; i++) {
				miGui.actualizarBloque(bloquesViejos[i].obtenerPosEnGrillaX(), bloquesViejos[i].obtenerPosEnGrillaY(), "\\images\\FondoNegro.png");
				miGui.actualizarBloque(bloquesNuevos[i].obtenerPosEnGrillaX(), bloquesNuevos[i].obtenerPosEnGrillaY(), tetriminoActivo.obtenerColor());
			}
		}
	}
	
	public void moverTetriminoDer() {
		Bloque[] bloquesT = tetriminoActivo.obtenerBloques();
		Bloque[] bloquesViejos = {bloquesT[0],bloquesT[1],bloquesT[2],bloquesT[3]};
		Bloque[] bloquesNuevos = tetriminoActivo.moverTetriminoDer();
		if(bloquesNuevos!=null) {
			for(int i = 0; i<4; i++) {
				miGui.actualizarBloque(bloquesViejos[i].obtenerPosEnGrillaX(), bloquesViejos[i].obtenerPosEnGrillaY(), "\\images\\FondoNegro.png");
				miGui.actualizarBloque(bloquesNuevos[i].obtenerPosEnGrillaX(), bloquesNuevos[i].obtenerPosEnGrillaY(), tetriminoActivo.obtenerColor());
			}
		}
	}
	
	public void rotarTetrimino() { 
		Bloque[] bloquesT = tetriminoActivo.obtenerBloques();
		Bloque[] bloquesViejos = {bloquesT[0],bloquesT[1],bloquesT[2],bloquesT[3]};
		Bloque[] bloquesNuevos = tetriminoActivo.rotarTetrimino();
		if(bloquesNuevos!=null) {
			for(int i = 0; i<4; i++) {
				miGui.actualizarBloque(bloquesViejos[i].obtenerPosEnGrillaX(), bloquesViejos[i].obtenerPosEnGrillaY(), "\\images\\FondoNegro.png");
				miGui.actualizarBloque(bloquesNuevos[i].obtenerPosEnGrillaX(), bloquesNuevos[i].obtenerPosEnGrillaY(), tetriminoActivo.obtenerColor());
			}
		}
	}
	
	public boolean finCaidaTetrimino() {return false;} 
	
	public boolean hayFilaCompleta() {return false;} 
	
	public void eliminarFila(int fila) {} 
	
	public void sumarPuntos(int filaComp) {} 
	
	public void finalizarJuego() {} 
	
	private Tetrimino randomTetrimino() {
		Tetrimino t = null;
		Random random = new Random();
		switch(random.nextInt(7)){
			case 0: t = new TetriminoCuadrado(grilla); break;
			case 1: t = new TetriminoCuadrado(grilla); break;
			case 2: t = new TetriminoPodio(grilla); break;
			case 3: t = new TetriminoSD(grilla); break;
			case 4: t = new TetriminoPodio(grilla); break;
			case 5: t = new TetriminoSD(grilla); break;
			case 6: t = new TetriminoSI(grilla); break;
		}
		return t;
	}
}