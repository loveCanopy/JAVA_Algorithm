
public class IsBinTreePostTraverse{
	
	static boolean isBSTPostOrder(int[] a){
		if(a==null){
			return false;
		}
		/*1.只有一个结点时，肯定是查找树
		 *2.只有两个结点时，肯定是查找树。例如{5,6}对应的BST是   6		{6,5}对应的BST是	5
		 *							   					/						 \
		 *											   5 						  6	
		 */
		if(a.length<=2){
			return true;
		}
		//多于三个结点，则递归判断
		return isBSTPostOrderHelper(a,0,a.length-1);
		
		
	}
	
	static boolean isBSTPostOrderHelper(int[] a,int s,int e){
		int len=a.length;
		if(!(s>=0&&s<len&&e>=0&&e<len)){//检查下标是否合法
			return false;
		}
		if(s==e||s==e-1){
			return true;
		}
		int i=e-1;
		while(a[i]>a[e])i--;//直到a[i]是e的左孩子
		if(s<=i&&i<e){
			boolean firstPart=isBSTPostOrderHelper(a,s,i);
			boolean secondPart=isBSTPostOrderHelper(a,i+1,e-1);
			return firstPart&&secondPart;
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[][] a= {
				{5,7,6,9,11,10,8},
				{5,6,7},
				{5,7,6},
				{1,3,2,5,7,6,4,9,11,10,13,15,14,12,8},
		};
		for(int[] each:a){
			boolean re=isBSTPostOrder(each);
			System.out.println(re);
		}
	}
}

