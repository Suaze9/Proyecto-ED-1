package proyecto.TDA;

public interface Tree {
    
    public Object padre(NodeTree nodo);
    public Object hijo_izq(NodeTree nodo);
    public Object hijo_der(NodeTree nodo);
    public String etiqueta(NodeTree nodo);
    public boolean crear(Tree arbol1, Tree arbol2);
    public Object raiz();
    public boolean anula();
    
}