package modelo;

public class Persona {

    //(encapsulamiento)
    private String nombre;
    private int edad;
    private double peso;
    private double estatura;
    private double imc;
    
    // Getters y setters para acceder a los atributos privados
    public String getNombre() { 
        return nombre; 
    }
    public void setNombre(String nombre) { 
        this.nombre = nombre; 
    }

    public int getEdad() { return edad; }

    public void setEdad(int edad) { 
        this.edad = edad; 
    }

    public double getPeso() { 
        return peso; 
    }
    public void setPeso(double peso) {  
        this.peso = peso; 
    }

    public double getEstatura() {
         return estatura; 
        }
    public void setEstatura(double estatura) { 
        this.estatura = estatura; 
    }

    public double getImc() { 
        return imc; 
    }
    
    // Método que calcula el IMC con la fórmula peso / estatura²
    public void calcularIMC() {
        imc = peso / (estatura * estatura);
    }
    
    // Método que retorna la clasificación según el valor del IMC
    public String clasificacion() {
        if (imc < 18.5) return "Bajo peso";
        else if (imc < 25) return "Normal";
        else if (imc < 30) return "Sobrepeso";
        else return "Obesidad";
    }
}