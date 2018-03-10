/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.TDA;

/**
 *
 * @author Suazo
 */
public class Camino extends Casilla{
    
    public boolean recorrido;
    
    public Camino(int x, int y) {
        super(x, y);
        recorrido = false;
    }
    
}
