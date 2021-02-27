package desempeño1;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Sistema {

    Persona Usuario;

    public void iniciar() {
        int eleccion = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido al programa de vacunación que NO es político");
        System.out.println("1 para registrarse, 2 para ingresar");
        eleccion = sc.nextInt();
        if (eleccion == 1) {
            InterfazUsuario usuario = new InterfazUsuario();
            usuario.nuevaPersona();
            usuario.registrarUsuario(usuario);
            BaseDatos(usuario);
        } else if (eleccion == 2) {
            System.out.println("En mantenimiento");
        } else {
            System.out.println("Ingrese una opción válida por favor");
        }
    }

    public void BaseDatos(InterfazUsuario usuario) {
        File archivo; //manipula el archivo
        FileWriter escribir; // escribir en el archivo
        PrintWriter linea; // 
        archivo = new File("registroVacunación.txt");
        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
                escribir = new FileWriter(archivo, true);
                linea = new PrintWriter(escribir);
                //escribir en el archivo
                linea.println("Folio: " + usuario.usuario.folio.getFolio());
                linea.println("Nombre: " + usuario.usuario.getNombre());
                linea.println("Correo electrónico: " + usuario.usuario.getCorreo());
                linea.println("Contacto: " + usuario.usuario.getNumero());
                /*linea.println(usuario.getNombre());
                linea.println(usuario.getContraseña());//Esta cifrada al acceder al método getContraseña
                linea.println(usuario.getCuenta().getId());
                linea.println(usuario.getCuenta().consultar());*/
                //System.out.println(usuario.getId());
                //System.out.println(contraseña2);
                //linea.println();
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
                linea.println("Nombre: " + usuario.usuario.getNombre());
                linea.println("Correo electrónico: " + usuario.usuario.getCorreo());
                linea.println("Contacto: " + usuario.usuario.getNumero());
                /*linea.println(usuario.getNombre());
                linea.println(usuario.getContraseña());
                linea.println(usuario.getCuenta().getId());
                linea.println(usuario.getCuenta().consultar());*/
                //linea.println(email);
                linea.close();
                escribir.close();
            } catch (Exception e) {
            }
        }
    }//acabo
}
