/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MenorCosto;

/**
 *
 * @author usuario
 */
public class Nodo_Grafo {
    
    public int numero;
    public double costo;

    public Nodo_Grafo() {
    }

    public Nodo_Grafo(int numero, double costo) {
        this.numero = numero;
        this.costo = costo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Nodo_Grafo{" + "numero=" + numero + ", costo=" + costo + '}';
    }
    
    
}
