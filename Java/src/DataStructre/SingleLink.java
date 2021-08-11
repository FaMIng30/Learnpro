package DataStructre;

public class SingleLink<E> {
        SingleNode head=new SingleNode(null,null);
        int size;

    public SingleLink (){
    }


    public int getSize(){
        return size;
    }
    public void add(E element){
        SingleNode temp=head.next;
        SingleNode node=new SingleNode(null,element);
            if (head.next==null){
                head.next=node;
            }else{
                while(temp.next!=null){
                    temp=temp.next;
                }
                temp.next=node;
            }
            size++;
        }
    public E get(){
        SingleNode temp;
        if (head.next == null) {
            System.out.println("没有元素了");
        } else {
            temp = head.next;
            head.next = temp.next;
            return (E) temp.element;

        }
        return null;
    }


    public void remove(E element){
        SingleNode temp=head.next;
        SingleNode temp2=null;
        while(temp!=null){
            if(temp.element.equals(element)&&temp==head.next){
                head.next=temp.next;
            }else if(temp.element.equals(element)){
                temp2.next=temp.next;
            }
            temp2=temp;
            temp=temp.next;
        }
    }


       public String toString(){
        SingleNode temp=head.next;
        StringBuilder sb=new StringBuilder();
        sb.append("[");
        while(temp!=null){
            if (temp.next==null)
            sb.append(temp.element+"]");
            else
                sb.append(temp.element+",");
            temp=temp.next;
        }

        return sb.toString();
       }


}
