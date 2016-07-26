假设有两个从小到大的有序数组A和B，他们的元素个数为N和M，那么怎么求得其第K大元素呢？同理，求其中位数就是
当N+M为奇数求其第(N+M+1)/2大元素，为偶数时求(N+M)/2和(N+M+2)/2大元素的平均值。
那么我们怎么才能求得第K大元素呢？
分别取两个数组中间索引的数，a[x]和b[y]，比较两个数的大小：

if( a[x] <= a[y] )

如果x+y>k，则可以判断出b[y]以及b[y]后面的元素都可以排除在外，减小搜索规模。

如果x+y<=k，则可以判断出a数组的前半部分元素都不符合条件，减少a一半的搜索规模。

if( a[x] > a[y] )
类似

该算法利用了递归的思想，结束条件是：

a中元素排除出去，则选择b中得第k大元素；

b中元素全部排除，选择a中第k大元素。

该算法的思想简单，但边界点的情况要考虑清楚。结合具体的示例，减小搜索范围时，采取去掉了b[y]和a[x]；结合具体的示例，
结束递归的条件是当a或b中开始位置大于结束位置。
package com.agorithm;

import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		int i,n,m;
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		int[] arrA=new int[n+1];
		int[] arrB=new int[m+1];
		for(i=1;i<=n;i++){
			arrA[i]=sc.nextInt();
		}
		for(i=1;i<=m;i++){
			arrB[i]=sc.nextInt();
		}
		double median=-1;
		if((n+m)%2==0){
			int t1=getTopK(arrA,1,n,arrB,1,m,(m+n)/2);
			int t2=getTopK(arrA,1,n,arrB,1,m,(m+n+2)/2);
			median=(t1+t2)*1.0/2;
		}
		else{
			median=getTopK(arrA,1,n,arrB,1,m,(m+n+1)/2);
		}
		System.out.println(median);
	}
	//数组A，A的开始位置，结束位置，数组B，B的开始位置，结束位置，第K大元素
	private static int getTopK(int[] arrA, int sa, int ea, int[] arrB, int sb,
			int eb, int k) {
		int ma=(sa+ea)/2;
		int mb=(sb+eb)/2;
		if(sa>ea){
			return arrB[sb+k-1];
		}
		if(sb>eb){
			return arrA[sa+k-1];
		}
		if(arrA[ma]>=arrB[mb]){
			if((ma-sa+1)+(mb-sb+1)>k){
				return getTopK(arrA,sa,ma-1,arrB,sb,eb,k);
			}
			else{
				return getTopK(arrA,sa,ea,arrB,mb+1,eb,k-(mb+1-sb));
			}
		}
		else{
			if((ma-sa+1)+(mb-sb+1)>k){
				return getTopK(arrA,sa,ea,arrB,sb,mb-1,k);
			}
			else{
				return getTopK(arrA,ma+1,ea,arrB,sb,eb,k-(ma+1-sa));
			}
		}
	}
}
