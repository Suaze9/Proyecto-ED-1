/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hoffman;

import java.util.ArrayList;
import proyecto.TDA.BinaryTree;

/**
 *
 * @author usuario
 */
public class Codigo_Hoffman {

    public String frase;

    public Codigo_Hoffman(String frase) {
        this.frase = frase;
    }

    public ArrayList<Letra> Letras() {
        ArrayList<Letra> cantidades = new ArrayList();
        for (int i = 0; i < frase.length(); i++) {
            int cont = 0;
            char caracter = frase.charAt(i);
            for (int j = 0; j < cantidades.size(); j++) {
                if (caracter == cantidades.get(j).getCaracter()) {
                    cont++;
                }
            }
            if (cont == 0) {
                int contador = 0;
                for (int j = 0; j < frase.length(); j++) {
                    if (caracter == frase.charAt(j)) {
                        contador++;
                    }
                }
                Letra letra = new Letra(caracter, contador);
                cantidades.add(letra);
            }
        }
        return cantidades;
    }

    
    public void Comprimir(ArrayList<Letra> letras) {
        ArrayList<BinaryTree> arboles = new ArrayList();
        for (int i = 0; i < letras.size(); i++) {
            BinaryTree arbol = new BinaryTree();
            arbol.setData(letras.get(i));
            arboles.add(arbol);
        }
        boolean salir = false;
        do {
            
        } while (!salir);
        
    }
    
}
