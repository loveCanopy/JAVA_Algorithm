/** 
     * 求二叉树中叶子节点的个数（递归） 
     */ 
    public static int getNodeNumLeafRec(TreeNode root) {  
        // 当root不存在，返回空  
        if (root == null) {  
            return 0;  
        }  
   
        // 当为叶子节点时返回1  
        if (root.left == null && root.right == null) {  
            return 1;  
        }  
   
        // 把一个树拆成左子树和右子树之和，原理同上一题  
        return getNodeNumLeafRec(root.left) + getNodeNumLeafRec(root.right);  
    }  
       
    /** 
     *  求二叉树中叶子节点的个数（迭代） 
     *  还是基于Level order traversal 
     */ 
    public static int getNodeNumLeaf(TreeNode root) {  
        if(root == null){  
            return 0;  
        }  
        Queue<TreeNode> queue = new LinkedList<TreeNode>();  
        queue.add(root);  
           
        int leafNodes = 0;              // 记录上一个Level，node的数量  
           
        while( !queue.isEmpty() ){  
            TreeNode cur = queue.remove();      // 从队头位置移除  
            if(cur.left != null){               // 如果有左孩子，加到队尾  
                queue.add(cur.left);  
            }  
            if(cur.right != null){              // 如果有右孩子，加到队尾  
                queue.add(cur.right);  
            }  
            if(cur.left==null && cur.right==null){          // 叶子节点  
                leafNodes++;  
            }  
        }  
           
        return leafNodes;  
    }  