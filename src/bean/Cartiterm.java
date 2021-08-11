package bean;

import java.math.BigDecimal;

public class Cartiterm {
    private Integer ID;
    private String itermname;//名字
    private Integer itermcounts;//数量
    private BigDecimal price;//单价
    private BigDecimal Totalprice;//总价

    public Cartiterm (){

    }

    public Cartiterm (Integer ID, String itermname, Integer itermcounts, BigDecimal price, BigDecimal totalprice){
        this.ID = ID;
        this.itermname = itermname;
        this.itermcounts = itermcounts;
        this.price = price;
        Totalprice = totalprice;
    }

    public BigDecimal getTotalprice (){
        return Totalprice;
    }

    public void setTotalprice (BigDecimal totalprice){
        Totalprice = totalprice;
    }

    @Override
    public String toString (){
        return "Cartiterm{" +
                "ID=" + ID +
                ", itermname='" + itermname + '\'' +
                ", itermcounts=" + itermcounts +
                ", price=" + price +
                ", Totalprice=" + Totalprice +
                '}';
    }

    public Integer getID (){
        return ID;
    }

    public void setID (Integer ID){
        this.ID = ID;
    }

    public String getItermname (){
        return itermname;
    }

    public void setItermname (String itermname){
        this.itermname = itermname;
    }

    public Integer getItermcounts (){
        return itermcounts;
    }

    public void setItermcounts (Integer itermcounts){
        this.itermcounts = itermcounts;
    }

    public BigDecimal getPrice (){
        return price;
    }

    public void setPrice (BigDecimal price){
        this.price = price;
    }
}