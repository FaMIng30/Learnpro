package DataStructre;

public class TreeNode <E>{
    private int id;
    private E data;
   private TreeNode left;
    private TreeNode right;

   public TreeNode(){

   }
    public TreeNode(int id,E data,TreeNode left,TreeNode right ){
         this.id=id;
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public int getId (){
        return id;
    }

    public void setId (int id){
        this.id = id;
    }

    public E getData (){
        return data;
    }

    public void setData (E data){
        this.data = data;
    }

    public TreeNode getLeft (){
        return left;
    }

    public void setLeft (TreeNode left){
        this.left = left;
    }

    public TreeNode getRight (){
        return right;
    }

    public void setRight (TreeNode right){
        this.right = right;
    }

    @Override
    public String toString (){
        return "TreeNode{" +
                "data=" + data +
                '}';
    }
    //前序遍历
    public void preOrder(){
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
           this.right.preOrder();
        }
    }
//中序遍历
    public void midOrder(){

        if (this.left != null) {
            this.left.preOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.preOrder();
        }
    }
//后序遍历
    public void afterOrder(){

        if (this.left != null) {
            this.left.preOrder();
        }

        if (this.right != null) {
            this.right.preOrder();
        }
        System.out.println(this);
    }

//前序查找
    public TreeNode<E> search(int id){
        System.out.println("前序遍历查找");
        if (this.id==id){//判断当前节点是否是要找的节点
            return this;
        }
          TreeNode resNode=null;
        if (this.left!=null){
          resNode= this.left.search(id);
        }

        if (resNode!=null)//判断左节点是否找到
            return resNode;

        if (this.right!=null){
            resNode=this.right.search(id);
        }
         return resNode;
    }


//中序遍历
    public TreeNode midSearch(int id){

       TreeNode resNode =null;
       if(this.left!=null){
          resNode= this.left.midSearch(id);
       }

        if (resNode!=null)   //判断作结点是否找到
            return resNode;
        System.out.println("中序遍历查找");
       if (this.id==id){   //判断当前节点是否是要找的节点
           return this;
       }


          if (this.right!=null)
              resNode= this.right.midSearch(id);

          return resNode;
    }

//后序遍历
    public TreeNode afterSearch(int id){
       TreeNode resNode=null;
       if (this.left!=null){
           resNode=this.left.afterSearch(id);
       }
       if (resNode!=null)//判断左节点是否找到
           return resNode;

       if (this.right!=null)
           resNode= this.right.afterSearch(id);

       if (resNode!=null)//判断右节点是否找到
           return resNode;
        System.out.println("后序遍历查找");
       if(this.id==id)//判断当前节点是否为要找到的节点
           return this;


       return resNode;
    }
//这里的删除时如果寻找的节点时叶子节点则让其父节点的左（右）置为空
//如果不是叶子节点 则将把该子树删除
    public void del(int id){
       //判断当前的做节点是否是要找的节点
       if (this.left!=null&&this.left.id==id){
           this.left=null;
           return;
       }
       if (this.right!=null&&this.right.id==id){
           this.right=null;
           return;
       }
       //递归寻找删除节点
       if (this.left!=null){
           this.left.del(id);
       }
       if (this.right!=null){
           this.right.del(id);
       }
    }

}
