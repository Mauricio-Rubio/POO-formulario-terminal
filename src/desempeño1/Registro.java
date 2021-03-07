package desempeño1;

import java.util.Scanner;

public class Registro {

    private String folio;
    private String fecha;
    private String lugar;
    Scanner sc = new Scanner(System.in);

    @Override
    public String toString() {
        return " " + folio + " , " + fecha + " ,  " + lugar;
    }

    public void registrar(Persona usuario) {

    }

    public Registro(String folio, String fecha, String lugar) {
        this.folio = folio;
        this.fecha = fecha;
        this.lugar= lugar;
    }
    
    public Registro(String fecha, String lugar) {
        this.fecha = fecha;
        this.lugar = lugar;
    }

    public void generarFolioM() {
        int n = 0;
        n = (int) (Math.random() * (99999 - 00001) + 00001);
        String aleatorio = String.valueOf(n);
        folio = "M" + aleatorio;
    }

    public void generarFolioF() {
        int n = 0;
        n = (int) (Math.random() * (99999 - 00001) + 00001);
        String aleatorio = String.valueOf(n);
        folio = "F" + aleatorio;
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
