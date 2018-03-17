package proyecto.TDA;

public class NodeTree implements Tree{
    
    public NodeTree padre;
    public Object data;
    protected ArrayList hijos;

    public NodeTree(Object data) {
        this.padre = null;
        this.data = data;
        hijos = new ArrayList();
    }
    public NodeTree(NodeTree nodo) {
        this.padre = null;
        data = nodo.getData();
        hijos = nodo.hijos;
    }
    
    @Override
    public Object getData() {
        return data;
    }
    
    @Override
    public NodeTree padre() {
        return padre;
    }

    @Override
    public NodeTree hijoMasIzq() {
        if (hijos.size() != 0) {
            return (NodeTree)hijos.get(0);
        }else{
            return null;
        }
    }

    @Override
    public NodeTree hermanoDer() {
        if (padre != null) {
            NodeTree tempPadre = this.padre;
            int thisPos = tempPadre.hijos.find(this);
            if (tempPadre.hijos.size()-1 > thisPos){
                return (NodeTree)tempPadre.hijos.get(thisPos+1);
            }else{
                return null;
            }
        }else{
            return null;
        }
    }

    @Override
    public NodeTree Crea(Object data, Tree... nodos) {
        NodeTree arbolTemp = new NodeTree(data);
        arbolTemp.agregar(this);
        for (Tree nodo : nodos) {
            if (nodo instanceof NodeTree) {
                arbolTemp.agregar(nodo);
            }else{
                return null;
            }
        }
        return arbolTemp;
    }

    @Override
    public NodeTree raiz() {
        if (this.padre != null) {
            return raiz(this.padre);
        }else{
            return this;
        }
    }
    
    private NodeTree raiz(NodeTree nodo) {
        if (nodo.padre != null) {
            Tree tempNodo = raiz(nodo.padre);
            if (tempNodo instanceof NodeTree) {
                return (NodeTree)tempNodo;
            }else{
                return null;
            }
        }else{
            return nodo;
        }
    }

    @Override
    public NodeTree anular() {
        if (this.padre != null) {
            this.padre.hijos.delete(this.padre.hijos.find(this));
            this.padre = null;
        }
        this.hijos = new ArrayList();
        this.data = null;
        return this;
    }

    @Override
    public void agregar(Tree nodo) {
        if (nodo instanceof NodeTree) {
            ((NodeTree) nodo).padre = this;
            this.hijos.add(nodo);
        }
    }
    
}