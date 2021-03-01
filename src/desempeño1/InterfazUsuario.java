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
            System.out.println("Tu folio es: "+usuario.usuario.folio.getFolio());
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
        double peso = sc.nextDouble();
        System.out.println("Ingrese su altura actual en metros  formato 00.00");
        double altura = sc.nextDouble();
        String edad = paciente.usuario.edad;
        System.out.println("Seleccione la opción que más se adecue con su seguro médico");
        System.out.println("1.- ISSSTE, 2.- IMSS, 3.- ISEMYM, 4. Voluntario, 5 otro ");
        int eleccion = sc.nextInt();
        String seguro="";
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
        paciente.usuario.salud= new Salud(peso, altura, edad, seguro, paciente.usuario.getNumero(), calIMC(altura, peso), IMC(calIMC(altura, peso)));
        paciente.usuario.salud.BaseDatos(paciente);
    }
    
    public double calIMC(double  altura, double peso){
        double imc = peso / (altura * altura);
        double res = Math.round(imc * 100.00)/100.0;
        return res;
    }
    
       public String IMC(double imc){
        String res="";
        if(imc <= 18.5){
             res = "Bajo de peso";
        }
        else if(imc >= 18.5 && imc <24.99){
             res = "Peso normal";
        }
        else if(imc >= 25 && imc <29.99){
             res = "Sobrepeso";
        }
        else if(imc >= 30.0 && imc <34.99){
             res = "Obesidad grado I";
        }
        else if(imc >= 35.00 && imc <39.99){
             res = "Obesidad grado Il";
        }
        else if(imc > 40 ){
             res = "Obesidad grado IlI";
        }else{
            res = "No disponible";
        }
        return res;
    }
}
