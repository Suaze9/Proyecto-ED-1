package proyecto.TDA;

public interface Tree {
    
    public BinaryTree padre();
    public BinaryTree hijo_izq();
    public BinaryTree hijo_der();
    public Object etiqueta();
    public BinaryTree crear(BinaryTree arbol2, Object etiqueta, boolean Raiz);
    public BinaryTree raiz();
    public boolean anula();
    
}