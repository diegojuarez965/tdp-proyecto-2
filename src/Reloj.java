
public class Reloj implements Runnable{
	
	private Juego juego;
	private boolean perdio;
	private int intervaloIncrementoVelocidad;
	
	public Reloj() {
		juego = null;
		perdio = false;
		intervaloIncrementoVelocidad = 20;
	}
	
	@Override
	public void run() {
		long tiempoTranscurrido, tiempoNuevo, tiempoViejo = System.currentTimeMillis();
		int velocidad;
		while(!perdio) {
			
			velocidad = juego.obtenerVelocidad();
			for(int i = velocidad; i>0; i--) {
				try {
					Thread.sleep(1000/velocidad);
					juego.operar(juego.MOVER_ABAJO);
				} catch (InterruptedException e) {e.printStackTrace();}
			}
			tiempoNuevo = System.currentTimeMillis();
			tiempoTranscurrido = tiempoNuevo-tiempoViejo;
			juego.aumentarTiempo(tiempoTranscurrido/1000);
			if((tiempoTranscurrido/1000)%intervaloIncrementoVelocidad==0)
				juego.aumentarVelocidad();
		}
	}
	
	public void setJuego(Juego j) {
		juego = j;
	}
	public void parar() {
		perdio = true;
	}
	public void setIncrementoVel(int v) {
		intervaloIncrementoVelocidad = v;
	}
	public int getIncrementoVel() {
		return intervaloIncrementoVelocidad;
	}
}
