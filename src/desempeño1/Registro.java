package desempeño1;

import java.util.Scanner;

public class Registro {

    String folio;
    String fecha;
    String lugar;
    Scanner sc = new Scanner(System.in);

    @Override
    public String toString() {
        return "Folio generado: " + folio + " , el: " + fecha + " , para alcaldía: " + lugar;
    }

    public void registrar(Persona usuario) {

    }

    public Registro(String fecha, String lugar) {
        this.fecha = fecha;
        this.lugar = lugar;
    }

    public void generarFolioM() {
        int n = 0;
        n = (int) (Math.random() * (99999 - 00001) + 00001);
        String aleatorio = String.valueOf(n);
        //aleatorio = rnd.nextInt()*100 + 0;
        //String nAleatorio = String.valueOf(aleatorio);
        folio = "H" + aleatorio;
        System.out.println(folio);
    }

    public void generarFolioF() {
        int n = 0;
        n = (int) (Math.random() * (99999 - 00001) + 00001);
        String aleatorio = String.valueOf(n);
        //aleatorio = rnd.nextInt()*100 + 0;
        //String nAleatorio = String.valueOf(aleatorio);
        folio = "M" + aleatorio;
        System.out.println(folio);
    }
    
    public String getFolio(){
        return folio;
    }
    
    public String getFecha(){
        return fecha;
    }
    
    public String getLugar(){
        return lugar;
    }
}
