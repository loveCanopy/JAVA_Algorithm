 /** 
     * 求二叉树第K层的节点个数   递归解法：  
     * （1）如果二叉树为空或者k<1返回0 
     * （2）如果二叉树不为空并且k==1，返回1 
     * （3）如果二叉树不为空且k>1，返回root左子树中k-1层的节点个数与root右子树k-1层节点个数之和 
     *  
     * 求以root为根的k层节点数目 等价于 求以root左孩子为根的k-1层（因为少了root那一层）节点数目 加上 
     * 以root右孩子为根的k-1层（因为少了root那一层）节点数目 
     *  
     * 所以遇到树，先把它拆成左子树和右子树，把问题降解 
     *  
     */ 
    public static int getNodeNumKthLevelRec(TreeNode root, int k) {  
        if (root == null || k < 1) {  
            return 0;  
        }  
   
        if (k == 1) {  
            return 1;  
        }  
        int numLeft = getNodeNumKthLevelRec(root.left, k - 1);      // 求root左子树的k-1层节点数  
        int numRight = getNodeNumKthLevelRec(root.right, k - 1);    // 求root右子树的k-1层节点数  
        return numLeft + numRight;  
    }  
       
    /** 
     *  求二叉树第K层的节点个数   迭代解法：  
     *  同getDepth的迭代解法 
     */ 
    public static int getNodeNumKthLevel(TreeNode root, int k){  
        if(root == null){  
            return 0;  
        }  
        Queue<TreeNode> queue = new LinkedList<TreeNode>();  
        queue.add(root);  
           
        int i = 1;  
        int currentLevelNodes = 1;      // 当前Level，node的数量  
        int nextLevelNodes = 0;         // 下一层Level，node的数量  
           
        while( !queue.isEmpty() && i<k){  
            TreeNode cur = queue.remove();      // 从队头位置移除  
            currentLevelNodes--;            // 减少当前Level node的数量  
            if(cur.left != null){               // 如果有左孩子，加到队尾  
                queue.add(cur.left);  
                nextLevelNodes++;           // 并增加下一层Level node的数量  
            }  
            if(cur.right != null){          // 如果有右孩子，加到队尾  
                queue.add(cur.right);  
                nextLevelNodes++;  
            }  
               
            if(currentLevelNodes == 0){ // 说明已经遍历完当前层的所有节点  
                currentLevelNodes = nextLevelNodes;     // 初始化下一层的遍历  
                nextLevelNodes = 0;  
                i++;            // 进入到下一层  
            }  
        }  
           
        return currentLevelNodes;  
    }  
   