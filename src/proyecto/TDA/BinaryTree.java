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

    public BinaryTree padre;
    public Object data;
    public BinaryTree hijo_izq;
    public BinaryTree hijo_der;
    public boolean raiz = false;

    public BinaryTree() {
        this.padre = null;
        this.data = null;
        this.hijo_izq = null;
        this.hijo_der = null;
        raiz = false;
    }

    public BinaryTree(BinaryTree padre, Object data, BinaryTree hijo_izq, BinaryTree hijo_der, boolean raiz2) {
        this.padre = padre;
        this.data = data;
        this.hijo_izq = hijo_izq;
        this.hijo_der = hijo_der;
        raiz = raiz2;
    }

    @Override
    public BinaryTree padre() {
        return padre;
    }

    @Override
    public BinaryTree hijo_izq() {
        return hijo_izq;
    }

    @Override
    public BinaryTree hijo_der() {
        return hijo_der;
    }

    @Override
    public Object etiqueta() {
        return data;
    }

    @Override
    public BinaryTree crear(BinaryTree arbol) {
        BinaryTree nuevo_arbol = null;
        
        return nuevo_arbol;
    }

    @Override
    public BinaryTree raiz() {
        if (raiz) {
            return padre;
        } else {
            return null;
        }
    }

    @Override
    public boolean anula() {
        padre = null;
        hijo_izq = null;
        hijo_der = null;
        data = null;
        raiz = false;
        return true;
    }

    public BinaryTree getPadre() {
        return padre;
    }

    public void setPadre(BinaryTree padre) {
        this.padre = padre;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public BinaryTree getHijo_izq() {
        return hijo_izq;
    }

    public void setHijo_izq(BinaryTree hijo_izq) {
        this.hijo_izq = hijo_izq;
    }

    public BinaryTree getHijo_der() {
        return hijo_der;
    }

    public void setHijo_der(BinaryTree hijo_der) {
        this.hijo_der = hijo_der;
    }

    public boolean isRaiz() {
        return raiz;
    }

    public void setRaiz(boolean raiz) {
        this.raiz = raiz;
    }

    
}
