package proyecto.TDA;

public class ArrayStack implements Stack{

    protected Object[] array;
    protected int CAP;
    protected int size;
    
    public ArrayStack(){
        
        size= -1;
        
        CAP = 1000;
        
        array = new Object[CAP];
        
        for (int i = 0; i < CAP; i++) {
            array[i] = null;
        }
    }
    
    public ArrayStack(ArrayStack prev){
        
        size= prev.size;
        
        CAP = prev.CAP;
        
        array = new Object[CAP];
        
        for (int i = 0; i < CAP; i++) {
            array[i] = prev.array[i];
        }
    }
    
    @Override
    public boolean push(Object data) {
        if ( size < CAP -1 ) {
            array[++size] = data;
            return true;
        }else{
            int tempCAP = (int) (CAP+(CAP/2));
        
            Object[] tempArray = new Object[tempCAP];
            
            for (int i = 0; i < array.length; i++) {
                tempArray[i]=array[i];
            }
            tempArray[++size] = data;
            array = tempArray;
            CAP = tempCAP;
            return true;
        }
    }

    @Override
    public Object pop() {
        if ( size >= 0 ) {
            Object temp = array[size];
            array[size] = null;
            size--;
            return temp;
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size == -1;
    }

    @Override
    public Object top() {
        if ( size >= 0) {
            return array[size];
        }
        return null;
    }

    @Override
    public void clear() {
        array = new Object[CAP];
        
        for (int i = 0; i < CAP; i++) {
            array[i] = null;
        }
        
    }

    @Override
    public void print() {
        for (int i = size; i >= 0; i--) {
            System.out.println("["+array[i].toString()+"]");
        }
    }
    
}
