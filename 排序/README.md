![](排序.png)

[快速排序](#page1)
[归并排序](#page2)
[shell排序](#page3)
[基数排序](#page4)
[堆排序](#page5)
# <h2 id="page1">快速排序</h2>
http://blog.csdn.net/morewindows/article/details/6684558

该方法的基本思想是：
1．先从数列中取出一个数作为基准数。
2．分区过程，将比这个数大的数全放到它的右边，小于或等于它的数全放到它的左边。
3．再对左右区间重复第二步，直到各区间只有一个数。
虽然快速排序称为分治法，但分治法这三个字显然无法很好的概括快速排序的全部步骤。因此我的对快速排序作了进一步的说明：挖坑填数+分治法
```
   int i = l, j = r;  
    int x = s[l]; //s[l]即s[i]就是第一个坑  
    while (i < j)  
    {  
        // 从右向左找小于x的数来填s[i]  
        while(i < j && s[j] >= x)   
            j--;    
        if(i < j)   
        {  
            s[i] = s[j]; //将s[j]填到s[i]中，s[j]就形成了一个新的坑  
            i++;  
        }  
  
        // 从左向右找大于或等于x的数来填s[j]  
        while(i < j && s[i] < x)  
            i++;    
        if(i < j)   
        {  
            s[j] = s[i]; //将s[i]填到s[j]中，s[i]就形成了一个新的坑  
            j--;  
        }  
    }  
    //退出时，i等于j。将x填到这个坑中。  
    s[i] = x;  
      quick_sort(s, l, i - 1); // 递归调用   
        quick_sort(s, i + 1, r);
   
```
# <h2 id="page2">归并排序</h2>

http://blog.csdn.net/morewindows/article/details/6678165/

# <h2 id="page3">shell排序</h2>

http://blog.csdn.net/jianyuerensheng/article/details/51258460

代码和直接插入代码比对
```
直接插入

	int j;
	for(j=1;j<a.length;j++){
                        int temp=a[j];
			int i;
			for(i=j-1;i>=0;i--){
				if(a[i]>temp){
					a[i+1]=a[i];
				}
				else{
					break;
				}
			}
			a[i+1]=temp;
		}

shell排序
          for (int i = increment; i < data.length; i++) {
                temp = data[i];
                for (j = i - increment; j >= 0; j -= increment) {
                    if (temp < data[j]) {
                        data[j + increment] = data[j];
                    } else {
                        break;
                    }
                }
                data[j + increment] = temp;



```
# <h2 id="page4">基数排序</h2>

https://baike.baidu.com/item/%E5%9F%BA%E6%95%B0%E6%8E%92%E5%BA%8F/7875498?fr=aladdin
```
每位可能的取值情况为0-9  建立十个队列
List<ArrayList> queue=new ArrayList<>();
		for(int i=0;i<10;i++){
			ArrayList<Integer> queue_1=new ArrayList<>();
			queue.add(queue_1);
		}

//分配
		for(int i=0;i<times;i++){
			for(int j=0;j<a.length;j++){
				int num=a[j]%(int)Math.pow(10, i+1)/(int)Math.pow(10, i);
				ArrayList queue_2=queue.get(num);
				queue_2.add(a[j]);
				queue.set(num, queue_2);
			}
			
			int count=0;
			for(int j=0;j<10;j++){
				while(queue.get(j).size()>0){
					ArrayList temp=queue.get(j);
					a[count]=(int) temp.get(0);
					temp.remove(0);
					count++;
				}				

```
# <h2 id="page5">堆排序</h2>

http://blog.csdn.net/morewindows/article/details/6709644/

首先参考堆的插入操作
```
void MinHeapFixup(int a[], int i)  
	{  
	    int j, temp;  
	    temp = a[i];  
	    j = (i - 1) / 2;      //父结点  
	    while (j >= 0 && i != 0)  
	    {  
	        if (a[j] <= temp)  
	            break;  
	          
	        a[i] = a[j];     //把较大的子结点往下移动,替换它的子结点  
	        i = j;  
	        j = (i - 1) / 2;  
	    }  
	    a[i] = temp;  
	}  


```
堆排序

第一次将A[0]与A[n - 1]交换，再对A[0…n-2]重新恢复堆。第二次将A[0]与A[n  2]交换，再对A[0…n - 3]重新恢复堆，重复这样的操作直到A[0]与A[1]交换。
```
public static int[] duiSort(int[] a){
		for(int i=a.length-1;i>0;i--){
			Swap(a[i],a[0]);
			minHeapFix(a, 0, i);
		}
		return a;
	}
	public static void Swap(int a,int b){
		int temp=a;
		a=b;
		b=temp;
	}
	
	//i为待调整的第i个节点  n为节点总数       在左右节点中找最小的  和父节点对换
	public static void minHeapFix(int[]a ,int i,int n){
		int j, temp;  
	    temp = a[i];  
	    j = 2 * i + 1;  
	    while (j < n)  
	    {  
	        if (j + 1 < n && a[j + 1] < a[j]) //在左右孩子中找最小的  
	            j++;  
	  
	        if (a[j] >= temp)  
	            break;  
	  
	        a[i] = a[j];     //把较小的子结点往上移动,替换它的父结点  
	        i = j;  
	        j = 2 * i + 1;  
	    }  
	    a[i] = temp;  
		
		
	}


```
