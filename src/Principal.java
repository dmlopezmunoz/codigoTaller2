import java.util.LinkedList;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Principal {
	private PApplet app;
	private PImage prin;
	private PVector velocidad, aceleracion, posicion;
	private float escala, velMax, acelMax;
	private int tipo;
	

	//DEFINO LINKEDLIST
	public LinkedList<Ingeridos> alimentos;

	public Principal(PApplet app) {
		this.app = app;
		this.prin = prin;
		
		alimentos = new LinkedList<Ingeridos>();
		velMax = 5;
		acelMax = (float) 0.1;
		
		posicion= new PVector(app.width/2,app.height/2);
		velocidad= new PVector(0,0);
		aceleracion= new PVector(0,0);
		
		prin = app.loadImage("principal.png");
		// this.tipo=tipo;
	}
	

	
	public void pintar() {

		app.pushMatrix();
		app.translate(posicion.x, posicion.y);
		app.imageMode(app.CENTER);
		app.image(prin, 0, 0);
		app.imageMode(app.CORNER);
		app.popMatrix(); // buscar

	}

	public void datos() {
		
		velocidad.add(aceleracion);
		velocidad.limit(velMax);
		posicion.add(velocidad);
		aceleracion.mult(0);
	}

	public void addAceleracion(PVector vectorNuevo) {
		aceleracion.add(vectorNuevo);

	}

	public void seguirMouse() {
		PVector mouse = new PVector(app.mouseX, app.mouseY);
		PVector distancia = PVector.sub(mouse, posicion);

		// SE CREA UNA VARIABLE LA CUAL CONTIENE EL
		// LARGO DEL VECTOR, EN ESTE CASO, LA
		// DISTANCIA
		float d = distancia.mag(); 
		distancia.normalize(); // SE COLOCA EL VECTOR A UNA ESCALA DE 1
		if (d < 100) { // SI LA DISTANCIA ES MENOR A 100 px, Que desacelere y
						// pare
			float m = PApplet.map(d, 0, 100, 0, velMax);
			distancia.mult(m);
		} else {
			distancia.mult(velMax); // LA DISTANCIA SE MULTIPLICA A LA VELOCIDAD
		}

		//se crea un vector para la direccion
		PVector direccion = PVector.sub(distancia, velocidad); 
		
		direccion.limit(acelMax); // sE LE COLOCA UN TOPE A LA DIRECCION
		addAceleracion(direccion);

	}
	
	public boolean distanciaAlimento(int x, int y){
		if(app.dist(posicion.x, posicion.y, x, y)<30){
			return true;
			
		}	else{
			return false;
		}
	
	}

	public void setVelMax(float velMax) {
		this.velMax += velMax;
	}
	
	
	public void agregarIngerido(Organismos org){
		alimentos.add(org);
	}
	

	
}
