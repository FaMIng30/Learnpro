package DataStructre;

public class Treess<E> {
    TreeNode root;

    public  void setRoot(TreeNode root){
       this.root=root;
    }
    public Treess(){
        this.root=null;
    }
//前序遍历
    public void preOrder(){
        if (this.root!=null){
            this.root.preOrder();
        }else{
            System.out.println("树是空的");
        }
    }
//中序遍历
    public void midOrder(){
        if (this.root!=null){
            this.root.midOrder();
        }else{
            System.out.println("树是空的");
        }
    }
//后序遍历
    public void afterOrder(){
        if (this.root!=null){
            this.root.afterOrder();
        }else{
            System.out.println("树是空的");
        }
    }
  //先序遍历查找
    public TreeNode preSearch(int id){

        if (this.root!=null){
          return this.root.search(id);
        }else {
            System.out.println("二叉树为空");
        }
        return null;
    }


    //中序遍历查找
    public TreeNode midSearch(int id){

        if (this.root!=null){
            return this.root.midSearch(id);
        }else {
            System.out.println("二叉树为空");
        }
        return null;
    }


    public TreeNode afterSearch(int id){
        if (this.root!=null){
           return this.root.afterSearch(id);
        }else {
            System.out.println("二叉树为空");
        }
        return null;
    }


    public void del(int id){
        if (this.root!=null){
            if (this.root.getId()==id){
                this.root=null;
            }else{
                this.root.del(id);
            }
        }else{
            System.out.println("二叉树为空");
        }
    }
}
