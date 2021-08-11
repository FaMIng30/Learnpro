package DataStructre;

import org.junit.Test;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class reflectionss {

    @Test
    public void Construction () throws Exception{
        //获取class对象的三种方式
        //Person p=new Person（）；
        //Class c=p.getclass()对象.getclass()
        //Class c=类.class
        Class<?> clazz = Class.forName("DataStructre.Users");
        Constructor constructor = clazz.getConstructor(String.class, int.class, String.class);
        Constructor[] constructorss = clazz.getConstructors();
        for (Constructor c : constructorss)
            System.out.println(c);
        Users users = (Users) constructor.newInstance("小王", 18, "男");
        System.out.println(users.getAge());
        System.out.println(users.getGender());
        System.out.println(users.getName());
    }

    @Test
    public void method () throws Exception{
        Class clazz = Class.forName("DataStructre.Users");
        Method[] m = clazz.getDeclaredMethods();
        for (Method mm : m)
            System.out.println(mm);
        Method me = clazz.getMethod("setName", String.class);
        Method me1 = clazz.getMethod("getName");
        me1.setAccessible(true);
        Users us = (Users) clazz.newInstance();

        me.invoke(us, "小明");

        System.out.println(me1.invoke(us));

    }

    @Test
    public void Filed () throws Exception{
        Class<Users> clazz = (Class<Users>) Class.forName("DataStructre.Users");



        Field [] fileds=clazz.getDeclaredFields();
        for(Field f:fileds) {
            System.out.println(f);
            Annotation [] ass=f.getAnnotations();
            for (Annotation as : ass) {
                System.out.println(as);
              
            }
        }
        Field f=clazz.getDeclaredField("name");


    }

    @Test
    public void anotation() throws ClassNotFoundException{
        Class clazz=Class.forName("DataStructre.Users");
        Annotation [] a=clazz.getAnnotations();
        for (Annotation aa:a)
            System.out.println(aa);
    }
}
