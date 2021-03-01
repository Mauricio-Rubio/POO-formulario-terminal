package desempeño1;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Salud {

    double peso;
    double altura;
    String edad;
    String seguro;
    String telefono;
    double IMC;
    String status;

    public Salud(double peso, double altura, String edad, String seguro, String telefono, double imc, String status) {
        this.peso = peso;
        this.altura = altura;
        this.edad = edad;
        this.seguro = seguro;
        this.telefono = telefono;
        this.IMC = imc;
        this.status = status;
    }

    public void BaseDatos(InterfazUsuario usuario) {
        double pesoU = usuario.usuario.salud.peso;
        double alturaU = usuario.usuario.salud.altura;
        double imcU = usuario.calIMC(alturaU, pesoU);
        File archivo; //manipula el archivo
        FileWriter escribir; // escribir en el archivo
        PrintWriter linea; // 
        archivo = new File("estadoSalud.txt");
        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
                escribir = new FileWriter(archivo, true);
                linea = new PrintWriter(escribir);
                //escribir en el archivo
                linea.println("Folio: " + usuario.usuario.folio.getFolio());
                linea.println("El paciente de folio: " + usuario.usuario.folio.getFolio() + ", " + usuario.usuario.getNombre() +"  es "+usuario.usuario.salud.edadStatus(usuario));
                linea.println("Se encuentra pesando: " + pesoU + ", con altura de " + alturaU);
                linea.println("Notas: el paciente tiene un IMC de: " + imcU + " por lo se encuentra en " + usuario.IMC(imcU));
                linea.println("El paciente cuenta con una afiliación a: " + usuario.usuario.salud.seguro);
                linea.close();
                escribir.close();
            } catch (Exception e) {
            }
        } else {
            try {
                escribir = new FileWriter(archivo, true);
                linea = new PrintWriter(escribir);
                //escribir en el archivo
                 linea.println("Folio: " + usuario.usuario.folio.getFolio());
                linea.println("El paciente de folio: " + usuario.usuario.folio.getFolio() + ", " + usuario.usuario.getNombre() +" es "+usuario.usuario.salud.edadStatus(usuario));
                linea.println("Se encuentra pesando: " + pesoU + ", con altura de " + alturaU);
                linea.println("Notas: el paciente tiene un IMC de: " + imcU + " por lo se encuentra en " + usuario.IMC(imcU));
                linea.println("El paciente cuenta con una afiliación a: " + usuario.usuario.salud.seguro);
                linea.close();
                escribir.close();
            } catch (Exception e) {
            }
        }
    }
    
    public String edadStatus(InterfazUsuario persona){
        int i = Integer.parseInt(persona.usuario.getEdad());
        if(18 >= 1){
            return "mayor de edad";
        }else{
            return "menor de edad";
        }
    }
}
