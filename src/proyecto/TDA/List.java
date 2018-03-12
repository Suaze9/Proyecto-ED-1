
package proyecto.TDA;

public interface List {
    
    public boolean insert(int Pos, Object Data);
    public int find(Object Data);
    public Object get (int Pos);
    public boolean delete(int Pos);
    public Object next(int Pos);
    public void clear();
    public Object first();
    public void print();
    
}
