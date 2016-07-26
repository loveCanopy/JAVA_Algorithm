/** 
     * 后序遍历递归解法  
     * （1）如果二叉树为空，空操作  
     * （2）如果二叉树不为空，后序遍历左子树，后序遍历右子树，访问根节点 
     */ 
    public static void postorderTraversalRec(TreeNode root) {  
        if (root == null) {  
            return;  
        }  
        postorderTraversalRec(root.left);  
        postorderTraversalRec(root.right);  
        System.out.print(root.val + " ");  
    }  
       
    /** 
     *  后序遍历迭代解法 
     *  http://www.youtube.com/watch?v=hv-mJUs5mvU 
     *   
     */ 
    public static void postorderTraversal(TreeNode root) {  
        if (root == null) {  
            return;  
        }  
           
        Stack<TreeNode> s = new Stack<TreeNode>();      // 第一个stack用于添加node和它的左右孩子  
        Stack<TreeNode> output = new Stack<TreeNode>();// 第二个stack用于翻转第一个stack输出  
           
        s.push(root);  
        while( !s.isEmpty() ){      // 确保所有元素都被翻转转移到第二个stack  
            TreeNode cur = s.pop(); // 把栈顶元素添加到第二个stack  
            output.push(cur);         
               
            if(cur.left != null){       // 把栈顶元素的左孩子和右孩子分别添加入第一个stack  
                s.push(cur.left);  
            }  
            if(cur.right != null){  
                s.push(cur.right);  
            }  
        }  
           
        while( !output.isEmpty() ){ // 遍历输出第二个stack，即为后序遍历  
            System.out.print(output.pop().val + " ");  
        }  
    }  