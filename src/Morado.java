import processing.core.PApplet;
import processing.core.PImage;

public class Morado implements Organismos{
	private PApplet app;
	private PImage moradis;
	public int posX,posY;

	
	public Morado(PApplet app,PImage moradis) {
		this.app=app;
		this.moradis=moradis;
		posX= (int) app.random(50,350);
		posY= (int) app.random(50,550);
		//cargo la imagen
		
		
			}


	@Override
	public void pintar() {
		app.image(moradis, posX,posY);		
	}


	@Override
	public int getPosX() {
		return (int) posX;
	}


	@Override
	public int getPosY() {
		return (int) posY;
	}


	@Override
	public void setPosX(int posX) {
		this.posX=posX;
	}


	@Override
	public void setPosY(int posY) {
		this.posY=posY;

	}

	
}
