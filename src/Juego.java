import java.time.LocalTime;
import java.util.LinkedList;
import java.util.Random;

public class Juego {

	protected int puntos;
	protected int velocidad; //Cantida de veces que se actualiza por segundo.
	protected boolean terminoElJuego;
	protected Tetrimino tetriminoActivo, tetriminoSig;
	protected GUI miGui;
	protected Reloj miReloj;
	protected Bloque[][] grilla;
	
	public final int MOVER_ABAJO = 0;
	public final int MOVER_DERECHA = 1;
	public final int MOVER_IZQUIERDA = 2;
	public final int ROTAR = 3;
	
	private final String fondoDefault = "/images/FondoNegro.png";
	
	public Juego(Reloj r) {
		puntos = 0;
		velocidad = 0;
		miReloj  = r;
		
		grilla = new Bloque[21][10];
		for(int i = 0; i<21; i++)
			for(int j = 0; j<10; j++)
				grilla[i][j] = new Bloque(i,j);
		
		tetriminoActivo = randomTetrimino();
		tetriminoActivo.ocuparBloques();
		tetriminoSig = randomTetrimino();
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
	
	public synchronized void operar(int op) {
		switch(op) {
			case MOVER_ABAJO: {actualizarPosTetrimino(); break;}
			case MOVER_DERECHA: {moverTetriminoDer(); break;}
			case MOVER_IZQUIERDA: {moverTetriminoIzq(); break;}
			case ROTAR: {rotarTetrimino(); break;}
		}
	}
	
	private void actualizarPosTetrimino() {
		Bloque[] bloquesT = tetriminoActivo.obtenerBloques();
		Bloque[] bloquesViejos = {bloquesT[0],bloquesT[1],bloquesT[2],bloquesT[3]};
		Bloque[] bloquesNuevos = tetriminoActivo.actualizarPos();
		if(bloquesNuevos!=null) {
			actualizarBloques(bloquesViejos, fondoDefault);
			actualizarBloques(bloquesNuevos, tetriminoActivo.obtenerColor());
		}
		else {
			chequearFinJuego();
			eliminarFila();
			tetriminoActivo = tetriminoSig;
			tetriminoSig = randomTetrimino();
			miGui.actualizarProxTetrimino(tetriminoSig.icono);
		}
	}
	
	private void moverTetriminoIzq() {
		Bloque[] bloquesT = tetriminoActivo.obtenerBloques();
		Bloque[] bloquesViejos = {bloquesT[0],bloquesT[1],bloquesT[2],bloquesT[3]};
		Bloque[] bloquesNuevos = tetriminoActivo.moverTetriminoIzq();
		if(bloquesNuevos!=null) {
			actualizarBloques(bloquesViejos, fondoDefault);
			actualizarBloques(bloquesNuevos, tetriminoActivo.obtenerColor());
		}
	}
	
	private void moverTetriminoDer() {
		Bloque[] bloquesT = tetriminoActivo.obtenerBloques();
		Bloque[] bloquesViejos = {bloquesT[0],bloquesT[1],bloquesT[2],bloquesT[3]};
		Bloque[] bloquesNuevos = tetriminoActivo.moverTetriminoDer();
		if(bloquesNuevos!=null) {
			actualizarBloques(bloquesViejos, fondoDefault);
			actualizarBloques(bloquesNuevos, tetriminoActivo.obtenerColor());
		}
	}
	
	private void rotarTetrimino() { 
		Bloque[] bloquesT = tetriminoActivo.obtenerBloques();
		Bloque[] bloquesViejos = {bloquesT[0],bloquesT[1],bloquesT[2],bloquesT[3]};
		Bloque[] bloquesNuevos = tetriminoActivo.rotarTetrimino();
		if(bloquesNuevos!=null) {
			actualizarBloques(bloquesViejos, fondoDefault);
			actualizarBloques(bloquesNuevos, tetriminoActivo.obtenerColor());
		}
	}
	
	private void actualizarBloques(Bloque[] bloques, String imagen) {
		for(Bloque b : bloques)
			miGui.actualizarBloque(b.obtenerPosEnGrillaX(), b.obtenerPosEnGrillaY(), imagen);
	}

	
	public void eliminarFila() {
		int cont=0;
		Bloque[] bloques=tetriminoActivo.obtenerBloques();
		LinkedList<Integer> filas = new LinkedList<Integer>();
		for (int i=0; i<4;i++) {
			int f=bloques[i].obtenerPosEnGrillaX();
			boolean filaCompleta=true;
			int c=0;
			while(filaCompleta && c<10) 
				if(grilla[f][c].disponible) 
					filaCompleta=false;
				else 
					c++;
			if(filaCompleta) {
				cont++;
				if(!filas.contains(f))
					filas.add(f);
			}
		}
		filas.sort(null);
		for(int i : filas)
			reacomodarFila(i);
		sumarPuntos(cont);
	} 
	
	
	private void reacomodarFila(int fila) {
		for (int filaArriba=fila-1; filaArriba>-1;filaArriba--,fila--) {
			for (int c=0;c<10;c++) {
				grilla[fila][c].actualizarDisponible(grilla[filaArriba][c].obtenerDisponible());
				grilla[filaArriba][c].actualizarDisponible(true);
				miGui.actualizarBloque(fila, c, miGui.obtenerImagenBloque(filaArriba, c));
				miGui.actualizarBloque(filaArriba, c, fondoDefault);
			}
		}
	}
	private void sumarPuntos(int filaComp) {
		int puntosSumar = 0;
		switch(filaComp) {
			case 1: {puntosSumar = 100; break;}
			case 2: {puntosSumar = 200; break;}
			case 3: {puntosSumar = 500; break;}
			case 4: {puntosSumar = 800; break;}
		}
		puntos += puntosSumar;
		miGui.actualizarPuntos(puntos);
	} 
	
	
	private void chequearFinJuego() {
		int c=0;
		boolean termino=false;
		while(!termino && c<10) {
			if(!grilla[0][c].obtenerDisponible()) 
				termino=true;
			c++;
		}
		if(termino)
			finalizarJuego();
	}
	
	public void finalizarJuego() {
		miReloj.parar();
		miGui.finalizar();
	} 
	
	public void setGui(GUI g) {
		miGui = g;
	}
	public void crearTetrimino() {
		if(miGui!=null) {
			Bloque[] bloquesActivo = tetriminoActivo.obtenerBloques();
			for(int i = 0; i<4; i++)
				miGui.actualizarBloque(bloquesActivo[i].obtenerPosEnGrillaX(), bloquesActivo[i].obtenerPosEnGrillaY(), tetriminoActivo.obtenerColor());
		}
	}
	private Tetrimino randomTetrimino() {
		Tetrimino t = null;
		Random random = new Random();
		switch(random.nextInt(6)){
			case 0: t = new TetriminoCuadrado(grilla); break;
			case 1: t = new TetriminoPodio(grilla); break;
			case 2: t = new TetriminoSD(grilla); break;
			case 3: t = new TetriminoSI(grilla); break;
			case 4: t = new TetriminoLinea(grilla);break;
			case 5: t = new TetriminoLI(grilla);break;
			case 6: t = new TetriminoLD(grilla);break;
		}
		return t;
	}
}