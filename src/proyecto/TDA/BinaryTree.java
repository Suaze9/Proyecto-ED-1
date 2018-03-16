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
public class BinaryTree implements ADTBinaryTree{

    public Object data;
    public BinaryTree hijo_izq;
    public BinaryTree hijo_der;
    public boolean raiz = false;

    public BinaryTree() {
        this.data = null;
        this.hijo_izq = null;
        this.hijo_der = null;
        raiz = false;
    }

    public BinaryTree(Object data, BinaryTree hijo_izq, BinaryTree hijo_der, boolean raiz2) {
        this.data = data;
        this.hijo_izq = hijo_izq;
        this.hijo_der = hijo_der;
        raiz = raiz2;
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
    public BinaryTree crear(BinaryTree arbol2, Object etiqueta, boolean Raiz) {
        BinaryTree arbol1 = new BinaryTree(this.data, this.hijo_izq, this.hijo_der, raiz);
        BinaryTree nuevo_arbol = new BinaryTree(etiqueta, arbol1, arbol2, Raiz);
        return nuevo_arbol;
    }

    @Override
    public boolean anula() {
        hijo_izq = null;
        hijo_der = null;
        data = null;
        raiz = false;
        return true;
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
