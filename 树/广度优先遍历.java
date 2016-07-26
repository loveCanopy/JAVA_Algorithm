/** 
     * 分层遍历二叉树（按层次从上往下，从左往右）迭代 
     * 相当于广度优先搜索，使用队列实现。队列初始化，将根节点压入队列。当队列不为空，进行如下操作：弹出一个节点 
     * ，访问，若左子节点或右子节点不为空，将其压入队列 
     */ 
    public static void levelTraversal(TreeNode root) {  
        if (root == null) {  
            return;  
        }  
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();  
        queue.push(root);  
   
        while (!queue.isEmpty()) {  
            TreeNode cur = queue.removeFirst();  
            System.out.print(cur.val + " ");  
            if (cur.left != null) {  
                queue.add(cur.left);  
            }  
            if (cur.right != null) {  
                queue.add(cur.right);  
            }  
        }  
    }  
       