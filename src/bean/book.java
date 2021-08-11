package bean;

import java.math.BigDecimal;

public class book {
    private int ID;
    private String name;
    private String author;
    private  String descrip;
    private BigDecimal price;
    private String bookpath;



    public book(){}
    @Override
    public String toString (){
        return "book{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", descrip='" + descrip + '\'' +
                ", price=" + price +
                ", bookpath='" + bookpath + '\'' +
                '}';
    }

    public String getBookpath (){
        return bookpath;
    }

    public void setBookpath (String bookpath){
        this.bookpath = bookpath;
    }

    public BigDecimal getPrice (){
        return price;
    }

    public void setPrice (BigDecimal price){
        this.price = price;
    }

    public int getID (){
        return ID;
    }

    public void setID (int ID){
        this.ID = ID;
    }

    public String getName (){
        return name;
    }

    public void setName (String name){
        this.name = name;
    }

    public String getAuthor (){
        return author;
    }

    public void setAuthor (String author){
        this.author = author;
    }

    public String getDescrip (){
        return descrip;
    }

    public void setDescrip (String descrip){
        this.descrip = descrip;
    }
}
