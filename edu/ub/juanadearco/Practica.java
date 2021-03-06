package edu.ub.juanadearco;

import edu.ub.juanadearco.actors.Heroina;
import edu.ub.juanadearco.actors.Menjar;
import edu.ub.juanadearco.actors.Brayan;
import edu.ub.juanadearco.actors.Escut;

/**
 * @author 
 * Programació I: Projecte final
 * Grup F
 */
public class Practica {

    private Joc joc;
    private Castell castell;
    private Heroina heroina;

    private static final int MAX_MENJAR_PER_HABITACIO = 2;
    
    private Practica() {
        castell = new Castell(3, 3);
        castell.addHabitacio(0, 0, crearHabitacio0Planta0());
        castell.addHabitacio(0, 1, crearHabitacio1Planta0());
        castell.addHabitacio(0, 2, crearHabitacio2Planta0());

        castell.addHabitacio(1, 0, crearHabitacio0Planta1());
        castell.addHabitacio(1, 1, crearHabitacio1Planta1());
        castell.addHabitacio(1, 2, crearHabitacio2Planta1());

        castell.addHabitacio(2, 0, crearHabitacio0Planta2());
        castell.addHabitacio(2, 1, crearHabitacio1Planta2());
        castell.addHabitacio(2, 2, crearHabitacio2Planta2());                           
        
        heroina = new Heroina();
        Habitacio h = castell.getHabitacio(0, 0);
        int[] p = h.getPosicioCela(10, 10);
        heroina.setPosicioInicial(p[0], p[1]);
        
        joc = new Joc(castell, heroina);                            
        distribuirMenjar();
   
 // Distribuim Brayan i escut amb el seu métode a sota       
        
        posicionarBrayan();
        posicionarEscut();
        
        JuanaDeArco jda = new JuanaDeArco(joc);      
    }
    
    // Modifiquem les habitacions prenent com a plantilla les donades
        
    private Habitacio crearHabitacio0Planta0() {
        Habitacio h = Util.carregarHabitacio("h0_0.txt");
        
        Porta porta = h.getPorta(14, 24);
        porta.setNumPlantaDesti(0);
        porta.setNumHabitacioDesti(1);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(1, 1));

        porta = h.getPorta(0, 10);
        porta.setNumPlantaDesti(0);
        porta.setNumHabitacioDesti(2);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(14, 10));        

        porta = h.getPorta(10, 0);
        porta.setNumPlantaDesti(1);
        porta.setNumHabitacioDesti(0);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(5, 23));

        porta = h.getPorta(16, 13);
        porta.setNumPlantaDesti(2);
        porta.setNumHabitacioDesti(0);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(1, 11));

        return h;
    }
    
    private Habitacio crearHabitacio1Planta0() {
        Habitacio h = Util.carregarHabitacio("h0_1.txt");
        Porta porta = h.getPorta(1, 0);
        porta.setNumPlantaDesti(0);
        porta.setNumHabitacioDesti(0);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(14, 22));
       
        return h;
    }

    private Habitacio crearHabitacio2Planta0() {
        Habitacio h = Util.carregarHabitacio("h0_2.txt");
        Porta porta = h.getPorta(16,10);
        porta.setNumPlantaDesti(0);
        porta.setNumHabitacioDesti(0);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(1, 10));

        return h;
    }

    private Habitacio crearHabitacio0Planta1() {
        Habitacio h = Util.carregarHabitacio("h1_0.txt");
        Porta porta = h.getPorta(5, 24);
        porta.setNumPlantaDesti(0);
        porta.setNumHabitacioDesti(0);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(10, 1));

        porta = h.getPorta(16, 11);     
        porta.setNumPlantaDesti(1);
        porta.setNumHabitacioDesti(1);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(1, 19));

        porta = h.getPorta(9, 0);
        porta.setNumPlantaDesti(1);
        porta.setNumHabitacioDesti(2);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(7, 23));

        return h;
    }

    private Habitacio crearHabitacio1Planta1() {
        Habitacio h = Util.carregarHabitacio("h1_1.txt");
        Porta porta = h.getPorta(0, 19);
        porta.setNumPlantaDesti(1);
        porta.setNumHabitacioDesti(0);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(14, 11));

        return h;
    }
    
    private Habitacio crearHabitacio2Planta1() {
        Habitacio h = Util.carregarHabitacio("h1_2.txt");
        Porta porta = h.getPorta(7,24);
        porta.setNumPlantaDesti(1);
        porta.setNumHabitacioDesti(0);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(9, 1));

        return h;
    }
    private Habitacio crearHabitacio0Planta2() {
        Habitacio h = Util.carregarHabitacio("h2_0.txt");
        Porta porta = h.getPorta(0, 11);
        porta.setNumPlantaDesti(0);
        porta.setNumHabitacioDesti(0);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(14, 13));

        porta = h.getPorta(16, 10);
        porta.setNumPlantaDesti(2);
        porta.setNumHabitacioDesti(1);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(1, 12));

        porta = h.getPorta(16, 18);
        porta.setNumPlantaDesti(2);
        porta.setNumHabitacioDesti(2);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(1, 4));

        return h;
    }
    private Habitacio crearHabitacio1Planta2() {
        Habitacio h = Util.carregarHabitacio("h2_1.txt");
        Porta porta = h.getPorta(0, 12);
        porta.setNumPlantaDesti(2);
        porta.setNumHabitacioDesti(0);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(14, 10));

        return h;
    }
    private Habitacio crearHabitacio2Planta2() {
        Habitacio h = Util.carregarHabitacio("h2_2.txt");
        Porta porta = h.getPorta(0, 4);
        porta.setNumPlantaDesti(2);
        porta.setNumHabitacioDesti(0);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(13, 18));

        return h;
    }

    private void distribuirMenjar() {
        String[] menjars = {  "Pizza", "Pollastre", "Síndria" } ;
        // { calories,x,y,width,height } de cada imatge
        int[][] dades = {
            { 25, 540, 14, 30, 22 },
            { 50, 439, 14, 27, 23 },
            { 50, 97, 100, 30, 20 }
        };
        
        for (int i = 0; i < castell.getNumPlantes(); i++) {
            
            for (int j = 0; j < castell.getNumHabitacions(i); j++) {
                Habitacio h = castell.getHabitacio(i, j);
                int numMenjars = (int)(Math.random() * (MAX_MENJAR_PER_HABITACIO + 1));
                
                for (int k = 0; k < numMenjars; k++) {
                    int[] cela = obtenirCelaLliure(h);
                    int imenjar = (int)(Math.random() * menjars.length);
                    Menjar m = new Menjar(menjars[imenjar], 
                            dades[imenjar][0], dades[imenjar][1], dades[imenjar][2], 
                            dades[imenjar][3], dades[imenjar][4]);
                    
                    int[] posicio = h.getPosicioCela(cela[0], cela[1]);
                    m.setPosicioInicial(posicio[0], posicio[1]);
                    h.addActor(m);                     
                }
            }
            
        }
    }
    
