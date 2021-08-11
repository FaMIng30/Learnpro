package DataStructre;

import java.util.Arrays;

public class Hashmaps {
    Object[] table;
    int size;

    public Hashmaps (){
        table = new Object[16];
    }

    //添加
    public void put (Object key, Object value){
        checkRange();
        int hash = myHash(key.hashCode(), table.length);//计算hash值
        System.out.println(hash);
        MapNode node = (MapNode) table[hash];//hash值对应的索引为值是否为空
        MapNode newNode = new MapNode(hash, key, value, null);
        boolean isExist = false;//判断是否存在相同
        if (node == null) {//为空
            table[hash] = newNode;
        } else {
            MapNode temp = null;

            while (node != null) {
                temp = node;//保存node
                if (temp.key.equals(key)) {//是否有key相同的，key相同修改value
                    temp.value = value;
                    isExist = true;
                    break;//跳出循环
                }
                node = node.next;
            }
            if (!isExist)
                temp.next = newNode;//将newNode添加在链表队尾
        }
        if (!isExist)
            size++;
    }


    @Override
    public String toString (){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < table.length; i++) {//遍历数组
            MapNode temp = (MapNode) table[i];

            while (temp != null) {//记录链表中的key，value值
                sb.append(temp.key + "=" + temp.value + ",");
                temp = temp.next;//下一个
            }
        }
        sb.append("]");
        return sb.toString();
    }

    //获取
    public Object get (Object key){
        int hash = myHash(key.hashCode(), table.length);
        MapNode node = (MapNode) table[hash];
        System.out.println(node==table[hash]);

        while (node != null) {
            if (node.key.equals(key)) {
                return node.value;

            }
            node = node.next;
        }
        return null;
    }

//
//    public Object getNode (Object key){
//        int hash = myHash(key.hashCode(), table.length);
//        MapNode node = (MapNode) table[hash];
//        MapNode temp=null;
//
//        while (node != null) {
//
//            if (node.key.equals(key)) {
//                return node;
//
//            }
//            temp=node;
//            node=node.next;
//        }
//        return null;
//    }



//检查索引范围
    public void checkRange(){
          if (size>=(table.length*0.75)){//当
              Object [] newTable=new Object[table.length<<1];
              System.arraycopy(table,0,newTable,0,size);
            table=newTable;

              }
          }

//长度
      public int size(){
        return size;
      }

//移除
      public void remove(Object key){
           int hash=myHash(key.hashCode(),table.length);
           MapNode node=(MapNode)table[hash];


           MapNode temp=null;
           while(node!=null){
               if (node==table[hash]&&node.key.equals(key)){//处理链表头，每个node节点对象的地址是不同的并不是都在一起，
                   table[hash]=node.next;
                   break;
               }
               if (node.key.equals(key)){
                   temp.next=node.next;//因为 头节点处理了，所以temp不会为空，temp为对应key节点的前一个结点。
               }
               temp=node;
               if (temp .next!= null&&temp.next.next==null) {//处理temp.next为空，temp.next.next为空说明temp.next为尾节点
                   if (temp.next.key.equals(key)) {
                       temp.next = null;

                   }
               }
                node=node.next;
      }
//           if (node==null);
          size--;

      }

  //计算hash值
    public int myHash(int hash,int length){
        return hash&(length-1);
    }
}
