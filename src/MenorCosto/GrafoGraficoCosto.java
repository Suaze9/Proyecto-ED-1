/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MenorCosto;

import Bicoloreable.*;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;
import org.jgrapht.graph.DefaultDirectedWeightedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

/**
 *
 * @author usuario
 */
public class GrafoGraficoCosto extends JPanel {
    DefaultDirectedWeightedGraph<Vertice, DefaultWeightedEdge> grafo = null;
    boolean conectando = false;
    private int mouseX = 0;
    private int mouseY = 0;
    private int startX = 0;
    private int startY = 0;
    
    Dijkstra k = new Dijkstra();
    double[][] arbol;
    
    @Override
    public void paint(Graphics g) {
        
        g.setColor(Color.white);
        g.fillRect(0, 0, this.getWidth() - 1, this.getHeight() - 1);
        g.setColor(Color.gray);
        g.drawRect(0, 0, this.getWidth() - 1, this.getHeight() - 1);

        if (grafo != null && !grafo.vertexSet().isEmpty()) {
            for (Vertice vertice : grafo.vertexSet()) {
                g.setColor(Color.gray);
                g.fillOval(vertice.posX, vertice.posY, vertice.ancho, vertice.ancho);
                g.drawString((String)vertice.data, vertice.posX, vertice.posY);
            }
            for (Vertice vertice : grafo.vertexSet()) {
                for (DefaultWeightedEdge defaultEdge : grafo.outgoingEdgesOf(vertice)) {
                    Vertice hijo = grafo.getEdgeTarget(defaultEdge);
                    if (hijo != vertice) {
                        int StringX = 0;
                        int StringY = 0;
                        if (vertice.posX > hijo.posX) {
                            if (vertice.posY > hijo.posY) {
                                StringX = (vertice.posX + vertice.ancho / 2) - (hijo.posX + vertice.ancho / 2);
                                StringX = (vertice.posX + vertice.ancho / 2) - StringX / 2;
                                StringY = ( vertice.posY + vertice.ancho / 2) - (hijo.posY + vertice.ancho / 2);
                                StringY = (vertice.posY + vertice.ancho / 2) - StringY / 2;
                            }else{
                                StringX = (vertice.posX + vertice.ancho / 2) - (hijo.posX + vertice.ancho / 2);
                                StringX = (vertice.posX + vertice.ancho / 2) - StringX / 2;
                                StringY = ( hijo.posY + vertice.ancho / 2) - (vertice.posY + vertice.ancho / 2);
                                StringY = ( hijo.posY + vertice.ancho / 2) - StringY / 2;
                            }
                        }else{
                            if (vertice.posY > hijo.posY) {
                                StringX = (hijo.posX + vertice.ancho / 2) - (vertice.posX + vertice.ancho / 2);
                                StringX = (hijo.posX + vertice.ancho / 2) - StringX / 2;
                                StringY = ( vertice.posY + vertice.ancho / 2) - (hijo.posY + vertice.ancho / 2);
                                StringY = ( vertice.posY + vertice.ancho / 2) - StringY / 2;
                            }else{
                                StringX = (hijo.posX + vertice.ancho / 2) - (vertice.posX + vertice.ancho / 2);
                                StringX = (hijo.posX + vertice.ancho / 2) - StringX / 2;
                                StringY = ( hijo.posY + vertice.ancho / 2) - (vertice.posY + vertice.ancho / 2);
                                StringY = ( hijo.posY + vertice.ancho / 2) - StringY / 2;
                            }
                        }
                        g.setColor(Color.blue);
                        g.drawString(grafo.getEdgeWeight(defaultEdge)+"", StringX, StringY);
                        g.drawLine(vertice.posX + vertice.ancho / 2, vertice.posY + vertice.ancho / 2, hijo.posX + vertice.ancho / 2, hijo.posY + vertice.ancho / 2);
                        //g.drawLine((hijo.posX + vertice.ancho / 2)-5, (hijo.posY + vertice.ancho / 2)-5, hijo.posX + vertice.ancho / 2, hijo.posY + vertice.ancho / 2);
                        //g.drawLine((hijo.posX + vertice.ancho / 2)+5, (hijo.posY + vertice.ancho / 2)-5, hijo.posX + vertice.ancho / 2, hijo.posY + vertice.ancho / 2);
                        
                        int posX1 = vertice.posX + vertice.ancho / 2;
                        int posY1 = vertice.posY + vertice.ancho / 2;
                        int posX2 = hijo.posX + vertice.ancho / 2;
                        int posY2 = hijo.posY + vertice.ancho / 2;
                        
                        g.fillRect(posX2-5, posY2-5, 10, 10);
                        
                        g.setColor(Color.gray);
                    }
                    
                }
            }
            g.setColor(Color.green);

            if (arbol != null) {
                Object[] arregloVertices = grafo.vertexSet().toArray();
                for (int i = 0; i < arbol.length; i++) {
                    for (int j = 0; j < arbol.length; j++) {
                        if (arbol[i][j] != 0) {
                            Vertice verticeSource = (Vertice)arregloVertices[i];
                            Vertice verticeTarget = (Vertice)arregloVertices[j];
                            g.drawLine(verticeSource.posX + verticeSource.ancho / 2, verticeSource.posY + verticeSource.ancho / 2, verticeTarget.posX + verticeSource.ancho / 2, verticeTarget.posY + verticeSource.ancho / 2);
                        }
                    }
                }
            }
        }else{
        }
        
        if (conectando) {
            g.setColor(Color.red);
            g.drawLine(startX , startY, mouseX, mouseY);
        }
    
    }
    
    public void setGrafo(DefaultDirectedWeightedGraph<Vertice, DefaultWeightedEdge> grafo){
        
        if (grafo!=null) {
            this.grafo = grafo;
        }
        
    }
    
    public void setConectando(boolean conectando, int mouseX, int mouseY, int startX, int startY){
        this.conectando = conectando;
        this.mouseX = mouseX;
        this.mouseY = mouseY;
        this.startX = startX;
        this.startY = startY;
    }
    
    public ArrayList<Nodo_Grafo> evaluar(int origen){
        try{
            ArrayList<Nodo_Grafo> arbol1 = k.evaluar(grafo, origen);
            return arbol1;
        }catch(Exception e){
            return null;
        }
    }
    
    public void setArbolNull(){
        arbol=null;
    }
}
