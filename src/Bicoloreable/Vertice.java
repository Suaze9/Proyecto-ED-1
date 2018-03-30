package Bicoloreable;

public class Vertice {
    
    public final int ancho = 40;
    
    public boolean recorrido;
    boolean tipo;
    public Object data;
    
    public int posY;
    public int posX;

    public Vertice(boolean recorrido, Object data) {
        this.recorrido = recorrido;
        this.data = data;
        tipo = true;
    }
    
    public Vertice(boolean recorrido, Object data, int posY, int posX) {
        this.recorrido = recorrido;
        this.data = data;
        tipo = true;
        this.posY = posY;
        this.posX = posX;
    }
    
    public boolean dentroPunto(int posX, int posY){
        if (posX >= this.posX && posX <= this.posX + ancho) {
            if (posY >= this.posY && posY <= this.posY + ancho) {
                return true;
            }
        }
        return false;
    }
    
}
