package Funciones;

import desempeño1.*;
import java.io.BufferedReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        public static Persona buscarFolio(String folio) {
        File archivo;  //manipular un archivo
        FileReader leer; //lector
        String cadena, folioUsuario = "", nombreUsuario = "", correoUsuario = "", contactoUsuario = "", fechaRegistro = "", lugarUsuario = "" ;
        BufferedReader almacenamiento;
        archivo = new File("registroVacunación.txt");
        try {
            leer = new FileReader(archivo);
            almacenamiento = new BufferedReader(leer);
            cadena = "";
            //usuarioActivo = null;
            do {
                try {
                    cadena = almacenamiento.readLine();
                    folioUsuario = cadena;
                    cadena = almacenamiento.readLine();
                    nombreUsuario = cadena;
                    cadena = almacenamiento.readLine();
                    correoUsuario = cadena;
                    cadena = almacenamiento.readLine();
                    contactoUsuario = cadena;
                    cadena = almacenamiento.readLine();
                    fechaRegistro = cadena;
                    cadena = almacenamiento.readLine();
                    lugarUsuario = cadena;
                    if (cadena != null && folio.equals(folioUsuario)) {
                        Persona userBusqueda = new Persona(nombreUsuario, correoUsuario, contactoUsuario);
                        userBusqueda.folio = new Registro(folioUsuario, fechaRegistro, lugarUsuario); 
                        //usuarioActivo = userBusqueda;
                        leer.close();
                        return userBusqueda;
                    }
                } catch (IOException ex) {
                    System.out.println("error encontrar" + ex);

                    Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
                }
            } while (cadena != null || (folio.equals(folioUsuario)));
            try {
                almacenamiento.close();
                leer.close();
            } catch (IOException ex) {
                Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Usuario no existe");
        return null;
    }
}
