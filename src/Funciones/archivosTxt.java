package Funciones;

import desempeño1.*;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class archivosTxt {

    public static void BaseDatos(Persona usuario) {
        File archivo; //manipula el archivo
        FileWriter escribir; // escribir en el archivo
        PrintWriter linea; // 
        archivo = new File("registroVacunación.txt");
        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
                escribir = new FileWriter(archivo, true);
                linea = new PrintWriter(escribir);
                linea.println("Folio: " + usuario.folio.getFolio());
                linea.println("Nombre: " + usuario.getNombre());
                linea.println("Correo electrónico: " + usuario.getCorreo());
                linea.println("Contacto: " + usuario.getNumero());
                linea.println("fecha: " + usuario.folio.getFecha());
                linea.println("Lugar: " + usuario.folio.getLugar());
                linea.close();
                escribir.close();
            } catch (Exception e) {
            }
        } else {
            try {
                escribir = new FileWriter(archivo, true);
                linea = new PrintWriter(escribir);
                //escribir en el archivo
                linea.println("Folio: " + usuario.folio.getFolio());
                linea.println("Nombre: " + usuario.getNombre());
                linea.println("Correo electrónico: " + usuario.getCorreo());
                linea.println("Contacto: " + usuario.getNumero());
                linea.println("fecha: " + usuario.folio.getFecha());
                linea.println("Lugar: " + usuario.folio.getLugar());
                linea.close();
                escribir.close();
            } catch (Exception e) {
            }
        }
    }
}
