package DataStructre;

import java.util.Date;

public class Sorts {
    public static void main (String[] args){
//        int[] arr = new int[80000];
//        for (int i = 0; i < 80000; i++) {
//            arr[i] = (int) (Math.random() * 10000);
//        }
           int [] arr={323,21,14,76,822,93,10};
        int r = arr.length - 1;
        System.out.println("长度" + r);
        int[] temp=new int[arr.length];
        long start = System.currentTimeMillis();
       jishuSort(arr);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
       for (int a:arr)
           System.out.println("值"+a);
    }

    //冒泡
    public static void buble(int [] arr){


        int temp=0;
        boolean isokay=true;
        for (int i=0;i<arr.length-1 ;i++){// 排数组长度-1次
            isokay=true;
            for (int j=0;j<arr.length-1-i;j++){//循环数组长度-1次再减已经排好的个数
                if(arr[j]>arr[j+1]){//如果前一个大于后一个，进行交换
                    temp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                    isokay=false;
                }
            }
            if (isokay)
                break;
        }

    }

//选择排序
    public static void select(int[] arr){
        for (int i=0;i<arr.length-1;i++){
            int min=arr[i]; //记录第一个元素值
            int index=i;//第一个索引
            for (int j= i+1;j<arr.length ;j++){ //从第i+1个元素开始往后找，与第i个相比最小的
                if (arr[j]<min){
                    min=arr[j];//找到最小值
                    index=j;//记录最小值索引
                }
            }
            arr[index]=arr[i];//交换
            arr[i]=min;
        }
         }

//插入排序
    public static void insert(int []arr){//[1,3,4] [2]-->1 3 4 4 -->  1 3 3 4  -->   1 2 3 4
        for (int i=1;i<arr.length;i++){
            int val=arr[i];//需要插入的值
            int index=i-1;//比较的值的索引
            while(index >=0&&arr[index]>val){
                 arr[index+1]=arr[index];//覆盖掉下一个值 如上例
                 index--;
            }
            arr[index+1]=val;//找到位置改为插入值
        }
         }

//4, 2, 6, 3, 9-->42369
    //快排   挖坑法
    public  static void quick(int [] arr,int left,int right){
        if (left < right) {
        int base = arr[left];
        int l = left;
        int r = right;
        int tmp = 0;
            while (l != r) {

                while (arr[r] > base && l < r) {
                    r--;
                }
                if (l < r)
                    arr[l++] = arr[r];
                while (arr[l] < base && l < r) {
                    l++;
                }
                if (l < r)
                    arr[r--] = arr[l];
            }
            arr[l] = base;
            quick(arr, left, l - 1);
            quick(arr, l + 1, right);
        }

    }
//快速排序    交换法
    public static  void quck(int [] arr,int left,int right){
        int head=left;//保存开头
        int end=right;//保存末尾,保存开头和末尾是为了后面递归用的，需要传入前后两段的开头结尾
        if(left>=right) {
            return;//递归出口,前后指针相遇
        }

        int key=arr[left];//保存左边开头，这也是为什么需要首先从右往左遍历指针

        while(left<right) {
            //注意：这里必须先从右向左
            while(arr[right]>=key&&left<right) {
                right--;//右指针遇到小于key的停下
            }
            while(arr[left]<=key&&left<right) {
                left++;//左指针遇到大于key的停下
            }
            //交换左右
            int temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
        }
        arr[head]=arr[left];
        arr[left]=key;
        quck(arr,head,left-1);
        quck(arr,right+1,end);



    }

    //希尔排序
    public static void shell(int []arr){
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {//分组
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int tmp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while ((j - gap) >= 0 && tmp < arr[j - gap]) {
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    arr[j] = tmp;
                }

            }
        }
    }
    //分
    public static void mergeSort(int arr[],int left,int right,int []temp){
        if (left<right) {
            int mid = (left + right) / 2;
            mergeSort(arr,left,mid,temp);
            mergeSort(arr,mid+1,right,temp);
            merge(arr,left,mid,right,temp);

        }

               }
               //归并排序   合
    public static  void merge(int []arr, int left ,int mid,int right,int [] temp){
//        System.out.println("l的值为"+left);
        int l=left;
         int tempc=0;
        int rcur=mid+1;
//左边与右边的数进行比较，小的值房临时数组中
        while(l<=mid&&rcur<=right){
            if (arr[l]<=arr[rcur]){
                temp[tempc]=arr[l];
                l++;
                tempc++;
            }else {
                temp[tempc]=arr[rcur];
                rcur++;
                tempc++;
            }
        }
        //如果左边有剩余，将剩余复制到temp后面
        while(l<=mid){
                temp[tempc]=arr[l];
                tempc++;
                l++;
            }
        //如果右边有剩余，将剩余复制到temp后面
        while(rcur<=right){
            temp[tempc]=arr[rcur];
            rcur++;
            tempc++;
        }

        rcur=0;
        int templeft=left;
        while(templeft<=right){
            arr[templeft]=temp[rcur];
            rcur++;
            templeft++;

        }
    }
    //基数排序  几轮的次数取决于最大的是几位数
    public static void jishuSort(int [] arr){
       int  temp=arr[0];
        for(int i=0 ; i<arr.length ; i++){
            if (arr[i]>temp)
                temp=arr[i];
            }
        int maxlen=(temp+"").length();//最大值的位数

        int [][] bucket= new int[10][arr.length];//10个余数的桶，最坏情况每个桶的大小都等于原数组大小
        int [] count=new int[10];//用于记录每个桶的个数，即：count[0]=34 即尾数为0的同有24个元素
    //按尾数放入不同的桶
     for (int l=0,n=1;l<maxlen;l++,n*=10) {
         for (int i = 0; i < arr.length; i++) {
             int yushu = (arr[i] / n) % 10;
             bucket[yushu][count[yushu]] = arr[i];
             count[yushu]++;
         }
         //从桶中一次取出放回原数组
         int len = 0;
         for (int j = 0; j < bucket.length; j++) {
             if (count[j] != 0) {
                 for (int k = 0; k < count[j]; k++)
                     arr[len++] = bucket[j][k];
             }
             count[j] = 0;
         }
     }

    }

}
