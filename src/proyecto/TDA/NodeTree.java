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
public class NodeTree {
    
    public NodeTree padre;
    public Object data;
    public NodeTree hijo_izq;
    public NodeTree hijo_der;

    public NodeTree() {
        this.padre = null;
        data = null;
        this.hijo_izq = null;
        this.hijo_der = null;
    }

    public NodeTree getPadre() {
        return padre;
    }

    public void setPadre(NodeTree padre) {
        this.padre = padre;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public NodeTree getHijo_izq() {
        return hijo_izq;
    }

    public void setHijo_izq(NodeTree hijo_izq) {
        this.hijo_izq = hijo_izq;
    }

    public NodeTree getHijo_der() {
        return hijo_der;
    }

    public void setHijo_der(NodeTree hijo_der) {
        this.hijo_der = hijo_der;
    }
    
    @Override
    public String toString() {
        return data + "";
    }
    
}