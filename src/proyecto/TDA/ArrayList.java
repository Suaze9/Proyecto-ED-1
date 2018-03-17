package proyecto.TDA;

public class ArrayList implements List {

    public int availPos=0;
    private final int size = 10000;
    private Object[] Array = new Object[size];
    
    @Override
    public boolean insert(int Pos, Object Data) {
        if (Pos >= 0 && Pos <= availPos) {
            if (Pos != availPos) {
                for (int i = availPos; i > Pos; i--) {
                    Array[i]=Array[i-1];
                }
            }
            availPos++;
            Array[Pos]=Data;
            return true;
        }
        return false;
    }

    @Override
    public int find(Object Data) {
        for (int i = 0; i < availPos; i++) {
            if (Array[i] == Data) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Object get(int Pos) {
        if (Pos >=0 && Pos < availPos) {
            return Array[Pos];
        }
        return null;
    }

    @Override
    public boolean delete(int Pos) {
        if (Pos >= 0 && Pos < availPos) {
            Array[Pos]=null;
            for (int i = Pos; i < availPos; i++) {
                Array[i]=Array[i+1];
            }
            availPos--;
            Array[availPos]=null;
            return true;
        }
        return false;
    }

    @Override
    public Object next(int Pos) {
        return get(Pos+1);
    }

    @Override
    public void clear() {
        Array=new Object[size];
        availPos=0;
    }

    @Override
    public Object first() {
        return get(0);
    }

    @Override
    public void print() {
        for (int i = 0; i < availPos; i++) {
            System.out.println("[" + i + "] " + Array[i]);
        }
    }
    
    public int size(){
        return availPos;
    }

    @Override
    public boolean add(Object Data) {
        return insert(availPos, Data);
    }

}
