package desempeño1;

import java.util.Scanner;

public class Sistema {
    Persona Usuario;
    
    public void iniciar(){
        int eleccion = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido al programa de vacunación que NO es político");
        System.out.println("1 para registrarse, 2 para ingresar");
        eleccion  = sc.nextInt();
        if( eleccion == 1){
            InterfazUsuario usuario = new InterfazUsuario();
            usuario.nuevaPersona();
            usuario.registrarUsuario(usuario);
        }else if(eleccion ==2){
            System.out.println("En mantenimiento");
        }else{
            System.out.println("Ingrese una opción válida por favor");
        }
    }
}
