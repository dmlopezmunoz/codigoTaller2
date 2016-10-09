import processing.core.PApplet;

public class Main extends PApplet{
		private Logica app;	
		
		public static void main(String[] args) {
			PApplet.main("Main");
		}
	
		
		@Override
		public void settings() {
			size(1000,700);
		
		}
		
		@Override
		public void setup() {
			app= new Logica(this);
		}
		
		
		@Override
		public void draw() {
			background(0);
			app.ejecutable();
				
		}
		
		@Override
		public void mouseClicked() {
		app.pasarPantallas();
			
		}
	
	
}
