package Bicoloreable;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import proyecto.TDA.ArrayQueue;

public class GrafoGrafico extends JPanel {

    Graph<Vertice, DefaultEdge> grafo = null;
    boolean conectando = false;
    private int mouseX = 0;
    private int mouseY = 0;
    private int startX = 0;
    private int startY = 0;
    
    Bicoloreable b = new Bicoloreable();
    
    @Override
    public void paint(Graphics g) {
        
        g.setColor(Color.white);
        g.fillRect(0, 0, this.getWidth() - 1, this.getHeight() - 1);
        g.setColor(Color.gray);
        g.drawRect(0, 0, this.getWidth() - 1, this.getHeight() - 1);

        if (grafo != null && !grafo.vertexSet().isEmpty()) {
            boolean first = true;
            Vertice raiz = null;
            for (Vertice vertice : grafo.vertexSet()) {
                g.setColor(Color.gray);
                if (first) {
                    raiz = vertice;
                    first = false;
                }
                vertice.recorrido = false;
                g.fillOval(vertice.posX, vertice.posY, vertice.ancho, vertice.ancho);
                g.drawString((String)vertice.data, vertice.posX, vertice.posY);
                for (DefaultEdge defaultEdge : grafo.outgoingEdgesOf(vertice)) {
                    Vertice hijo = grafo.getEdgeTarget(defaultEdge);
                    if (hijo == vertice) {
                        hijo = grafo.getEdgeSource(defaultEdge);
                    }
                    g.drawLine(vertice.posX + vertice.ancho / 2, vertice.posY + vertice.ancho / 2, hijo.posX + vertice.ancho / 2, hijo.posY + vertice.ancho / 2);
                }
            }
            raiz.recorrido = true;
            ArrayQueue pila = new ArrayQueue();
            pila.queue(raiz);
            while (!pila.isEmpty()){
                Vertice verticeActual = (Vertice)pila.deQueue();
                if (verticeActual.tipo) {
                    g.setColor(Color.blue);
                }else{
                    g.setColor(Color.red);
                }
                g.fillOval(verticeActual.posX, verticeActual.posY, verticeActual.ancho, verticeActual.ancho);
                g.drawString((String)verticeActual.data, verticeActual.posX, verticeActual.posY);
                for (DefaultEdge defaultEdge : grafo.outgoingEdgesOf(verticeActual)) {
                    Vertice hijo = grafo.getEdgeTarget(defaultEdge);

                    if (hijo == verticeActual) {
                        hijo = grafo.getEdgeSource(defaultEdge);
                    }

                    if (!hijo.recorrido) {
                        hijo.recorrido = true;
                        pila.queue(hijo);
                    }else if (hijo.tipo == verticeActual.tipo) {

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
    
    public void setGrafo(Graph<Vertice, DefaultEdge> grafo){
        
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
    
    public boolean evaluar(){
        try{
            return b.bi(grafo, grafo.vertexSet().iterator().next());
        }catch(Exception e){
            return false;
        }
    }
    
}
