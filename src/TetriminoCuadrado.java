
public class TetriminoCuadrado extends Tetrimino {

	public TetriminoCuadrado(Bloque grilla[][]) {
		super(grilla);
		icono= "/images/TetriminoCuadrado.png";
		color= "/images/BloqueCuadrado.png";
		bloques[0]= grilla[0][4];
		bloques[1]= grilla[0][5];
		bloques[2]= grilla[1][4];
		bloques[3]= grilla[1][5];
		ocuparBloques();
	}

	public Bloque[] rotarTetrimino(){
		return bloques;
	}

}
