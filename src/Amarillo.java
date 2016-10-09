import processing.core.PApplet;
import processing.core.PImage;

public class Amarillo implements Organismos {

		private PApplet app;
		private PImage amarillito;
		public int posX, posY;

		public Amarillo(PApplet app, PImage amarillito) {
			this.app = app;
			this.amarillito = amarillito;
			posX = (int) app.random(50, 350);
			posY = (int) app.random(50, 550);
			// cargo la imagen

		}

		public void pintar() {
			app.image(amarillito, posX, posY);
		}

		
		public int getPosX() {
			return (int) posX;
		}

		
		public int getPosY() {
			return (int) posY;
		}

		
		public void setPosX(int posX) {
			this.posX = posX;
		}

		
		public void setPosY(int posY) {
			this.posY = posY;

		}

	}
