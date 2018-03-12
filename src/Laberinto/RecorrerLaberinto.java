package Laberinto;

import proyecto.TDA.ArrayStack;

public class RecorrerLaberinto {
    
    private Casilla[][] matCas;
    private int matY;
    private int matX;
    
    public ArrayStack pila;
    private int finX;
    private int finY;
    private Casilla temp;
    
    public boolean step = false;
    public boolean recorrido = false;
    public boolean salio = false;
    
    public RecorrerLaberinto(Casilla [][] pMatCas, int pMatY, int pMatX){
        matCas = pMatCas;
        matY = pMatY;
        matX = pMatX;
        pila = new ArrayStack();
    }
    
    public void RecorrerStep(){
        pila = new ArrayStack();
        finX = matX-1;
        finY = matY-2;
        ((Camino)matCas[1][0]).recorrido = true;
        pila.push(matCas[1][0]);
        temp = (Casilla)pila.top();
        step = true;
    }
    
    public void Step(){
            if (step) {
                if(!(temp.y == finY && temp.x == finX)){
                    temp = (Casilla)pila.top();
                    if (temp == null) {
                        System.out.println("No encontro solucion");
                        recorrido = true;
                        step = false;
                        salio = false;
                    }
                    int posY=temp.y;
                    int posX=temp.x;
                    boolean change = false;
                    if (posY-1 >= 0 && !change) {
                        if (matCas[posY-1][posX] instanceof Camino) {
                            if(!((Camino)matCas[posY-1][posX]).recorrido){
                                posY = posY-1;
                                change = true;
                                System.out.println("arriba");
                            }
                        }
                    }
                    if(posX+1 < matCas[0].length && !change){
                        if (matCas[posY][posX+1] instanceof Camino) {
                            if(!((Camino)matCas[posY][posX+1]).recorrido){
                                posX = posX+1;
                                change = true;
                                System.out.println("derecha");
                            }
                        }
                    }
                    if(posY+1 < matCas.length && !change){
                        if (matCas[posY+1][posX] instanceof Camino) {
                            if(!((Camino)matCas[posY+1][posX]).recorrido){
                                posY = posY+1;
                                change = true;
                                System.out.println("abajo");
                            }
                        }
                    }
                    if(posX-1 >= 0 && !change) {
                        if (matCas[posY][posX-1] instanceof Camino) {
                            if(!((Camino)matCas[posY][posX-1]).recorrido){
                                posX = posX-1;
                                change = true;
                                System.out.println("izquierda");
                            }
                        }
                    }
                    if (change) {
                        ((Camino)matCas[posY][posX]).recorrido = true;
                        pila.push(matCas[posY][posX]);
                    }else{
                        System.out.println("pop");
                        pila.pop();
                    }
                }else{
                    pila.push(matCas[temp.y][temp.x]);
                    while(pila.top()!=null){
                        ((Camino)pila.pop()).ruta=true;
                    }
                    recorrido = true;
                    step = false;
                    salio = true;
                }
            }
    }
    
    public boolean RecorrerFull(){
        if (!step) {
            pila = new ArrayStack();
            finX = matX-1;
            finY = matY-2;
            ((Camino)matCas[1][0]).recorrido = true;
            pila.push(matCas[1][0]);
            temp = (Casilla)pila.top();
            while(!(temp.y == finY && temp.x == finX)){
                temp = (Casilla)pila.top();
                if (temp == null) {
                    System.out.println("No encontro solucion");
                    return false;
                }
                int posY=temp.y;
                int posX=temp.x;
                boolean change = false;
                if (posY-1 >= 0 && !change) {
                    if (matCas[posY-1][posX] instanceof Camino) {
                        if(!((Camino)matCas[posY-1][posX]).recorrido){
                            posY = posY-1;
                            change = true;
                            System.out.println("arriba");
                        }
                    }
                }
                if(posX+1 < matCas[0].length && !change){
                    if (matCas[posY][posX+1] instanceof Camino) {
                        if(!((Camino)matCas[posY][posX+1]).recorrido){
                            posX = posX+1;
                            change = true;
                            System.out.println("derecha");
                        }
                    }
                }
                if(posY+1 < matCas.length && !change){
                    if (matCas[posY+1][posX] instanceof Camino) {
                        if(!((Camino)matCas[posY+1][posX]).recorrido){
                            posY = posY+1;
                            change = true;
                            System.out.println("abajo");
                        }
                    }
                }
                if(posX-1 >= 0 && !change) {
                    if (matCas[posY][posX-1] instanceof Camino) {
                        if(!((Camino)matCas[posY][posX-1]).recorrido){
                            posX = posX-1;
                            change = true;
                            System.out.println("izquierda");
                        }
                    }
                }
                if (change) {
                    ((Camino)matCas[posY][posX]).recorrido = true;
                    pila.push(matCas[posY][posX]);
                }else{
                    System.out.println("pop");
                    pila.pop();
                }
            }
            pila.push(matCas[temp.y][temp.x]);
            while(pila.top()!=null){
                ((Camino)pila.pop()).ruta=true;
            }
            return true;
        }else{
            while (!recorrido) {
                this.Step();
            }
            return salio;
        }
    }
    
}
