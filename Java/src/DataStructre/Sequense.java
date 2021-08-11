package DataStructre;

public class Sequense<E> {
    Object [] arr;
    int front;
    int rear;
    final int MAXSIZE=6;

    public Sequense(int maxsize){
        arr = new Object[maxsize];
        front=0;
        rear=0;
    }

    public Sequense(){
        arr=new Object[MAXSIZE];
        front=0;
        rear=0;
    }


     public boolean isEmpty(){
        return front==rear;
     }
     public boolean isFull(){
        int maxsize=arr.length;
        return (rear+1)%maxsize==front;   //rear+1==maxsize
     }
    public void add(E element){
        int maxsize=arr.length;
        if (isFull()){
            System.out.println("队列已满");
        }else{
            arr[rear]=element;
           rear= (rear+1)%maxsize;
        }
    }
    public E get(){
        int maxsize=arr.length;
        int temp=front;
        if (isEmpty()){
            System.out.println("队列为空");
        }else{
            front=(front+1)%maxsize;
            return (E)arr[temp];
        }
           return null;
    }
    public int size(){
        int maxsize=arr.length;
         return(rear-front+maxsize)%maxsize;//例(1-5+16)%16  负数的取模
    }
   public void print(){
       int maxsize=arr.length;
          for (int i=front ; i!=rear ;  i=(i+1)%maxsize)
              System.out.println(arr[i]);

   }

}
