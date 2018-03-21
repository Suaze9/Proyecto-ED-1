/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hoffman;

/**
 *
 * @author usuario
 */
public class Letra {
    
    public char caracter;
    public int cantidad;
    public String tipo;

    public Letra(char caracter, int cantidad) {
        this.caracter = caracter;
        this.cantidad = cantidad;
    }

    public Letra(char caracter, int cantidad, String tipo) {
        this.caracter = caracter;
        this.cantidad = cantidad;
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public char getCaracter() {
        return caracter;
    }

    public void setCaracter(char caracter) {
        this.caracter = caracter;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
