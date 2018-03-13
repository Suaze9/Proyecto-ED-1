/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.TDA;

/**
 *
 * @author usuario
 */
public class BinaryTree implements Tree{

    public NodeTree raiz = null;

    @Override
    public Object padre(NodeTree nodo) {
        return nodo.getPadre();
    }

    @Override
    public Object hijo_izq(NodeTree nodo) {
        return nodo.getHijo_izq();
    }

    @Override
    public Object hijo_der(NodeTree nodo) {
        return nodo.getHijo_der();
    }

    @Override
    public String etiqueta(NodeTree nodo) {
        return nodo.toString();
    }

    @Override
    public Object raiz() {
        return true;
    }

    @Override
    public boolean anula() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean crear(Tree arbol1, Tree arbol2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
