package desempeño1;

import java.util.Scanner;

public class InterfazUsuario {

    Persona usuario;
    Scanner sc = new Scanner(System.in);

    public Persona nuevaPersona() {
        String nombre;
        int celular;
        String correo;
        String sexo;
        String edad;

        System.out.println("Ingrese su nombre completo");
        nombre = sc.nextLine();
        System.out.println("Ingrese su edad");
        edad = sc.nextLine();
        System.out.println("Ingrese M para masculino, F para femenino");
        sexo = sc.nextLine();
        System.out.println("Ingrese su teléfono celular");
        celular = sc.nextInt();
        System.out.println("Ingrese su correo");
        sc.nextLine();
        correo = sc.nextLine();
        usuario = new Persona(nombre, sexo, edad, celular, correo);
        System.out.println(usuario);
        return usuario;
    }

        public void registrarUsuario(InterfazUsuario usuario){
            String fecha;
            String lugar;
            System.out.println("Ingrese la fecha en formato dd-mm-aaaa");
            fecha = sc .nextLine();
            System.out.println("Ingrese el estado donde reside");
            lugar = sc.nextLine();
            if(usuario.usuario.sexo.equals("M")){
                System.out.println("Entamos a M");
                usuario.usuario.folio = new Registro(fecha, lugar);
                usuario.usuario.folio.generarFolioM();
                System.out.println(usuario.usuario.folio);
            }else{
                System.out.println("el usuario es mujer");
            }
        }
}
