package Threadtest;

public class Breads {
    static  int  count = 0;
    static int buffer = 50;
    boolean isEmpty = true;


    public static synchronized   void putBread (){

        count++;
        System.out.println("生产了第" + count + "面包");
    }

    public static synchronized   void consume (){

        count--;
        System.out.println("消耗了一个面包" + "------剩余" + count + "个面包");
    }

    static class Producer implements Runnable {
        private Breads breads;

        public Producer (Breads breads){
            this.breads = breads;

        }

        @Override
        public  void run (){
            while (true) {
                if (count < buffer)
                    putBread();
//                 if (count==50){
//                    Thread.currentThread().yield();
//                 }
            }

        }

    }

    static class Custom implements Runnable {
        private Breads breads;

        public Custom (Breads breads){
            this.breads = breads;
        }

        @Override
        public  void run (){
            while (true) {
                if (count > 0){
                    consume();}
//                if (count==0){
//                    Thread.currentThread().yield();
//                }
            }
        }
    }
}