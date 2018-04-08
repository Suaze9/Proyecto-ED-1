package ExpansionMinima;

import Bicoloreable.*;
import java.util.ArrayList;

import org.jgrapht.graph.*;

public class Kruskal{
    
    public Kruskal(){
        
    }
    
    private double[][] matrizAdyacencia(SimpleWeightedGraph<Vertice, DefaultWeightedEdge> grafo){
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
    
    private double[][] evaluacionKruskal(SimpleWeightedGraph<Vertice, DefaultWeightedEdge> grafo, double[][] adyacencia){
    int cn = adyacencia.length;
    double[][] arbol = new double[cn][cn];
    double[] pertenece = new double[cn];

    for(int i = 0; i < cn; i++){
        for (int j = 0; j < cn; j++) {
            arbol[i][j] = 0;
        }
        pertenece[i] = i;
    }

    int nodoA=0;
    int nodoB=0;
    int arcos = 1;
    while(arcos < cn){
        // Encontrar  el arco mínimo que no forma ciclo y guardar los nodos y la distancia.
        double min = 999999;
        for(int i = 0; i < cn; i++)
            for(int j = 0; j < cn; j++)
                if(min > adyacencia[i][j] && adyacencia[i][j]!=0 && pertenece[i] != pertenece[j]){
                    min = adyacencia[i][j];
                    nodoA = i;
                    nodoB = j;
                }

        // Si los nodos no pertenecen al mismo árbol agrego el arco al árbol mínimo.
        if(pertenece[nodoA] != pertenece[nodoB]){
            arbol[nodoA][nodoB] = min;
            arbol[nodoB][nodoA] = min;

            // Todos los nodos del árbol del nodoB ahora pertenecen al árbol del nodoA.
        	double temp = pertenece[nodoB];
        	pertenece[nodoB] = pertenece[nodoA];
        	for(int k = 0; k < cn; k++)
        		if(pertenece[k] == temp)
        			pertenece[k] = pertenece[nodoA];

            arcos++;
        }
    }
    return arbol;
}
    
    public double[][] evaluar(SimpleWeightedGraph<Vertice, DefaultWeightedEdge> grafo){
        try{
            double[][] ady = matrizAdyacencia(grafo);
            double[][] arbol = evaluacionKruskal(grafo, ady);
            return arbol;
        }catch(Exception e){
            return null;
        }
    }
    
    
}