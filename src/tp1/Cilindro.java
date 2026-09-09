package tp1;

// Archivo: Cilindro.java
public class Cilindro {
    // Atributos privados (encapsulamiento)
    private double radio;
    private double altura;

    // Constructor predeterminado
    public Cilindro() {
        this.radio = 1.0;
        this.altura = 1.0;
    }

    // Constructor con argumentos
    public Cilindro(double radio, double altura) {
        setRadio(radio);
        setAltura(altura);
    }

    // Getters y Setters con validación
    public double getRadio() {
        return this.radio;
    }

    public void setRadio(double radio) {
        if (radio > 0) {
            this.radio = radio;
        }
    }

    public double getAltura() {
        return this.altura;
    }

    public void setAltura(double altura) {
        if (altura > 0) {
            this.altura = altura;
        }
    }

    // Métodos de cálculo
    public double calcularVolumen() {
        return Math.PI * Math.pow(this.radio, 2) * this.altura;
    }

    public double calcularArea() {
        return 2 * Math.PI * this.radio * (this.radio + this.altura);
    }
}