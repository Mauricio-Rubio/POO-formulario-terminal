package desempeño1;
import java.util.Scanner;

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
            us.cuestionarioSalud(us);
            System.out.println("Tu folio es: "+us.usuario.folio.getFolio());
        } else if (eleccion == 2) {
            System.out.println("Ingresa tu folio: ");
            sc.nextLine();
            String folioLogin = "Folio: " + sc.nextLine();
            Persona personaLogin;
            if (Funciones.archivosTxt.buscarFolio(folioLogin) != null) {
                usuarioActivo = Funciones.archivosTxt.buscarFolio(folioLogin);
                //usuarioActivo.sexo = String.valueOf(folioLogin.charAt(7));
                usuarioActivo.setSexo(String.valueOf(folioLogin.charAt(7)));
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
                    usuarioActivo.setCorreo(sc.nextLine());
                    System.out.println("Ingrese su numero de contacto");
                    usuarioActivo.setNumero(sc.nextLine());
                    Funciones.archivosTxt.actualizarUsuario(usuarioActivo);
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
}
