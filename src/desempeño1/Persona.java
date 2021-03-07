package desempeño1;

public class Persona {
    private String nombre;
    private String numero;
    private String correo;
    private String sexo;
    private String edad;
    public Registro folio;
    public Salud salud;


    
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public Registro getFolio() {
        return folio;
    }

    public void setFolio(Registro folio) {
        this.folio = folio;
    }

    public Salud getSalud() {
        return salud;
    }

    public void setSalud(Salud salud) {
        this.salud = salud;
    }
    

}
