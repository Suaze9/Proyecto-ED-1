package proyecto.TDA;

public class NodeList implements List{

    private Node Head;
    
    public int size;
    
    public NodeList(){
        Head = null;
        size = 0;
    }
    
    @Override
    public boolean insert(int Pos, Object Data) {
        if (Pos <= size && Pos >= 0) {
            Node aux = Head;
            if (Head == null) {
                Head = new Node();
                Head.data = Data;
                Head.next = Head;
                Head.back = Head;
                size++;
                return true;
            }else{
                for (int i = 0; i < Pos; i++) {
                    aux = aux.next;
                }
                Node temp = new Node();
                temp.data = Data;
                temp.back = aux.back;
                temp.next = aux;
                aux.back = temp;
                temp.back.next = temp;
                size++;
                return true;
            }
        }else{
            return false;
        }
    }

    @Override
    public int find(Object Data) {
        Node aux = Head;
        for (int i = 0; i <= size; i++) {
            if (aux.data == Data) {
                return i;
            }else{
                aux = aux.next;
            }
        }
        return -1;
    }

    @Override
    public Object get(int Pos) {
        if (Pos > size) {
            return null;
        }else{
            Node aux = Head;
            for (int i = 0; i < Pos; i++) {
                aux = aux.next;
            }
            return aux.data;
        }
    }

    @Override
    public boolean delete(int Pos) {
        if ( Pos <= size && Pos >= 0) {
            Node aux = Head;
            for (int i = 0; i < Pos; i++) {
                aux = aux.next;
            }
            aux.back.next = aux.next;
            aux.next.back = aux.back;
            
            if (Pos == 0) {
                Head = aux.back.next;
            }
            size--;
            return true;
        }
        return false;
    }

    @Override
    public Object next(int Pos) {
        return get(Pos + 1);
    }

    @Override
    public void clear() {
        Head = null;
        size = 0;
    }

    @Override
    public Object first() {
        if (Head != null) {
            return Head.data;
        }
        return null;
    }

    @Override
    public void print() {
        Node aux = Head;
        for (int i = 0; i < size; i++) {
            System.out.println("[" + i + "] " + aux.data);
            aux = aux.next;
        }
        if (Head == null) {
            System.out.println("Empty");
        }
    }

    @Override
    public boolean add(Object Data) {
        return insert(size, Data);
    }
    
}
