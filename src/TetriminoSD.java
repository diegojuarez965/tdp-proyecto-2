
public class TetriminoSD extends Tetrimino {

	public TetriminoSD(Bloque grilla[][]) {
		super(grilla);
		icono= "/images/TetriminoSD.png";
		color= "/images/BloqueSD.png";
		bloques[0]= grilla[1][3];
		bloques[1]= grilla[1][4];
		bloques[2]= grilla[0][4];
		bloques[3]= grilla[0][5];
		bloques[0].actualizarColor(color);
		bloques[1].actualizarColor(color);
		bloques[2].actualizarColor(color);
		bloques[3].actualizarColor(color);
	}

	public Bloque[] rotar(){
		//sacar color a los bloques viejos y agregar color a los nuevos
		int x,y;
		x= bloques[1].obtenerPosEnGrillaX();
		y= bloques[1].obtenerPosEnGrillaY();
		switch(orientacion){
		case 0:{
			if(grilla[x][y-1].obtenerColor()!=null || grilla[x+1][y].obtenerColor()!=null || grilla[x+1][y+1].obtenerColor()!=null)
				return null;
			bloques[0].actualizarColor(icono);
			bloques[0]= grilla[x][y-1];
			bloques[2]= grilla[x+1][y];
			bloques[3]= grilla[x+1][y+1];
			orientacion=90;
			break;
		}
		case 90:{
			if(grilla[x+1][y].obtenerColor()!=null || grilla[x][y+1].obtenerColor()!=null || grilla[x-1][y+1].obtenerColor()!=null)
				return null;
			bloques[0]= grilla[x+1][y];
			bloques[2]= grilla[x][y+1];
			bloques[3]= grilla[x-1][y+1];
			orientacion=180;
			break;
		}
		case 180:{
			if(grilla[x][y+1].obtenerColor()!=null || grilla[x-1][y].obtenerColor()!=null || grilla[x-1][y-1].obtenerColor()!=null)
				return null;
			bloques[0]= grilla[x][y+1];
			bloques[2]= grilla[x-1][y];
			bloques[3]= grilla[x-1][y-1];
			orientacion=270;
			break;
		}
		case 270:{
			if(grilla[x-1][y].obtenerColor()!=null || grilla[x][y-1].obtenerColor()!=null || grilla[x+1][y-1].obtenerColor()!=null)
				return null;
			bloques[0]= grilla[x-1][y];
			bloques[2]= grilla[x][y-1];
			bloques[3]= grilla[x+1][y-1];
			orientacion=0;
			break;
		}
		}
		return bloques;
	}

}
