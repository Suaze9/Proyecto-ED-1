package proyecto.TDA;

public class Node {
    
    public Node next;
    public Node back;
    public Object data;
    
    public Node(Node next, Node back){
        this.next = next;
        this.back = back;
        data = null;
    }
    
    public Node(){
        this.next = null;
        this.back = null;
        data = null;
    }
    
    public void setNext(Node newNext){
        this.next = newNext;
    }
    
    public void setBack(Node newBack){
        this.back = newBack;
    }
    
    public Node getNext(){
        return next;
    }
    
    public Node getBack(){
        return back;
    }
    
    public void setData(Object newData){
        this.data = newData;
    }
    
    public Object getData(){
        return data;
    }
}
