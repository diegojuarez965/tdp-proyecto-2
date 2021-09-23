
public class TetriminoLI extends Tetrimino{
	
	public TetriminoLI(Bloque grilla[][]) {
		super(grilla);
		icono= "/images/TetriminoLI.png";
		color= "/images/BloqueLI.png";
		bloques[0]= grilla[0][6];
		bloques[1]= grilla[1][6];
		bloques[2]= grilla[1][5];
		bloques[3]= grilla[1][4];
	}

	public Bloque[] rotarTetrimino() {
		int f=bloques[0].obtenerPosEnGrillaX();
		int c=bloques[0].obtenerPosEnGrillaY();
		vaciarBloques();
		switch(orientacion) {
		case 0:{
			if(!posDisponible(f,c-2) || !posDisponible(f-1,c-2)) {
				ocuparBloques();
				return null;
			}
			bloques[0]=grilla[f+1][c-1];
			bloques[1]=grilla[f+1][c-2];
			bloques[2]=grilla[f][c-2];
			bloques[3]=grilla[f-1][c-2];
			orientacion=90;
			break;
		}
			
		case 90:{
			if(!posDisponible(f-2,c) || !posDisponible(f-2,c+1)) {
				ocuparBloques();
				return null;
			}
			bloques[0]=grilla[f-1][c-1];
			bloques[1]=grilla[f-2][c-1];
			bloques[2]=grilla[f-2][c];
			bloques[3]=grilla[f-2][c+1];
			orientacion=180;
			break;
		}
		
		case 180:{
			if(!posDisponible(f,c+2) || !posDisponible(f+1,c+2)) {
				ocuparBloques();
				return null;
			}
			bloques[0]=grilla[f-1][c+1];
			bloques[1]=grilla[f-1][c+2];
			bloques[2]=grilla[f][c+2];
			bloques[3]=grilla[f+1][c+2];
			orientacion=270;
			break;
		}
		
		case 270:{
			if(!posDisponible(f+2,c) || !posDisponible(f+2,c-1)) {
				ocuparBloques();
				return null;
			}
			bloques[0]=grilla[f+1][c+1];
			bloques[1]=grilla[f+2][c+1];
			bloques[2]=grilla[f+2][c];
			bloques[3]=grilla[f+2][c-1];
			orientacion=0;
			break;
		}
	}
	ocuparBloques();
	return bloques;
	}

	public Bloque[] moverTetriminoIzq() {
		int f0=bloques[0].obtenerPosEnGrillaX();
		int c0=bloques[0].obtenerPosEnGrillaY();
		int f1=bloques[1].obtenerPosEnGrillaX();
		int c1=bloques[1].obtenerPosEnGrillaY();
		int f2=bloques[2].obtenerPosEnGrillaX();
		int c2=bloques[2].obtenerPosEnGrillaY();
		int f3=bloques[3].obtenerPosEnGrillaX();
		int c3=bloques[3].obtenerPosEnGrillaY();
		switch(orientacion) {
		case 0:{
			if(!posDisponible(f0,c0-1) || !posDisponible(f3,c3-1)) {
				return null;
			}
			break;
		}
		case 90:{
			if(!posDisponible(f1,c1-1) || !posDisponible(f2,c2-1) || !posDisponible(f3,c3-1)) {
				return null;
			}
			break;
		}
		case 180:{
			if(!posDisponible(f0,c0-1) || !posDisponible(f1,c1-1)) {
				return null;
			}
			break;
		}
		case 270:{
			if(!posDisponible(f0,c0-1) || !posDisponible(f2,c2-1) || !posDisponible(f3,c3-1)) {
				return null;
			}
			break;
		}
		}
		vaciarBloques();
		bloques[0]=grilla[f0][c0-1];
		bloques[1]=grilla[f1][c1-1];
		bloques[2]=grilla[f2][c2-1];
		bloques[3]=grilla[f3][c3-1];
		ocuparBloques();
		return bloques;
	}

	public Bloque[] moverTetriminoDer() {
		int f0=bloques[0].obtenerPosEnGrillaX();
		int c0=bloques[0].obtenerPosEnGrillaY();
		int f1=bloques[1].obtenerPosEnGrillaX();
		int c1=bloques[1].obtenerPosEnGrillaY();
		int f2=bloques[2].obtenerPosEnGrillaX();
		int c2=bloques[2].obtenerPosEnGrillaY();
		int f3=bloques[3].obtenerPosEnGrillaX();
		int c3=bloques[3].obtenerPosEnGrillaY();
		switch(orientacion) {
		case 0:{
			if(!posDisponible(f0,c0+1) || !posDisponible(f1,c1+1)) {
				return null;
			}
			break;
		}
		case 90:{
			if(!posDisponible(f0,c0+1) || !posDisponible(f2,c2+1) || !posDisponible(f3,c3+1)) {
				return null;
			}
			break;
		}
		case 180:{
			if(!posDisponible(f0,c0+1) || !posDisponible(f3,c3+1)) {
				return null;
			}
			break;
		}
		case 270:{
			if(!posDisponible(f1,c1+1) || !posDisponible(f2,c2+1) || !posDisponible(f3,c3+1)) {
				return null;
			}
			break;
		}
		}
		vaciarBloques();
		bloques[0]=grilla[f0][c0+1];
		bloques[1]=grilla[f1][c1+1];
		bloques[2]=grilla[f2][c2+1];
		bloques[3]=grilla[f3][c3+1];
		ocuparBloques();
		return bloques;
	}
}
