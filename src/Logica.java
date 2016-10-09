import java.util.ArrayList;
import java.util.LinkedList;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PShape;

public class Logica {
	private PApplet app;

	// DEFINO LAS VARIABLESSSSSS
	private PImage inicial;
	private PImage interac;
	private PImage gameOver;
	private int pantalla;

	// principal
	private PImage prin;	
	private Principal principalito;

	// DEFINO VARIABLES DE ELEMENTOS
	private PImage moradis;
	private PImage amarillito;
	private PImage azulito;
	private Morado moradito;
	private Azul azules;
	private Amarillo amarillis;
	
	//DEFINO ARRAYLIST
	private ArrayList<Organismos> organismos;
	//private ArrayList<Enemigo> enemigos;
	
	


	public Logica(PApplet app) {
		this.app = app;
		
		moradis= app.loadImage("morado.png");
		azulito= app.loadImage("azul.png");
		amarillito= app.loadImage("amarillo.png");


		principalito = new Principal(app);
		pantalla = 0;
		
       //ELEMENTOSSSSS
		moradito= new Morado(app,moradis);
		azules= new Azul(app,azulito);
		amarillis= new Amarillo(app,amarillito);


		
		organismos = new ArrayList<Organismos>();
		//enemigos = new ArrayList<Enemigo>();
		
		
		//le agrego los elementos al arraylist de organismos
		organismos.add(moradito);
		organismos.add(azules);
		organismos.add(amarillis);



		// -------------------------cargo las imagenes
		// Pantallas
		inicial = app.loadImage("pantallas-02.jpg");
		interac = app.loadImage("pantallas-01.jpg");
		gameOver = app.loadImage("pantallas-03.jpg");

		// elemento principal
		app.imageMode(app.CENTER);
		// prin = app.loadImage("Princial.png");
		app.imageMode(app.CORNER);

	}

	public void ejecutable() {

		switch (pantalla) {
		case 0:
			inicio();
			break;

		case 1:
			interaccion();
			break;

		case 2:
			perdio();
			break;
		}
	}

	// ----PANTALLAAAAAA INICIAAAAAL----

	public void inicio() {
		app.image(inicial, 0, 0);
	}

	// --------------------------------------------

	// ----PANTALLAAAAAA INTERACCIONNNNNNNN----

	public void interaccion() {

		// ---------------se pinta la pantalla interactiva
		app.image(interac, 0, 0);

		// ------------PINTA ELEMENTOS------
		// se pintan el elemento principal
		principalito.datos();
		principalito.seguirMouse();
		principalito.pintar();

		// Se pintan organismos
		for (int i = 0; i < organismos.size(); i++) {
			Organismos org= organismos.get(i);
			org.pintar();
			
			if(principalito.distanciaAlimento(org.getPosX(), org.getPosY())==true){
				
				//toque con elemento azul
				if(org instanceof Azul){
				principalito.setVelMax(0.2f);
				principalito.agregarIngerido(org);
				Organismos orgAzul = new Azul(app,azulito);
				organismos.add(orgAzul);
				
				organismos.remove(org);

				}
				
				if(org instanceof Amarillo){
					principalito.setVelMax(0.2f);	
					}
				
				if(org instanceof Morado){
					principalito.setVelMax(0.2f);	
					}
				
				
				
			}
			
		}
	}

	public void perdio() {
		app.image(gameOver, 0, 0);
	}

	public void pasarPantallas() {
		System.out.println(app.mouseX + "   " + app.mouseY);

		if (app.mouseX >= 449 && app.mouseX <= 567 && app.mouseY >= 545 && app.mouseY <= 635) {
			pantalla = 1;
		}

	}
	
	}


