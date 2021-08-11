package Threadtest;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Lxml {
    public static void main (String[] args) throws ParserConfigurationException, SAXException, IOException{
       System.out.println(new File("person.xml").exists());
      //工厂类
        SAXParserFactory factory=SAXParserFactory.newInstance();
        //获取对象
        SAXParser sax=factory.newSAXParser();
        //自己编写处理器
        PHander hander=new PHander();
        //读取xml文件
        sax.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("Threadtest/person.xml"),hander);
        List<Person> list=hander.getList();

        for (Person p:list){
            System.out.println(p.toString());
        }
    }
}
class PHander extends DefaultHandler{


    private List<Person> list;
    private Person person;
    private String tag;
    public PHander (){
        super();
    }

    @Override
    public void startDocument () throws SAXException{
        System.out.println("开始");
        list=new ArrayList<Person>();

    }

    @Override
    public void endDocument () throws SAXException{
        System.out.println("结束");
    }

    @Override
    public void startElement (String uri, String localName, String qName, Attributes attributes) throws SAXException{
        if(qName!=null){
            tag=qName;
            if (tag.equals("person")){
                person=new Person();
            }
        }


    }

    @Override
    //结束镖签
    //qName为标签名
    public void endElement (String uri, String localName, String qName) throws SAXException{
        if (qName != null) {//由于重置了tag，所以最后一个标签是为null。所以用qName
            if (qName.equals("person")){
                list.add(person);
                System.out.println(list.size());
            }
        }
//重置tag，因为每个标签结束换行的话，后面的空格也会算作tag标签的内容
// 所以时tagw为null，重置tag
            tag=null;
}

    @Override
    //标签里的内容
public void characters (char[] ch, int start, int length) throws SAXException{
        System.out.println(tag);
        if (tag!=null) {//处理空，因为tag为空，所以后面的内容为空，需要对tag不为空的内容
            if (tag.equals("name")) {
                String content = new String(ch, start, length).trim();//trim方法去除空格
                person.setName(content);
                String s = person.getName();
                System.out.println(s);
            } else if (tag.equals("gender")) {
                String content = new String(ch, start, length).trim();
                person.setGender(content);
            } else if (tag.equals("age")) {
                String content = new String(ch, start, length).trim();
                person.setAge(content);
            }
        }

}
    public List<Person> getList (){
        return list;
    }
}