package DataStructre;

public class Linklists <E>{
    private Node head;
    private Node last;
    private int size;

   public  Linklists(){

   }

   public void add(E element){
       Node node=new Node(null,element,null);
       if (head==null){
           head=node;
           last=node;
       }else{
         node.prevoius=last;
        last.next=node;//
        last=node;//把为节点设为node
       }
       size++;
   }



  public int size(){
       return size;
  }



  public void checkRange(int index){
      if (index>=size || index<0)
          throw new ArrayIndexOutOfBoundsException("索引越界");
  }




   public Node getNode(int index){
      checkRange(index);

       Node node=null;

       if (index<(size>>1)){
             node=head;
           for (int i=0;i<index;i++){

                   node= node.next;
           }
       }else {
                 node=last;
           for (int k=size-1;k>index;k--){

               node=node.prevoius;
           }
       }


       return node;

   }




   public E get(int index){
       Node node=getNode(index);
       return (E)node.element;
   }


public void set(int index,E element){
       Node node =getNode(index);
       node.element=element;
}


  public void remove(int index){
       checkRange(index);
       Node node=getNode(index);
       Node prev=node.prevoius;
       Node next=node.next;
       E element=(E)node.element;
       if (prev==null){//头节点

           head=next;
       }else{
           prev.next=next;//处理前驱
       }
      if (next==null){//尾节点

          last=prev;
       }else{
          next.prevoius=prev;//处理后继
      }
     size--;

  }



   public Object [] toArray(Linklists linklists){
       Object [] obj=new Object[size];
       int count=0;
       for(Node i=head;i!=null;i=i.next){
           System.out.print(i.element+"\t");
           obj[count++]=i.element;
       }
       return obj;
   }

}
