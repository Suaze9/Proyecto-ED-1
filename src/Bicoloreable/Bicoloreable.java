package Bicoloreable;

import java.net.*;

import org.jgrapht.*;
import org.jgrapht.graph.*;
import proyecto.TDA.ArrayQueue;

public class Bicoloreable{
    
    public Bicoloreable(){
        
    }
    
    public boolean bi(Graph<Vertice, DefaultEdge> grafo, Vertice raiz){
        for (Vertice vertice : grafo.vertexSet()) {
            vertice.recorrido = false;
            vertice.tipo = true;
        }
        raiz.recorrido = true;
        raiz.tipo = true;
        ArrayQueue pila = new ArrayQueue();
        pila.queue(raiz);
        while (!pila.isEmpty()){
            Vertice verticeActual = (Vertice)pila.deQueue();
            for (DefaultEdge defaultEdge : grafo.outgoingEdgesOf(verticeActual)) {
                Vertice hijo = grafo.getEdgeTarget(defaultEdge);
                
                if (hijo == verticeActual) {
                    hijo = grafo.getEdgeSource(defaultEdge);
                }
                
                if (!hijo.recorrido) {
                    hijo.recorrido = true;
                    hijo.tipo = (verticeActual.tipo != true);
                    System.out.println(hijo.data);
                    pila.queue(hijo);
                }else if (hijo.tipo == verticeActual.tipo) {
                    for (Vertice vertice : grafo.vertexSet()) {
                        vertice.tipo = true;
                    }
                    return false;
                }
            }
        }
        return true;
    }
}