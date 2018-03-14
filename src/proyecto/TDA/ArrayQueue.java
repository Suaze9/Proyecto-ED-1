package proyecto.TDA;

public class ArrayQueue implements Queue{

    private Object[] array;
    private final int CAP;
    private int size;
    private int S;
    private int F;
    
    public ArrayQueue(){
        CAP = 1000;
        array = new Object[CAP];
        size = 0;
        S = 0;
        F = 0;
    }
    
    @Override
    public boolean queue(Object data) {
        if (size < CAP) {
            array[F] = data;
            F++;
            size++;
            if (F > CAP) {
                F = 0;
            }
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Object deQueue() {
        if (!isEmpty()) {
            Object temp = array[S];
            size--;
            S++;
            if (S>CAP) {
                S = 1;
            }
            return temp;
        }else{
            return null;
        }
    }

    @Override
    public Object front() {
        if (!isEmpty()) {
            return array[S];
        }else{
            return null;
        }
    }

    @Override
    public void clear() {
        array = new Object[CAP];
        size = 0;
        S = 0;
        F = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void print() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
