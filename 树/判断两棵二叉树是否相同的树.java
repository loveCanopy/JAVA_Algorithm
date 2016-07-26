 /** 
     * 判断两棵二叉树是否相同的树。 
     * 递归解法：  
     * （1）如果两棵二叉树都为空，返回真 
     * （2）如果两棵二叉树一棵为空，另一棵不为空，返回假  
     * （3）如果两棵二叉树都不为空，如果对应的左子树和右子树都同构返回真，其他返回假 
     */ 
    public static boolean isSameRec(TreeNode r1, TreeNode r2) {  
        // 如果两棵二叉树都为空，返回真  
        if (r1 == null && r2 == null) {  
            return true;  
        }  
        // 如果两棵二叉树一棵为空，另一棵不为空，返回假  
        else if (r1 == null || r2 == null) {  
            return false;  
        }  
   
        if(r1.val != r2.val){  
            return false;  
        }  
        boolean leftRes = isSameRec(r1.left, r2.left);      // 比较对应左子树  
        boolean rightRes = isSameRec(r1.right, r2.right); // 比较对应右子树  
        return leftRes && rightRes;  
    }  
       
    /** 
     * 判断两棵二叉树是否相同的树（迭代） 
     * 遍历一遍即可，这里用preorder 
     */ 
    public static boolean isSame(TreeNode r1, TreeNode r2) {  
        // 如果两个树都是空树，则返回true  
        if(r1==null && r2==null){  
            return true;  
        }  
           
        // 如果有一棵树是空树，另一颗不是，则返回false  
        if(r1==null || r2==null){  
            return false;  
        }  
           
        Stack<TreeNode> s1 = new Stack<TreeNode>();  
        Stack<TreeNode> s2 = new Stack<TreeNode>();  
           
        s1.push(r1);  
        s2.push(r2);  
           
        while(!s1.isEmpty() && !s2.isEmpty()){  
            TreeNode n1 = s1.pop();  
            TreeNode n2 = s2.pop();  
            if(n1==null && n2==null){  
                continue;  
            }else if(n1!=null && n2!=null && n1.val==n2.val){  
                s1.push(n1.right);  
                s1.push(n1.left);  
                s2.push(n2.right);  
                s2.push(n2.left);  
            }else{  
                return false;  
            }  
        }  
        return true;  
    }  
   