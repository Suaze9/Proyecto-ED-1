package Laberinto;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import proyecto.TDA.ArrayStack;

public class Laberinto extends JPanel{
    
    private int matSizeY;
    private int matSizeX;
    private int matY;
    private int matX;
    private int dimY;
    private int dimX;
    private int[][] matriz;
    private Casilla[][] matCas;
    
    private RecorrerLaberinto recorrido;
    
    private boolean clear;
    private boolean step;
    
    public void CambiarLaberinto(int matSizeX, int matSizeY, int[][] mat){
        this.matriz = mat;
        this.matSizeY = matSizeY;
        this.matSizeX = matSizeX;
        this.setSize(matSizeX, matSizeY);
        matY = matriz.length;
        matX = matriz[0].length;
        dimY = matSizeY / matY;
        dimX = matSizeX / matX;
        matCas = getMatrizCasilla(matriz);
        recorrido = new RecorrerLaberinto(matCas, matY, matX);
        step = false;
    }
    
    public Laberinto(int matSizeX, int matSizeY){
        int[][] mat = {
            {1,1,1,1,1,1,1,1,1,1,1,},
            {0,0,1,0,0,0,0,0,0,0,1,},
            {1,0,1,1,1,1,1,1,1,0,1,},
            {1,0,0,0,0,0,0,0,0,0,1,},
            {1,0,1,1,1,1,1,1,1,1,1,},
            {1,0,1,0,0,0,1,0,0,0,1,},
            {1,0,1,0,1,0,1,1,1,0,1,},
            {1,0,0,0,1,0,0,0,1,0,1,},
            {1,1,1,1,1,1,1,0,1,0,1,},
            {1,0,0,0,0,0,0,0,0,0,0,},
            {1,1,1,1,1,1,1,1,1,1,1,},
        };
        this.matriz = mat;
        this.matSizeY = matSizeY;
        this.matSizeX = matSizeX;
        matY = matriz.length;
        matX = matriz[0].length;
        dimY = matSizeY / matY;
        dimX = matSizeX / matX;
        matCas = getMatrizCasilla(matriz);
        recorrido = new RecorrerLaberinto(matCas, matY, matX);
    }
    
    @Override
    public void paint(Graphics g) {
        int winY = matY*dimY;
        int winX = matX*dimX;
        this.setSize(winX, winY);
        if (step) {
            for (int y = 0; y < matY; y++) {
                for (int x = 0; x < matX; x++) {
                    Color color = null;
                    if (matCas[y][x] instanceof Muro) {
                        color = Color.black;
                    } else if (((Camino)matCas[y][x]).ruta){
                        color = Color.green;
                    }else {
                        color = Color.white;
                    }
                    g.setColor(color);
                    g.fillRect(x*dimX, y*dimY, dimX, dimY);
                }
            }
            ArrayStack tempStack = new ArrayStack(recorrido.pila);
            while(!tempStack.isEmpty()){
                Color color = Color.red;
                Casilla tempCas = (Casilla)tempStack.pop();
                g.setColor(color);
                g.fillRect(tempCas.x*dimX, tempCas.y*dimY, dimX, dimY);
            }
        }else{
            for (int y = 0; y < matY; y++) {
                for (int x = 0; x < matX; x++) {
                    Color color = null;
                    if (matCas[y][x] instanceof Muro) {
                        color = Color.black;
                    } else if (((Camino)matCas[y][x]).ruta){
                        color = Color.green;
                    }else {
                        color = Color.white;
                    }
                    g.setColor(color);
                    g.fillRect(x*dimX, y*dimY, dimX, dimY);
                }
            }
        }
        
    }
    
    public void clearWindow(){
        clear = true;
        this.repaint();
        clear = false;
    }
    
    public boolean recorrerFull(){
        step = false;
        return recorrido.RecorrerFull();
    }
    
    public void step(){
        if (!recorrido.recorrido) {
            if (step) {
                recorrido.Step();
                repaint();
            }else{
                step=true;
                recorrido.RecorrerStep();
            }
        }else{
        }
    }
    
    private Casilla[][] getMatrizCasilla(int[][] tempMat){
        Casilla[][] matSalida = new Casilla[tempMat.length][tempMat[0].length];
        for (int y = 0; y < tempMat.length; y++) {
            for (int x = 0; x < tempMat[0].length; x++) {
                if (tempMat[y][x] == 1) {
                    matSalida[y][x] = new Muro(y,x);
                }else {
                    matSalida[y][x] = new Camino(y,x);
                }
            }
        }
        return matSalida;
    }
    
    public int[][] getMatriz(){
        return matriz;
    }
    
}
