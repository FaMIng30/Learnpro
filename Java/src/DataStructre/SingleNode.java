package DataStructre;

public class SingleNode<E> {
    SingleNode next;
    E element;

    public SingleNode (SingleNode next, E element){
        this.next = next;
        this.element = element;
    }

}
