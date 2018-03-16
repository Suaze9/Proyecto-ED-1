/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hoffman;

import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public class Letra_Binaria {
    
    public char caracter;
    public ArrayList<Integer> numeros = new ArrayList();

    public Letra_Binaria(char caracter) {
        this.caracter = caracter;
    }

    public char getCaracter() {
        return caracter;
    }

    public void setCaracter(char caracter) {
        this.caracter = caracter;
    }

    public ArrayList<Integer> getNumeros() {
        return numeros;
    }

    public void setNumeros(ArrayList<Integer> numeros) {
        this.numeros = numeros;
    }
    
    
}
