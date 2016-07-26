 /** 
     * 前序遍历，中序遍历，后序遍历 前序遍历递归解法：  
     * （1）如果二叉树为空，空操作  
     * （2）如果二叉树不为空，访问根节点，前序遍历左子树，前序遍历右子树 
     */ 
    public static void preorderTraversalRec(TreeNode root) {  
        if (root == null) {  
            return;  
        }  
        System.out.print(root.val + " ");  
        preorderTraversalRec(root.left);  
        preorderTraversalRec(root.right);  
    }  
       
    /** 
     *  前序遍历迭代解法：用一个辅助stack，总是把右孩子放进栈 
     *  http://www.youtube.com/watch?v=uPTCbdHSFg4 
     */ 
    public static void preorderTraversal(TreeNode root) {  
        if(root == null){  
            return;  
        }  
           
        Stack<TreeNode> stack = new Stack<TreeNode>();      // 辅助stack  
        stack.push(root);  
           
        while( !stack.isEmpty() ){  
            TreeNode cur = stack.pop();     // 出栈栈顶元素  
            System.out.print(cur.val + " ");  
               
            // 关键点：要先压入右孩子，再压入左孩子，这样在出栈时会先打印左孩子再打印右孩子  
            if(cur.right != null){  
                stack.push(cur.right);  
            }  
            if(cur.left != null){  
                stack.push(cur.left);  
            }  
        }  
    }  