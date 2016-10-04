package edu.ub.juanadearco.actors;

import edu.ub.juanadearco.Actor;
import edu.ub.juanadearco.Colisio;
import edu.ub.juanadearco.Constants;
import edu.ub.juanadearco.Context;
import edu.ub.juanadearco.Util;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

// Prenem Menjar.java com a plantilla

public class Brayan extends AbstractActor {
	private Image image;
	private int amplada;
	private int alcada;
	private String nom;

// Fem import de l'imatge sense variables, ja que és única
	public Brayan(String nom, int imgPosX, int imgPosY, 
        	int imgAmplada, int imgAlcada) {
        	this.nom = "General Brayan";
        	this.image = Util.carregarImatge("brayan.png", 
                	0, 0, 25, 50);
        	this.amplada = 25;
        	this.alcada = 50;
		setEstat(Constants.ESTAT_ACTIU);
	}
	
	public void actualitzar(Context context) {
	}
	
	public Rectangle getLimits() {
	  return new Rectangle(getX(), getY(), amplada, alcada);
	}
	
// Fem passar un métode (setHaTrobatBrayan) que es posa true quan xoca amb la heroina
	public void tractarColisio(Colisio colisio) {
	   Actor actor = colisio.getActor();
	   if (actor instanceof Heroina) {
	     Heroina heroina = (Heroina)actor;
	     heroina.setHaTrobatBrayan(true);
	     setEstat(Constants.ESTAT_INACTIU);
	   }
	}
	
	public void render(Graphics2D g) {
        g.drawImage(image, getX(), getY(), observer);
        g.setColor(Color.GREEN);
        Font f = new Font("Dialog", Font.BOLD, 10);
        g.setFont(f);
        g.drawString(nom, getX(), getY() - 3);
    }
}