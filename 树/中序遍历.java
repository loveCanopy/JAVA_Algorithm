/** 
     * 中序遍历递归解法  
     * （1）如果二叉树为空，空操作。  
     * （2）如果二叉树不为空，中序遍历左子树，访问根节点，中序遍历右子树 
     */ 
    public static void inorderTraversalRec(TreeNode root) {  
        if (root == null) {  
            return;  
        }  
        inorderTraversalRec(root.left);  
        System.out.print(root.val + " ");  
        inorderTraversalRec(root.right);  
    }  
       
    /** 
     * 中序遍历迭代解法 ，用栈先把根节点的所有左孩子都添加到栈内， 
     * 然后输出栈顶元素，再处理栈顶元素的右子树 
     * http://www.youtube.com/watch?v=50v1sJkjxoc 
     */ 
    public static void inorderTraversal(TreeNode root){  
        if(root == null){  
            return;  
        }  
        Stack<TreeNode> stack = new Stack<TreeNode>();  
        TreeNode cur = root;  
           
        while( true ){  
            while(cur != null){     // 先添加一个非空节点所有的左孩子到栈  
                stack.push(cur);  
                cur = cur.left;  
            }  
               
            if(stack.isEmpty()){  
                break;  
            }  
                   
            // 因为此时已经没有左孩子了，所以输出栈顶元素  
            cur = stack.pop();  
            System.out.print(cur.val + " ");  
            cur = cur.right;    // 准备处理右子树  
        }  
    }  
   