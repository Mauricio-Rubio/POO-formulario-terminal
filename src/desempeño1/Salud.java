package desempeño1;

public class Salud {

    private double peso;
    private double altura;
    private String edad;
    private String seguro;
    private String telefono;
    private double IMC;
    private String status;

    public Salud(double peso, double altura, String edad, String seguro, String telefono, double imc, String status) {
        this.peso = peso;
        this.altura = altura;
        this.edad = edad;
        this.seguro = seguro;
        this.telefono = telefono;
        this.IMC = imc;
        this.status = status;
    }

    

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getSeguro() {
        return seguro;
    }

    public void setSeguro(String seguro) {
        this.seguro = seguro;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public double getIMC() {
        return IMC;
    }

    public void setIMC(double IMC) {
        this.IMC = IMC;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String edadStatus(Persona persona) {
        int i = Integer.parseInt(persona.getEdad());
        if (i >= 18) {
            return "mayor de edad";
        } else {
            return "menor de edad";
        }
    }
}
