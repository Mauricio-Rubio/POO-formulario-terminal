package desempeño1;

public class Persona {
    protected String nombre;
    protected String numero;
    protected String correo;
    protected String sexo;
    protected String edad;
    public Registro folio;
    protected Salud salud;


    
    @Override
    public String toString(){
        return ""+nombre+" , telefono: "+numero+" , "+correo+" , sexo: "+sexo+" ,  "+folio; 
    }
    
    public  Persona (String nombre, String sexo, String edad, String celular, String correo){
        this.nombre = nombre;
        this.sexo = sexo;
        this.edad = edad;
        numero = celular;
        this.correo = correo;
    }
    
    
    public Persona(String nombre, String correo, String tel){
        this.nombre = nombre;
        this.correo = correo;
        this.numero = tel;
      /*  this.folio.fecha=datos.fecha;
        this.folio.lugar=datos.lugar;
        this.folio.folio=datos.folio;*/
        
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public String getEdad(){
        return edad;
    }
    
    public String getNumero(){
        return String.valueOf(numero);
    }
    
    public String getCorreo(){
        return correo;
    }
    
    public String getSexo(){
        return sexo;
    }
}
