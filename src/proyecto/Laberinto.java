package proyecto;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Laberinto extends JPanel{
    
    private int matSizeX;
    private int matSizeY;
    private int matX;
    private int matY;
    private int dimX;
    private int dimY;
    private int[][] matriz;
    
    Laberinto(int matSizeX, int matSizeY){
        int[][] mat = {
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1}, 
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
        };
        this.matriz = mat;
        
        this.matSizeX = matSizeX;
        this.matSizeY = matSizeY;
        matX = matriz.length;
        matY = matriz[0].length;
        dimX = matSizeX / matX;
        dimY = matSizeY / matY;
    }
    
    @Override
    public void paint(Graphics g) {
        for (int i = 0; i < matriz[0].length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                Color color = null;
                if (matriz[j][i] == 1) {
                    color = Color.black;
                } else {
                    color = Color.white;
                }
                g.setColor(color);
                g.fillRect(i*dimY, j*dimX, dimY, dimX);
            }
        }
    }
    
    /*
    public void recorrer(){
        int matX=0;
        int matY=0;
        
        Casilla[][] matriz;
        Stack<Casilla> pila = new Stack<Casilla>;
        
        int xFin = 5;
        int yFin = 5;
        pila.push(matriz[matX][matY]);
        while(!(matX == xFin && matY == yFin)){
            Casilla temp = matriz[matX][matY];
            if () {
                
            }
        }
    }
    */
}
