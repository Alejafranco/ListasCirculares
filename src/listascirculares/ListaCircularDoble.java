package listascirculares;

public class ListaCircularDoble<T extends Comparable> {

    DoubleNode<T> head;

    public ListaCircularDoble() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void add(T d) {
        DoubleNode<T> newNode = new DoubleNode<>(d);
        if (isEmpty()) {
            head = newNode;
            newNode.setNextNode(newNode);
            newNode.setPreviousNode(newNode);
        } else {
            newNode.setPreviousNode(head.getPreviousNode());
            newNode.setNextNode(head);
            head.setPreviousNode(newNode);
            head = newNode;
            head.getPreviousNode().setNextNode(head);

        }
    }

    public void addLast(T d) {
        DoubleNode<T> newNode = new DoubleNode<>(d);
        if (isEmpty()) {
            head = newNode;
            newNode.setNextNode(newNode);
            newNode.setPreviousNode(newNode);
        } else {
            newNode.setPreviousNode(head.getPreviousNode());
            newNode.setNextNode(head);
            head.getPreviousNode().setNextNode(newNode);
            head.setPreviousNode(newNode);
            //head=newNode;
            //¿Se puede refactorizar?

        }
    }

    public boolean ExistData(T d) throws Exception {
        if (isEmpty()) {
            throw new Exception("LA LISTA ESTÁ VACÍA");
        } else {
            DoubleNode<T> current = this.head;
            do {
                if (current.getData().compareTo(d) == 0) {
                    return true;
                }
                current = current.getNextNode();
            } while (current != head);
            return false;
        }
    }

    public String showData() {
        String data = "";
        DoubleNode<T> current = this.head;
        do {
            data = data + current.getData() + " ";
            current = current.getNextNode();
        } while (current != head);
        return data;
    }

    public void addOrdered(T d) throws Exception {
        if (isEmpty() || d.compareTo(this.head.getData()) == -1) {
            add(d);
        } else if (ExistData(d)) {
            throw new Exception("EL DATO QUE DESEA INGRESAR YA EXISTE");
        } else {
            DoubleNode<T> current = this.head;
            do {
                if (d.compareTo(current.getData()) == -1) {
                    DoubleNode<T> newNode = new DoubleNode<>(d, current.getPreviousNode(), current);
                    current.getPreviousNode().setNextNode(newNode);
                    current.setPreviousNode(newNode);
                    return;
                }
                current = current.getNextNode();
            } while (current != head);
            addLast(d);
        }
    }

    public ListaCircularDoble<T> DivideList(T d) throws Exception {
        String data = "";
        if (isEmpty()) {
            throw new Exception("LA LISTA ESTÁ VACÍA");
        } else if (!ExistData(d)) {
            throw new Exception("EL DATO QUE ESTÁ BUSCANDO NO EXISTE");
        } else if (d == head.getData()) {
            throw new Exception("NO ESTÁ DIVIDIENDO LA LISTA");
        } else {
            ListaCircularDoble<T> newList = new ListaCircularDoble<>();
            DoubleNode<T> current = this.head;
            while (current.getData() != d) {
                current = current.getNextNode();
            }
            while (current != head) {
                newList.add(current.getData());
                current = current.getNextNode();
            }
            return newList;
        }
    }
    
    public String showVideo() {
        String data = "";
        DoubleNode<T> current = this.head;
        do {
            data += current.getData() + " \n";
            current = current.getNextNode();
        } while (current != head);
        return data;
    }

    public void delete() throws Exception {
        if (isEmpty()) {
            throw new Exception("No existen datos por borrar...");
        } else if (head == head.getPreviousNode()) {
            head = null;
        } else {
            head.getNextNode().setPreviousNode(head.getPreviousNode());
            head.getPreviousNode().setNextNode(head.getNextNode());
            head = head.getNextNode();
        }
    }

    public void deleteVideo(T nameVideo) throws Exception {
        if (isEmpty()) {
            throw new Exception("No existen datos por borrar...");
        } else if (!ExistData(nameVideo)) {
            throw new Exception("EL VIDEO QUE ESTÁ BUSCANDO NO EXISTE");
        } else if (head.getData().compareTo(nameVideo) == 0) {
            delete();
        } else {
            DoubleNode<T> current = this.head.getNextNode();
            do {
                if (current.getData().compareTo(nameVideo)==0) {
                    current.getNextNode().setPreviousNode(current.getPreviousNode());
                    current.getPreviousNode().setNextNode(current.getNextNode());
                    return;
                }
                current = current.getNextNode();
            } while (current != head);
        }
    }

    public void actualizar(T before, T after) throws Exception {
        if (isEmpty()) {
            throw new Exception("LA LISTA DE VIDEOS ESTÁ VACÍA!");
        } else if (!ExistData(before)) {
            throw new Exception("EL VIDEO QUE ESTÁ BUSCANDO NO EXISTE");
        } else {
            DoubleNode<T> current = this.head;
            do {
                if (current.getData().compareTo(before) == 0) {
                    current.setData(after);
                    return;
                }
                current = current.getNextNode();
            } while (current != head);
        }
    }
    
    public void reproducir() throws Exception{
       String data = "";
        DoubleNode<T> current = this.head;
        do {
            System.out.println("Reproduciendo: "+ current.getData());
            Thread.sleep(2000);
            current = current.getNextNode();
        } while (current != head);
    }
}
