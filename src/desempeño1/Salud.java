package desempeño1;

public class Salud {
    double peso;
    double altura;
    String  edad;
    String seguro;
    String telefono;
    double IMC;
    String status;
    
    public Salud(double peso,double altura,  String edad, String seguro, String telefono, double imc, String status){
        this.peso = peso;
        this.altura=altura;
        this.edad = edad;
        this.seguro = seguro;
        this.telefono = telefono;
        this.IMC=imc;
        this.status=status;
    }
}
