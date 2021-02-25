package desempeño1;

import java.util.Random;
import java.util.Scanner;

public class Registro {
    String folio;
    String fecha;
    String lugar;
    Scanner sc = new Scanner(System.in);
    @Override
    public String toString(){
        return "Folio generado: "+folio+" , el: "+fecha+" , para alcaldía: "+lugar;
    }
    
    public void registrar(Persona usuario){
        
        
    }
    
    public Registro(String fecha, String lugar){
        this.fecha = fecha;
        this.lugar = lugar;
    }
    
    public void generarFolioM(){
        int Aleatorio = 0;
        Aleatorio = (int)(Math.random() * (99999-00001) + 00001);
        String aleatorio = String.valueOf(Aleatorio);
        folio = aleatorio;
        //aleatorio = rnd.nextInt()*100 + 0;
        //String nAleatorio = String.valueOf(aleatorio);
        //folio = "M"+nAleatorio;
        System.out.println(folio);
        }
    public void generarFolioF(){
        double aleatorio;
        aleatorio = Math.random() * 99999 ;
        String nAleatorio = String.valueOf(aleatorio);
        folio = "F"+nAleatorio;
        }

}
