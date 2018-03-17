package proyecto.TDA;

public interface Tree {
    
    public Object getData();
    public Tree padre();
    public Tree hijoMasIzq();
    public Tree hermanoDer();
    public Tree Crea(Object data, Tree... nodos);
    public Tree raiz();
    public Tree anular();
    public void agregar(Tree nodo);
    
}
