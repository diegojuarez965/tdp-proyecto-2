
public class TetriminoCuadrado extends Tetrimino {

	public TetriminoCuadrado(Bloque grilla[][]) {
		super(grilla);
		icono= "/images/TetriminoCuadrado.png";
		color= "/images/BloqueCuadrado.png";
		bloques[0]= grilla[0][4];
		bloques[1]= grilla[0][5];
		bloques[2]= grilla[1][4];
		bloques[3]= grilla[1][5];
	}

	public Bloque[] moverTetriminoIzq() {
		int x0,x1,x2,x3,y0,y1,y2,y3;
		x0= bloques[0].obtenerPosEnGrillaX();
		x1= bloques[1].obtenerPosEnGrillaX();
		x2= bloques[2].obtenerPosEnGrillaX();
		x3= bloques[3].obtenerPosEnGrillaX();
		y0= bloques[0].obtenerPosEnGrillaY();
		y1= bloques[1].obtenerPosEnGrillaY();
		y2= bloques[2].obtenerPosEnGrillaY();
		y3= bloques[3].obtenerPosEnGrillaY();
		if(!posDisponible(x0,y0-1) || !posDisponible(x2,y2-1))
			return null;
		vaciarBloques();
		bloques[0]= grilla[x0][y0-1];
		bloques[1]= grilla[x1][y1-1];
		bloques[2]= grilla[x2][y2-1];
		bloques[3]= grilla[x3][y3-1];
		ocuparBloques();
		return bloques;
	}

	public Bloque[] moverTetriminoDer() {
		int x0,x1,x2,x3,y0,y1,y2,y3;
		x0= bloques[0].obtenerPosEnGrillaX();
		x1= bloques[1].obtenerPosEnGrillaX();
		x2= bloques[2].obtenerPosEnGrillaX();
		x3= bloques[3].obtenerPosEnGrillaX();
		y0= bloques[0].obtenerPosEnGrillaY();
		y1= bloques[1].obtenerPosEnGrillaY();
		y2= bloques[2].obtenerPosEnGrillaY();
		y3= bloques[3].obtenerPosEnGrillaY();
		if(!posDisponible(x1,y1+1) || !posDisponible(x3,y3+1))
			return null;
		vaciarBloques();
		bloques[0]= grilla[x0][y0+1];
		bloques[1]= grilla[x1][y1+1];
		bloques[2]= grilla[x2][y2+1];
		bloques[3]= grilla[x3][y3+1];
		ocuparBloques();
		return bloques;
	}

	public Bloque[] rotarTetrimino(){
		return bloques;
	}

}
