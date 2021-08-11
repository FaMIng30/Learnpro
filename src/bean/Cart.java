package bean;

import interfaces.Carts;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public class Cart implements Carts {
  private   BigDecimal totalPrice; //总价 el表达式中有没有带没区别，只要有相应的get方法就行
    private int itermtotalCount;//商品总数
    private Map<Integer, Cartiterm> cartiterm = new LinkedHashMap<>();//商品


    @Override
    public String  toString (){
        return "Cart{" +
                " itermtotalCount=" + itermtotalCount +
                ", cartiterm=" + cartiterm +
                '}';
    }



    public void setItermtotalCount (int itermtotalCount){
        this.itermtotalCount = itermtotalCount;
    }

    public Map<Integer, Cartiterm> getCartiterm (){
        return cartiterm;
    }

    public void setCartiterm (Map<Integer, Cartiterm> cartiterm){
        this.cartiterm = cartiterm;
    }
//购物车总价格
//    EL表达式会根据name去User类里寻找这个name的get方法，此时会自动把name首字母大写并加上get前缀，
//    一旦找到与之匹配的方法，El表达式就会认为这就是要访问的属性，并返回属性的值。
    public BigDecimal getTotalPrice (){
         totalPrice=new BigDecimal(0);
        for(Cartiterm carti:cartiterm.values()){
           totalPrice=totalPrice.add(carti.getTotalprice());
        }
        return totalPrice;
    }
//购物车商品总数
    public int getItermtotalCount(){
      int  itermtotalCount=0;
      for(Cartiterm carti:cartiterm.values()){
          itermtotalCount+=carti.getItermcounts();
      }
        return itermtotalCount;
    }


//删除商品
    @Override
    public void delIterm (Integer ID){
        cartiterm.remove(ID);

    }
//添加商品
    @Override
    public void addIterm (Cartiterm iterms){
        //判断是否有这样东西；有，数量的叠加。无，加入到购物车中
        Cartiterm iterm = cartiterm.get(iterms.getID());
        if (iterm == null) {//没有该物品
            cartiterm.put(iterms.getID(), iterms);
        } else {
            iterm.setItermcounts(iterm.getItermcounts() + 1);//数量加1
            iterm.setTotalprice(iterm.getPrice().multiply(new BigDecimal(iterm.getItermcounts())));//单价*数量
        }
    }
 //修改商品数量
    @Override
    public void updateCount (Integer ID, Integer itermcounts){
        Cartiterm cartiterms = cartiterm.get(ID);
        if (cartiterms != null) {
            cartiterms.setItermcounts(itermcounts);
            cartiterms.setTotalprice(cartiterms.getPrice().multiply(new BigDecimal(cartiterms.getItermcounts())));
        }
    }
    //清空购物车
    public void clear (){
        cartiterm.clear();
    }
}
