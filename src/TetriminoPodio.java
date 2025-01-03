
public class TetriminoPodio extends Tetrimino {

	public TetriminoPodio(Bloque grilla[][]) {
		super(grilla);
		icono = "/images/TetriminoPodio.png";
		color = "/images/BloquePodio.png";
		bloques[0] = grilla[1][4];
		bloques[1] = grilla[1][5];
		bloques[2] = grilla[1][6];
		bloques[3] = grilla[0][5];
	}

	public Bloque[] moverTetriminoIzq() {
		int x0, x1, x2, x3, y0, y1, y2, y3;
		x0 = bloques[0].obtenerPosEnGrillaX();
		x1 = bloques[1].obtenerPosEnGrillaX();
		x2 = bloques[2].obtenerPosEnGrillaX();
		x3 = bloques[3].obtenerPosEnGrillaX();
		y0 = bloques[0].obtenerPosEnGrillaY();
		y1 = bloques[1].obtenerPosEnGrillaY();
		y2 = bloques[2].obtenerPosEnGrillaY();
		y3 = bloques[3].obtenerPosEnGrillaY();
		switch (orientacion) {
		case 0: {
			if (!posDisponible(x0, y0 - 1) || !posDisponible(x3, y3 - 1))
				return null;
			break;
		}
		case 90: {
			if (!posDisponible(x0, y0 - 1) || !posDisponible(x1, y1 - 1) || !posDisponible(x2, y2 - 1))
				return null;
			break;
		}
		case 180: {
			if (!posDisponible(x2, y2 - 1) || !posDisponible(x3, y3 - 1))
				return null;
			break;
		}
		case 270: {
			if (!posDisponible(x0, y0 - 1) || !posDisponible(x2, y2 - 1) || !posDisponible(x3, y3 - 1))
				return null;
			break;
		}
		}
		vaciarBloques();
		bloques[0] = grilla[x0][y0 - 1];
		bloques[1] = grilla[x1][y1 - 1];
		bloques[2] = grilla[x2][y2 - 1];
		bloques[3] = grilla[x3][y3 - 1];
		ocuparBloques();
		return bloques;
	}

	public Bloque[] moverTetriminoDer() {
		int x0, x1, x2, x3, y0, y1, y2, y3;
		x0 = bloques[0].obtenerPosEnGrillaX();
		x1 = bloques[1].obtenerPosEnGrillaX();
		x2 = bloques[2].obtenerPosEnGrillaX();
		x3 = bloques[3].obtenerPosEnGrillaX();
		y0 = bloques[0].obtenerPosEnGrillaY();
		y1 = bloques[1].obtenerPosEnGrillaY();
		y2 = bloques[2].obtenerPosEnGrillaY();
		y3 = bloques[3].obtenerPosEnGrillaY();
		switch (orientacion) {
		case 0: {
			if (!posDisponible(x2, y2 + 1) || !posDisponible(x3, y3 + 1))
				return null;
			break;
		}
		case 90: {
			if (!posDisponible(x0, y0 + 1) || !posDisponible(x2, y2 + 1) || !posDisponible(x3, y3 + 1))
				return null;
			break;
		}
		case 180: {
			if (!posDisponible(x0, y0 + 1) || !posDisponible(x3, y3 + 1))
				return null;
			break;
		}
		case 270: {
			if (!posDisponible(x0, y0 + 1) || !posDisponible(x1, y1 + 1) || !posDisponible(x2, y2 + 1))
				return null;
			break;
		}
		}
		vaciarBloques();
		bloques[0] = grilla[x0][y0 + 1];
		bloques[1] = grilla[x1][y1 + 1];
		bloques[2] = grilla[x2][y2 + 1];
		bloques[3] = grilla[x3][y3 + 1];
		ocuparBloques();
		return bloques;
	}

	public Bloque[] rotarTetrimino() {
		int x, y;
		x = bloques[1].obtenerPosEnGrillaX();
		y = bloques[1].obtenerPosEnGrillaY();
		vaciarBloques();
		switch (orientacion) {
		case 0: {
			if (!posDisponible(x - 1, y) || !posDisponible(x + 1, y) || !posDisponible(x, y + 1)) {
				ocuparBloques();
				return null;
			}
			bloques[0] = grilla[x - 1][y];
			bloques[2] = grilla[x + 1][y];
			bloques[3] = grilla[x][y + 1];
			orientacion = 90;
			break;
		}
		case 90: {
			if (!posDisponible(x, y + 1) || !posDisponible(x, y - 1) || !posDisponible(x + 1, y)) {
				ocuparBloques();
				return null;
			}
			bloques[0] = grilla[x][y + 1];
			bloques[2] = grilla[x][y - 1];
			bloques[3] = grilla[x + 1][y];
			orientacion = 180;
			break;
		}
		case 180: {
			if (!posDisponible(x + 1, y) || !posDisponible(x - 1, y) || !posDisponible(x, y - 1)) {
				ocuparBloques();
				return null;
			}
			bloques[0] = grilla[x + 1][y];
			bloques[2] = grilla[x - 1][y];
			bloques[3] = grilla[x][y - 1];
			orientacion = 270;
			break;
		}
		case 270: {
			if (!posDisponible(x, y - 1) || !posDisponible(x, y + 1) || !posDisponible(x - 1, y)) {
				ocuparBloques();
				return null;
			}
			bloques[0] = grilla[x][y - 1];
			bloques[2] = grilla[x][y + 1];
			bloques[3] = grilla[x - 1][y];
			orientacion = 0;
			break;
		}
		}
		ocuparBloques();
		return bloques;
	}

}
