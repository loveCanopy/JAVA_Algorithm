先取一个小于n的整数d1作为第一个增量，把文件的全部记录分成d1个组。所有距离为d1的倍数的记录放在同一个组中
。先在各组内进行直接插入排序；然后，取第二个增量d2<d1重复上述的分组和排序，直至所取的增量dt=1(dt<dt-l<…<d2<d1)，
即所有记录放在
同一组中进行直接插入排序为止。该方法实质上是一种分组插入方法
package com.sort;

//不稳定
public class 希尔排序 {

    
    public static void main(String[] args) {
        int[] a={49,38,65,97,76,13,27,49,78,34,12,64,1};
        System.out.println("排序之前：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        //希尔排序
        int d = a.length;
        while(true){
            d = d / 2;
            for(int x=0;x<d;x++){
                for(int i=x+d;i<a.length;i=i+d){
                    int temp = a[i];
                    int j;
                    for(j=i-d;j>=0&&a[j]>temp;j=j-d){
                        a[j+d] = a[j];
                    }
                    a[j+d] = temp;
                }
            }
            if(d == 1){
                break;
            }
        }
        System.out.println();
        System.out.println("排序之后：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }

}