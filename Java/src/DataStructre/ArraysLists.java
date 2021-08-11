package DataStructre;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysLists<T> {
    private  Object [] buff;
    private final int EMPTY_SIZE = 10;
    private int size;
    private int len;


    public ArraysLists (int maxSize){
        if (maxSize > 0) {
            this.size = maxSize;
        } else if (maxSize == 0) {
            this.size = EMPTY_SIZE;
        } else {
            throw new IllegalArgumentException(maxSize + "长度不能小于0");
        }
        buff=new Object[this.size];
    }

    public ArraysLists (){
        this.size=EMPTY_SIZE;
        buff=new Object[this.size];

    }
    public void add(T element){

        if (size==len){
            size+=len>>1;
            Object [] newBuff=new Object[size];
            System.arraycopy(buff,0,newBuff,0,len);
            buff=newBuff;
        }

        buff[len]=element;
        len++;

    }


    public int length(){

        return len;
    }

    public T get(int index){
        if (index<0||index>=len)
            throw new IllegalArgumentException("索引不在范围内");
        return (T)buff[index];
    }

    public void set(int index,T element){
        if (index<0||index>=len)
            throw new IllegalArgumentException("索引不在范围内");
            buff[index]=element;

    }
       public void clear(){
        for (int i=0;i<len;i++){
               buff[i]=null;
        }
        len=0;
       }

       public void remove(int index){
           if (index < 0 || index >= len)
               throw new IllegalArgumentException("索引不在范围内");
           for (int i = index; i < len; i++) {
               if (i == len - 1)
                   buff[i] = null;
                else
                   buff[i] = buff[i + 1];


           }
           len--;
//           size--;
       }

       public void remove(T element){
        //找到element（可能存在多个）

           for(int i=0;i<len;i++){
               if (buff[i].equals(element)) {
                   remove(i);
                   --i;//移除目标后，原来的索引1变为0，索引在删除一个后-1
               }

           }
           //获取index
           //移除element
           //没有返回false
       }
    @Override
    public String toString (){
        StringBuilder sb=new StringBuilder();
        sb.append("[");
        for (int i=0;i<len;i++){
            if (i==len-1)
                sb.append(buff[i]);
            else
            sb.append(buff[i]+",");
        }
        sb.append("]");
        return sb.toString();
    }

}
