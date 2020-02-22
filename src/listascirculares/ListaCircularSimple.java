
package listascirculares;

public class ListaCircularSimple<T extends Comparable> {
    Node<T> head;
    Node<T> tail;
    
    public ListaCircularSimple(){
        head = tail = null;
    }
    
    public boolean isEmpty() {
        return head == null;
    }
    
    private Node<T> addNode(T d) {
        Node<T> newNode = new Node<>(d);
        if (isEmpty()) {
            head = tail = newNode;
            newNode.setNextNode(newNode);
        } else {
            newNode.setNextNode(head);
            tail.setNextNode(newNode);
        }
        return newNode;
    }
    
    public void add(T d) {
        head = addNode(d);
    }
    
     public void addLast(T d) {
        tail = addNode(d);
    }
    
    public boolean ExistData(T d) throws Exception{
        if(isEmpty()){
            throw new Exception("LA LISTA ESTÁ VACÍA");
        }else{
            Node<T> current = this.head;            
            do{
                if(current.getData() == d){
                    return true;
                }             
                current = current.getNextNode();
            }while(current != head);          
            return false;
        }
    }
    
    public String showData() {
        String data = "";
        Node<T> current = this.head;
        do{
            data = data + current.getData() + " ";
            current = current.getNextNode();
        }while (current != head);
        return data;
    }
    
    public void addOrdered(T d) throws Exception {
        Node<T> newNode = new Node<>(d);   
        if (isEmpty() || d.compareTo(this.head.getData()) == 1) {
            add(d);
        }else if(ExistData(d)){
            throw new Exception("EL DATO QUE DESEA INGRESAR YA EXISTE");
        }else{
            Node<T> current = this.head;
            do{
                if(d.compareTo(current.getNextNode().getData())== 1){
                    newNode.setNextNode(current.getNextNode());
                    current.setNextNode(newNode);  
                    return;
                }
                current = current.getNextNode();
            }while(current.getNextNode() != head);
            if(current == tail){
               addLast(d);
            }
        }
    }
    
    public String recorrerDesde(T d) throws Exception{
        String data = "";
        if (isEmpty()){
            throw new Exception("LA LISTA ESTÁ VACÍA");
        }else if(!ExistData(d)){
            throw new Exception("EL DATO QUE ESTÁ BUSCANDO NO EXISTE");
        }else if(d == head.getData()){
            return showData();
        }else{
            Node<T> current = this.head;
            while(current.getData() != d){
                current = current.getNextNode();
            }           
            do{
                data += current.getData() + " ";
                current = current.getNextNode();
            }while(current.getData() != head.getData());
            return data;
        }
    }
    
    public ListaCircularSimple<T> joinList(ListaCircularSimple<T> list){
        ListaCircularSimple<T> newList = this;
        newList.tail.setNextNode(list.head);
        list.tail.setNextNode(newList.head);
        return newList;
    }
}
