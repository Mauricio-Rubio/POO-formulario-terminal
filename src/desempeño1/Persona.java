package desempeño1;

public class Persona {
    String nombre;
    int numero;
    String correo;
    String sexo;
    String edad;
    Registro folio;


    
    @Override
    public String toString(){
        return ""+nombre+" , telefono: "+numero+" , correo; "+correo+" , sexo: "+sexo+" , folio: "+folio; 
    }
    
    public  Persona (String nombre, String sexo, String edad, int celular, String correo){
        this.nombre = nombre;
        this.sexo = sexo;
        this.edad = edad;
        numero = celular;
        this.correo = correo;
    }
}
