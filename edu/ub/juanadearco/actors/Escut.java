/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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

// Fem quasibé lo mateix que amb Brayan.java peró per propietats d'escut

public class Escut extends AbstractActor {
	private Image image;
	private int amplada;
	private int alcada;
	private String nom;

	public Escut(String nom, int imgPosX, int imgPosY, 
        	int imgAmplada, int imgAlcada) {
        	this.nom = "Escut";
        	this.image = Util.carregarImatge("objectes.png", 
                	4, 85, 32, 36);
        	this.amplada = 32;
        	this.alcada = 36;
		setEstat(Constants.ESTAT_ACTIU);
	}
	public void actualitzar(Context context) {
	}
	public Rectangle getLimits() {
	  return new Rectangle(getX(), getY(), amplada, alcada);
	}
	public void tractarColisio(Colisio colisio) {
	   Actor actor = colisio.getActor();
	   if (actor instanceof Heroina) {
	     Heroina heroina = (Heroina)actor;
	     heroina.setHaTrobatEscut(true);
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