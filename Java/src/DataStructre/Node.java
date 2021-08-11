package DataStructre;

public class Node<E> {
    public E element;
    public Node prevoius;
    public Node next;

    public Node(Node prev,E element,Node next){
        this.element=element;
        this.prevoius=prev;
        this.next=next;
    }

    public Object getElement (){
        return element;
    }
}
