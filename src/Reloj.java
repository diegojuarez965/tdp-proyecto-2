
public class Reloj implements Runnable{
	
	private Juego juego;
	private boolean perdio;
	
	public Reloj() {
		juego = null;
		perdio = false;
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
					juego.actualizarPosTetrimino();
				} catch (InterruptedException e) {e.printStackTrace();}
			}
			tiempoNuevo = System.currentTimeMillis();
			tiempoTranscurrido = tiempoNuevo-tiempoViejo;
			juego.aumentarTiempo(tiempoTranscurrido/1000);
			if((tiempoTranscurrido/1000)%10==0) //Se aumenta la velocidad cada 10s
				juego.aumentarVelocidad();
		}
	}
	
	public void setJuego(Juego j) {
		juego = j;
	}
	public void parar() {
		perdio = true;
	}
}
