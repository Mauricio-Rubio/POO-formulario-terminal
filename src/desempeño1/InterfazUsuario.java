package desempeño1;

import java.util.Scanner;

public class InterfazUsuario {

    Persona usuario;
    Scanner sc = new Scanner(System.in);

    public void nuevaPersona() {
        String nombre;
        String sexo;
        String edad;
        System.out.println("Ingrese su nombre completo");
        nombre = sc.nextLine();
        System.out.println("Ingrese su edad");
        edad = sc.nextLine();
        System.out.println("Ingrese M para masculino, F para femenino");
        sexo = sc.nextLine();
        usuario = new Persona(nombre, sexo, edad);
        System.out.println(usuario);
    }
}
