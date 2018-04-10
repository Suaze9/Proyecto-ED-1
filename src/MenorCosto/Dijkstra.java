/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MenorCosto;

import Bicoloreable.*;
import java.util.ArrayList;
import org.jgrapht.graph.*;
import proyecto.TDA.ArrayStack;

/**
 *
 * @author usuario
 */
public class Dijkstra {

    public Dijkstra() {
    }

    public ArrayList<Nodo_Grafo> evaluar(DefaultDirectedWeightedGraph<Vertice, DefaultWeightedEdge> grafo, int origen) {
        try {
            double[][] ady = matrizAdyacencia(grafo);
            ArrayList<Nodo_Grafo> arbol = evaluacionDijkstra(grafo, ady, origen);
            return arbol;
        } catch (Exception e) {
            return null;
        }
    }

    private double[][] matrizAdyacencia(DefaultDirectedWeightedGraph<Vertice, DefaultWeightedEdge> grafo) {
        ArrayList<Vertice> vertices = new ArrayList(grafo.vertexSet());

        int size = vertices.size();
        double[][] matrizAdyacencia = new double[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrizAdyacencia[i][j] = 999999;
            }
        }

        for (int i = 0; i < size; i++) {
            for (DefaultWeightedEdge Edge : grafo.outgoingEdgesOf(vertices.get(i))) {
                Vertice target = grafo.getEdgeTarget(Edge);

                if (target == vertices.get(i)) {
                    target = grafo.getEdgeSource(Edge);
                }
                int j = vertices.indexOf(target);
                matrizAdyacencia[i][j] = grafo.getEdgeWeight(Edge);
                matrizAdyacencia[j][i] = grafo.getEdgeWeight(Edge);
            }
        }
        return matrizAdyacencia;
    }

    private ArrayList<Nodo_Grafo> evaluacionDijkstra(DefaultDirectedWeightedGraph<Vertice, DefaultWeightedEdge> grafo, double[][] adyacencia, int origen) {
        try {
            int cn = adyacencia.length;
            double[][] arbol = new double[cn][cn];
            double[] pertenece = new double[cn];
            for (int i = 0; i < cn; i++) {
                for (int j = 0; j < cn; j++) {
                    arbol[i][j] = 0;
                }
                pertenece[i] = i;
            }
            int raiz = origen;
            int num_nodo = raiz;
            ArrayList<Nodo_Grafo> nodos = new ArrayList();
            for (int i = 0; i < cn; i++) {
                nodos.add(new Nodo_Grafo(i, -1));
            }
            nodos.get(raiz).setCosto(0);
            boolean salir = false;
            double menor;
            ArrayList<Integer> visitados = new ArrayList();
            ArrayStack pila = new ArrayStack();
            do {
                for (int i = 0; i < cn; i++) {
                    boolean seguir = true;
                    for (int j = 0; j < visitados.size(); j++) {
                        if (visitados.get(j) == i) {
                            seguir = false;
                        }
                    }
                    if (seguir) {
                        if (pertenece[num_nodo] != pertenece[i] && adyacencia[num_nodo][i] != 0 && adyacencia[num_nodo][i] < 99999) {
                            double suma_costo = 0;
                            if (!pila.isEmpty()) {
                                suma_costo = (Double) pila.top();
                            }
                            if (adyacencia[num_nodo][i] + suma_costo < nodos.get(i).getCosto() || nodos.get(i).getCosto() == -1) {
                                nodos.get(i).setCosto(adyacencia[num_nodo][i] + suma_costo);
                            }
                        }
                    }
                }
                visitados.add(num_nodo);
                menor = 999999999;
                if (visitados.size() != cn) {
                    for (int i = 0; i < nodos.size(); i++) {
                        boolean seguir2 = true;
                        for (int j = 0; j < visitados.size(); j++) {
                            if (nodos.get(i).getNumero() == visitados.get(j)) {
                                seguir2 = false;
                            }
                        }
                        if (seguir2) {
                            if (nodos.get(i).getCosto() <= menor && nodos.get(i).getCosto() >= 0) {
                                menor = nodos.get(i).getCosto();
                                num_nodo = nodos.get(i).getNumero();
                            }
                        }
                    }
                } else {
                    salir = true;
                }
                pila.push(nodos.get(num_nodo).getCosto());
            } while (!salir);
            return nodos;
        } catch (Exception e) {
            return null;
        }
    }
}
