package desempeño1;
import Funciones.*;

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
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Sistema {

    protected Persona usuarioActivo;

    public void iniciar() {
        int eleccion = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido al programa de vacunación que NO es político");
        System.out.println("-------------------------------------------------------------------------------");
        do{
        System.out.println("1 para registrarse, 2 para ingresar, 3 salir");
        eleccion = sc.nextInt();
        if (eleccion == 1) {
            InterfazUsuario us = new InterfazUsuario();
            us.nuevaPersona();
            us.registrarUsuario(us);
            Funciones.archivosTxt.BaseDatos(us.usuario);
//            usuario.cuestionarioSalud(usuario);
        } else if (eleccion == 2) {
            System.out.println("Ingresa tu folio: ");
            sc.nextLine();
            String folioLogin = "Folio: " + sc.nextLine();
            Persona personaLogin;
            if (Funciones.archivosTxt.buscarFolio(folioLogin) != null) {
                usuarioActivo = Funciones.archivosTxt.buscarFolio(folioLogin);

                //personaLogin.folio.folio=folioLogin;
                usuarioActivo.sexo = String.valueOf(folioLogin.charAt(7));
                System.out.println("Registro Encontrado");
                System.out.println("-------------------------------------------------------------------------------");
                System.out.println("1 para consultar sus datos, 2 para actualizar datos");
                System.out.println("-------------------------------------------------------------------------------");
                eleccion = sc.nextInt();
                if(eleccion == 1){
                    System.out.println(usuarioActivo);
                }else if (eleccion == 2){
                    System.out.println("-------------------------------------------------------------------------------");
                    System.out.println("Ingrese su correo electronico");
                    sc.nextLine();
                    usuarioActivo.correo=sc.nextLine();
                    System.out.println("Ingrese su numero de contacto");
                    usuarioActivo.numero=sc.nextLine();
                    actualizarUsuario(usuarioActivo);
                }
                
                
            }
        }else if(eleccion == 3){
            System.out.println("-------------------------------------------------------------------------------");
            break;
        } 
        
        else {
            System.out.println("Ingrese una opción válida por favor");
        }
        }while(eleccion == 1 || eleccion == 2);
    }





    public Persona actualizarUsuario(Persona user) {
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
}
