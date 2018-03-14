package proyecto.TDA;

public interface Queue {
    
    boolean queue(Object data);
    Object deQueue();
    Object front();
    void clear();
    boolean isEmpty();
    void print();
    
}
