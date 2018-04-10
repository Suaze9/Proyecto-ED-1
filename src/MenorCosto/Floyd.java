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
public class Floyd {

    public Floyd() {
    }

    public double[][] evaluar(DefaultDirectedWeightedGraph<Vertice, DefaultWeightedEdge> grafo) {
        try {
            double[][] ady = matrizAdyacencia(grafo);
            double[][] arbol = evaluacionFloyd(grafo, ady);
            return arbol;
        } catch (Exception e) {
            return null;
        }
    }

    public int[][] evaluar1(DefaultDirectedWeightedGraph<Vertice, DefaultWeightedEdge> grafo) {
        try {
            double[][] ady = matrizAdyacencia(grafo);
            int[][] arbol = evaluacionFloyd1(grafo, ady);
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

                if (target != vertices.get(i)) {
                    int j = vertices.indexOf(target);
                    matrizAdyacencia[i][j] = grafo.getEdgeWeight(Edge);
                    matrizAdyacencia[j][i] = grafo.getEdgeWeight(Edge);
                }
                
            }
        }
        return matrizAdyacencia;
    }

    private double[][] evaluacionFloyd(DefaultDirectedWeightedGraph<Vertice, DefaultWeightedEdge> grafo, double[][] adyacencia) {
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
            double[][] distancias = new double[cn][cn];
            for (int i = 0; i < cn; i++) {
                for (int j = 0; j < cn; j++) {
                    if (i == j) {
                        distancias[i][j] = 0;
                    } else {
                        distancias[i][j] = -1;
                    }
                }
            }
            for (int i = 0; i < cn; i++) {
                for (int j = 0; j < cn; j++) {
                    for (DefaultWeightedEdge Edge : grafo.edgeSet()) {
                        if (grafo.vertexSet().toArray()[i] == grafo.getEdgeSource(Edge) && grafo.vertexSet().toArray()[j] == grafo.getEdgeTarget(Edge)) {
                            if (pertenece[i] != pertenece[j] && adyacencia[i][j] != 0 && adyacencia[i][j] < 99999) {
                                distancias[i][j] = adyacencia[i][j];
                            }
                            break;
                        }
                    }
                }
            }
            int[][] recorridos = new int[cn][cn];
            for (int i = 0; i < cn; i++) {
                for (int j = 0; j < cn; j++) {
                    if (i == j) {
                        recorridos[i][j] = -1;
                    } else {
                        recorridos[i][j] = j;
                    }
                }
            }
            for (int i = 0; i < cn; i++) {
                for (int j = 0; j < cn; j++) {
                    System.out.print(distancias[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
            for (int i = 0; i < cn; i++) {
                for (int j = 0; j < cn; j++) {
                    System.out.print(recorridos[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
            for (int i = 0; i < cn; i++) {
                for (int j = 0; j < cn; j++) {
                    for (int k = 0; k < cn; k++) {
                        boolean seguir = true;
                        if (distancias[j][i] == -1 || distancias[i][k] == -1) {
                            seguir = false;
                        } else {
                            if (distancias[j][k] == -1) {
                                distancias[j][k] = distancias[j][i] + distancias[i][k];
                                recorridos[j][k] = i;
                                //System.out.println(distancias[j][i] + " + " + distancias[i][k] + " = " + distancias[j][k] + " (ENTRO)");
                                seguir = false;
                            }
                        }
                        if (seguir) {
                            //System.out.print(distancias[j][i] + " + " + distancias[i][k] + " = " + distancias[j][k]);
                            if (distancias[j][i] + distancias[i][k] < distancias[j][k]) {
                                distancias[j][k] = distancias[j][i] + distancias[i][k];
                                recorridos[j][k] = i;
                                //  System.out.println(" (ENTRO) ");
                            } else {
                                //System.out.println();
                            }
                        }
                    }
                }
            }
            System.out.println();
            for (int i = 0; i < cn; i++) {
                for (int j = 0; j < cn; j++) {
                    System.out.print(distancias[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
            for (int i = 0; i < cn; i++) {
                for (int j = 0; j < cn; j++) {
                    System.out.print(recorridos[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
            return distancias;
        } catch (Exception e) {
            return null;
        }
    }

    private int[][] evaluacionFloyd1(DefaultDirectedWeightedGraph<Vertice, DefaultWeightedEdge> grafo, double[][] adyacencia) {
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
            double[][] distancias = new double[cn][cn];
            for (int i = 0; i < cn; i++) {
                for (int j = 0; j < cn; j++) {
                    if (i == j) {
                        distancias[i][j] = 0;
                    } else {
                        distancias[i][j] = -1;
                    }
                }
            }
            for (int i = 0; i < cn; i++) {
                for (int j = 0; j < cn; j++) {
                    for (DefaultWeightedEdge Edge : grafo.edgeSet()) {
                        if (grafo.vertexSet().toArray()[i] == grafo.getEdgeSource(Edge) && grafo.vertexSet().toArray()[j] == grafo.getEdgeTarget(Edge)) {
                            if (pertenece[i] != pertenece[j] && adyacencia[i][j] != 0 && adyacencia[i][j] < 99999) {
                                distancias[i][j] = adyacencia[i][j];
                            }
                            break;
                        }
                    }
                }
            }
            int[][] recorridos = new int[cn][cn];
            for (int i = 0; i < cn; i++) {
                for (int j = 0; j < cn; j++) {
                    if (i == j) {
                        recorridos[i][j] = -1;
                    } else {
                        recorridos[i][j] = j;
                    }
                }
            }
            for (int i = 0; i < cn; i++) {
                for (int j = 0; j < cn; j++) {
                    System.out.print(distancias[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
            for (int i = 0; i < cn; i++) {
                for (int j = 0; j < cn; j++) {
                    System.out.print(recorridos[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
            for (int i = 0; i < cn; i++) {
                for (int j = 0; j < cn; j++) {
                    for (int k = 0; k < cn; k++) {
                        boolean seguir = true;
                        if (distancias[j][i] == 0 || distancias[i][k] == 0 || distancias[j][k] == 0) {
                            seguir = false;
                        } else {
                            if (distancias[j][i] == -1 || distancias[i][k] == -1) {
                                seguir = false;
                            } else {
                                if (distancias[j][k] == -1) {
                                    distancias[j][k] = distancias[j][i] + distancias[i][k];
                                    recorridos[j][k] = i;
                                    //System.out.println(distancias[j][i] + " + " + distancias[i][k] + " = " + distancias[j][k] + " (ENTRO)");
                                    seguir = false;
                                }
                            }
                        }
                        if (seguir) {
                            //System.out.print(distancias[j][i] + " + " + distancias[i][k] + " = " + distancias[j][k]);
                            if (distancias[j][i] + distancias[i][k] < distancias[j][k]) {
                                distancias[j][k] = distancias[j][i] + distancias[i][k];
                                recorridos[j][k] = i;
                                //  System.out.println(" (ENTRO) ");
                            } else {
                                //System.out.println();
                            }
                        }
                    }
                }
            }
            System.out.println();
            for (int i = 0; i < cn; i++) {
                for (int j = 0; j < cn; j++) {
                    System.out.print(distancias[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
            for (int i = 0; i < cn; i++) {
                for (int j = 0; j < cn; j++) {
                    System.out.print(recorridos[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
            return recorridos;
        } catch (Exception e) {
            return null;
        }
    }
}
