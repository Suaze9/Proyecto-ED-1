package Bicoloreable;

public class Vertice {
    
    public boolean recorrido;
    boolean tipo;
    public Object data;

    public Vertice(boolean recorrido, Object data) {
        this.recorrido = recorrido;
        this.data = data;
        tipo = true;
    }
    
}
