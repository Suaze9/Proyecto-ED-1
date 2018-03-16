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

    public BinaryTree Comprimir(ArrayList<Letra> letras) {
        ArrayList<BinaryTree> arboles = new ArrayList();
        for (int i = 0; i < letras.size(); i++) {
            BinaryTree arbol = new BinaryTree();
            arbol.setData(letras.get(i));
            arboles.add(arbol);
        }
        boolean salir = false;
        do {
            BinaryTree arbol1 = new BinaryTree();
            BinaryTree arbol2 = new BinaryTree();
            BinaryTree arbol_temporal = new BinaryTree();
            int menor = 0;
            int contador = 0;
            while (contador != 2) {
                for (int i = 0; i < arboles.size(); i++) {
                    if (i == 0) {
                        for (int j = 0; j < arboles.size(); j++) {
                            if (((Letra) arboles.get(j).getData()).getCantidad() >= menor) {
                                menor = ((Letra) arboles.get(j).getData()).getCantidad();
                            }
                        }
                    }
                    if (contador == 1 && arboles.get(i) == arbol1) {
                    } else {
                        if (((Letra) arboles.get(i).getData()).getCantidad() <= menor) {
                            menor = ((Letra) arboles.get(i).getData()).getCantidad();
                            arbol_temporal = arboles.get(i);
                        }
                    }
                }
                if (contador == 0) {
                    arbol1 = arbol_temporal;
                    arbol1.setRaiz(false);
                } else {
                    if (contador == 1) {
                        arbol2 = arbol_temporal;
                        arbol2.setRaiz(false);
                    }
                }
                contador++;
            }
            Letra letra = new Letra('.', ((Letra) arbol1.getData()).getCantidad() + ((Letra) arbol2.getData()).getCantidad());
            BinaryTree arbol3 = arbol1.crear(arbol2, letra, true);
            arboles.add(arbol3);
            arboles.remove(arbol1);
            arboles.remove(arbol2);
            if (arboles.size() == 1) {
                salir = true;
            }
        } while (!salir);
        return arboles.get(0);
    }
}
