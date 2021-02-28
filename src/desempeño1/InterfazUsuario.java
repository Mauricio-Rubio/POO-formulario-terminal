package desempeño1;

import java.util.Scanner;

public class InterfazUsuario {

    Persona usuario;
    Scanner sc = new Scanner(System.in);

    public Persona nuevaPersona() {
        String nombre;
        String celular;
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
        celular = sc.nextLine();
        System.out.println("Ingrese su correo");
        correo = sc.nextLine();
        usuario = new Persona(nombre, sexo, edad, celular, correo);
        System.out.println(usuario);
        return usuario;
    }

    public boolean registrarUsuario(InterfazUsuario usuario) {
        String fecha;
        String lugar;
        System.out.println("Ingrese la fecha en formato dd-mm-aaaa");
        fecha = sc.nextLine();
        String fechaRes = fecha.replace("-","");
        System.out.println("Ingrese el estado donde reside");
        lugar = sc.nextLine();
        if (usuario.usuario.sexo.equals("M")) {
            usuario.usuario.folio = new Registro(fechaRes, lugar);
            usuario.usuario.folio.generarFolioM();
            System.out.println(usuario.usuario.folio);
            System.out.println("Usuario hombre");
            return true;
        } else {
            usuario.usuario.folio = new Registro(fechaRes, lugar);
            usuario.usuario.folio.generarFolioF();
            System.out.println(usuario.usuario.folio);
            System.out.println("Usuario mujer");
            return true;
        }
    }

    public void cuestionarioSalud(InterfazUsuario paciente) {
        System.out.println("Cuestionario de estado de salud");
        System.out.println("Ingrese su peso actual en kilogramos en formato 00.00");
        String peso = sc.nextLine();
        String edad = paciente.usuario.edad;
        System.out.println("Seleccione la opción que más de adecue con su seguro médico");
        System.out.println("1.- ISSSTE, 2.- IMSS, 3.- ISEMYM, 4. Voluntario, 5 otro ");
        int eleccion = sc.nextInt();
        String seguro;
        switch (eleccion) {
            case 1:
                seguro = "ISSSTE";
                break;
            case 2:
                seguro = "IMSS";
                break;
            case 3:
                seguro = "ISEMYM";
                break;
            case 4:
                seguro = "Voluntario";
                break;
            case 5:
                seguro = "otro";
                break;

        }
        String telefono;
    }
}
