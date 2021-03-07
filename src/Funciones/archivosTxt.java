package Funciones;

import desempeño1.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
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
        String cadena, folioUsuario = "", nombreUsuario = "", correoUsuario = "", contactoUsuario = "", fechaRegistro = "", lugarUsuario = "";
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

    public static Persona actualizarUsuario(Persona user) {
        File archivoTemporal;
        archivoTemporal = new File("temp.txt");
        File archivoLectura;
        archivoLectura = new File("registroVacunación.txt");
        try {
            BufferedWriter escribir = new BufferedWriter(new FileWriter(archivoTemporal));
            BufferedReader lectura = new BufferedReader(new FileReader(archivoLectura));
            String cadena;
            while ((cadena = lectura.readLine()) != null) { //comparamos cadena, que alberga lectura de linea, con null
                String borrarEspacios = cadena.trim();
                if (borrarEspacios.equals(user.folio.getFolio())) {
                    escribir.write("" + user.folio.getFolio() + System.getProperty("line.separator"));
                    escribir.write("" + user.getNombre() + System.getProperty("line.separator"));
                    escribir.write("Correo: " + user.getCorreo() + System.getProperty("line.separator"));
                    escribir.write("Contacto: " + user.getNumero() + System.getProperty("line.separator"));
                    escribir.write("" + user.folio.getFecha() + System.getProperty("line.separator"));
                    for (int i = 0; i < 4; i++) {
                        cadena = lectura.readLine();
                    }
                    continue; //sale de la iteracion. No ejecuta nada continuo
                }
                escribir.write(cadena + System.getProperty("line.separator"));
            }

            lectura.close();
            escribir.close();

            if (archivoLectura.exists()) {
                //Boolean resultados = archivoTemporal.renameTo(new File());

                Files.move(Paths.get(archivoTemporal.getAbsolutePath()), Paths.get(archivoLectura.getAbsolutePath()), StandardCopyOption.REPLACE_EXISTING);
                //Files.move(archivoTemporal.toPath(), archivoLectura.toPath(), StandardCopyOption.REPLACE_EXISTING);
            } else {
                System.out.println("Error: No archivo lectura");
            }

        } catch (IOException x) {
            System.out.println("Error: " + x);
        }

        return null;
    }
    
    public static void BaseDatosSalud(Persona usuario, InterfazUsuario us) {
        double pesoU = usuario.salud.getPeso();
        double alturaU = usuario.salud.getAltura();
        double imcU = us.calIMC(alturaU, pesoU);
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
                linea.println("Folio: " + usuario.folio.getFolio());
                linea.println("El paciente de folio: " + usuario.folio.getFolio() + ", " + usuario.getNombre() + "  es " + usuario.salud.edadStatus(usuario));
                linea.println("Se encuentra pesando: " + pesoU + ", con altura de " + alturaU);
                linea.println("Notas: el paciente tiene un IMC de: " + imcU + " por lo se encuentra en " + us.IMC(imcU));
                linea.println("El paciente cuenta con una afiliación a: " + usuario.salud.getSeguro());
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
                linea.println("El paciente de folio: " + usuario.folio.getFolio() + ", " + usuario.getNombre() + "  es " + usuario.salud.edadStatus(usuario));
                linea.println("Se encuentra pesando: " + pesoU + ", con altura de " + alturaU);
                linea.println("Notas: el paciente tiene un IMC de: " + imcU + " por lo se encuentra en " + us.IMC(imcU));
                linea.println("El paciente cuenta con una afiliación a: " + usuario.salud.getSeguro());
                linea.close();
                escribir.close();
            } catch (Exception e) {
            }
        }
    }
}
