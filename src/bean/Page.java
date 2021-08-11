package bean;

import com.alibaba.druid.support.json.JSONUtils;
import org.w3c.dom.ls.LSOutput;

import java.util.List;

public class Page<T> {
    public static final Integer PAGE_SIZE=4;
    private Integer pageNo;//当前页码
    private Integer pageTotal;//总页码
    private Integer pagesize=PAGE_SIZE;//一页显示数量
    private Integer pagecount;//总记录数
    private List<T> pageitem;//商品项
    private String url;

    public String getUrl (){
        return url;
    }

    public void setUrl (String url){
        this.url = url;
    }

    @Override
    public String toString (){
        return "Page{" +
                "pageNo=" + pageNo +
                ", pageTotal=" + pageTotal +
                ", pagesize=" + pagesize +
                ", pagecount=" + pagecount +
                ", pageitem=" + pageitem +
                ", url='" + url + '\'' +
                '}';
    }

    public static Integer getPageSize (){
        return PAGE_SIZE;
    }

    public Integer getPageNo (){
        return pageNo;
    }
//检查是否越界，防止在地址栏输入导致无数据
    public void setPageNo (Integer pageNo){
        //边界值检查
         if(pageNo<1)
             pageNo=1;
         if (pageNo>pageTotal)
             pageNo=pageTotal;
        this.pageNo = pageNo;
    }

    public Integer getPageTotal (){
        return pageTotal;
    }

    public void setPageTotal (Integer pageTotal){
        this.pageTotal = pageTotal;
    }

    public Integer getPagesize (){
        return pagesize;
    }

    public void setPagesize (Integer pagesize){
        this.pagesize = pagesize;
    }

    public Integer getPagecount (){
        return pagecount;
    }

    public void setPagecount (Integer pagecount){
        this.pagecount = pagecount;
    }

    public List<T> getPageitem (){
        return pageitem;
    }

    public void setPageitem (List<T> pageitem){
        this.pageitem = pageitem;
    }
}
