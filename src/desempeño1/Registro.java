package desempeño1;

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
}
