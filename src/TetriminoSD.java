
public class TetriminoSD extends Tetrimino {

	public TetriminoSD(Bloque grilla[][]) {
		super(grilla);
		icono= "/images/TetriminoSD.png";
		color= "/images/BloqueSD.png";
		bloques[0]= grilla[1][3];
		bloques[1]= grilla[1][4];
		bloques[2]= grilla[0][4];
		bloques[3]= grilla[0][5];
		ocuparBloques();
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
		switch(orientacion) {
		case 0:{
			if(!posDisponible(x0,y0-1) || !posDisponible(x2,y2-1))
				return null;
		}
		case 90:{
			if(!posDisponible(x0,y0-1) || !posDisponible(x1,y1-1) || !posDisponible(x3,y3-1))
				return null;
		}
		case 180:{
			if(!posDisponible(x1,y1-1) || !posDisponible(x3,y3-1))
				return null;	
		}
		case 270:{
			if(!posDisponible(x0,y0-1) || !posDisponible(x2,y2-1) || !posDisponible(x3,y3-1))
				return null;
		}
		}
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
		switch(orientacion) {
		case 0:{
			if(!posDisponible(x1,y1+1) || !posDisponible(x3,y3+1))
				return null;
		}
		case 90:{
			if(!posDisponible(x0,y0+1) || !posDisponible(x2,y2+1) || !posDisponible(x3,y3+1))
				return null;
		}
		case 180:{
			if(!posDisponible(x0,y0+1) || !posDisponible(x2,y2+1))
				return null;	
		}
		case 270:{
			if(!posDisponible(x0,y0+1) || !posDisponible(x1,y1+1) || !posDisponible(x3,y3+1))
				return null;
		}
		}
		vaciarBloques();
		bloques[0]= grilla[x0][y0+1];
		bloques[1]= grilla[x1][y1+1];
		bloques[2]= grilla[x2][y2+1];
		bloques[3]= grilla[x3][y3+1];
		ocuparBloques();
		return bloques;
	}

	public Bloque[] rotarTetrimino(){
		int x,y;
		x= bloques[1].obtenerPosEnGrillaX();
		y= bloques[1].obtenerPosEnGrillaY();
		vaciarBloques();
		switch(orientacion){
		case 0:{
			if(!posDisponible(x-1,y)|| !posDisponible(x,y+1)|| !posDisponible(x+1,y+1)) {
				ocuparBloques();
				return null;
			}
			bloques[0]= grilla[x-1][y];
			bloques[2]= grilla[x][y+1];
			bloques[3]= grilla[x+1][y+1];
			orientacion=90;
			break;
		}
		case 90:{
			if(!posDisponible(x,y+1)|| !posDisponible(x+1,y)|| !posDisponible(x+1,y-1)) {
				ocuparBloques();
				return null;
			}
			bloques[0]= grilla[x][y+1];
			bloques[2]= grilla[x+1][y];
			bloques[3]= grilla[x+1][y-1];
			orientacion=180;
			break;
		}
		case 180:{
			if(!posDisponible(x+1,y)|| !posDisponible(x,y-1)|| !posDisponible(x-1,y-1)) {
				ocuparBloques();
				return null;
			}
			bloques[0]= grilla[x+1][y];
			bloques[2]= grilla[x][y-1];
			bloques[3]= grilla[x-1][y-1];
			orientacion=270;
			break;
		}
		case 270:{
			if(!posDisponible(x,y-1)|| !posDisponible(x-1,y)|| !posDisponible(x-1,y+1)) {
				ocuparBloques();
				return null;
			}
			bloques[0]= grilla[x][y-1];
			bloques[2]= grilla[x-1][y];
			bloques[3]= grilla[x-1][y+1];
			orientacion=0;
			break;
		}
		}
		ocuparBloques();
		return bloques;
	}

}