// Posicionem Brayan de forma aleatória    
    
    private void posicionarBrayan() {
      int planta = (int)(Math.random() * castell.getNumPlantes());
      int numHabitacio = (int)(Math.random() * castell.getNumHabitacions(planta));
      Habitacio h = castell.getHabitacio(planta, numHabitacio);
      int [] cela = obtenirCelaLliure(h);
      int [] posicio = h.getPosicioCela(cela[0],cela[1]);
      Brayan brayan = new Brayan("General Brayan", 0, 0, 25, 50);
      brayan.setPosicioInicial(posicio[0],posicio[1]);
      h.addActor(brayan);	
      }        

// Posicionem l'Escut a la última sala de la última planta    
    
    private void posicionarEscut() {
      int planta = 2;
      int numHabitacio = 2;
      Habitacio h = castell.getHabitacio(planta, numHabitacio);
      int [] cela = obtenirCelaLliure(h);
      int [] posicio = h.getPosicioCela(cela[0],cela[1]);
      Escut escut = new Escut("Escut", 4, 85, 32, 36);
      escut.setPosicioInicial(posicio[0],posicio[1]);
      h.addActor(escut);	
      }   
    
    private int[] obtenirCelaLliure(Habitacio h) {
        int fila = 0;
        int col = 0;
        int cela[] = null;
        boolean trobada = false;
        boolean terra = false;
        
        while (!trobada) {            
            terra = false;
            while (!terra) {
                fila = (int)(Math.random() * Constants.NUM_CELES_VERTICALS);
                col = (int)(Math.random() * Constants.NUM_CELES_HORIZONTALS);
                terra = h.getValor(fila, col) == Constants.SIMBOL_TERRA;
            }
            
            // comprovar que cap actor està dins la cela
            Actor[] actors = h.getActorsAsArray();
            int i = 0;
            boolean lliure = true;
            while (i < actors.length && lliure) {
                cela = h.getCela(actors[i].getPosicioInicial()[0], 
                        actors[i].getPosicioInicial()[1]);
                lliure = fila != cela[0] || col != cela[1];            
                i++;
            }         
            trobada = lliure;
        }
        return new int[] { fila, col };
    }
    

    /**
     * Principal.
     * 
     * @param args
     */
    public static void main(String[] args) {
        new Practica();
    }
    
}
