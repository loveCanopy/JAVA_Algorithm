 /** 
        14.  判断二叉树是不是完全二叉树（迭代） 
        若设二叉树的深度为h，除第 h 层外，其它各层 (1～h-1) 的结点数都达到最大个数， 
        第 h 层所有的结点都连续集中在最左边，这就是完全二叉树。 
        有如下算法，按层次（从上到下，从左到右）遍历二叉树，当遇到一个节点的左子树为空时， 
        则该节点右子树必须为空，且后面遍历的节点左右子树都必须为空，否则不是完全二叉树。 
     */ 
    public static boolean isCompleteBinaryTree(TreeNode root){  
        if(root == null){  
            return false;  
        }  
           
        Queue<TreeNode> queue = new LinkedList<TreeNode>();  
        queue.add(root);  
        boolean mustHaveNoChild = false;  
        boolean result = true;  
           
        while( !queue.isEmpty() ){  
            TreeNode cur = queue.remove();  
            if(mustHaveNoChild){    // 已经出现了有空子树的节点了，后面出现的必须为叶节点（左右子树都为空）    
                if(cur.left!=null || cur.right!=null){  
                    result = false;  
                    break;  
                }  
            } else {  
                if(cur.left!=null && cur.right!=null){      // 如果左子树和右子树都非空，则继续遍历  
                    queue.add(cur.left);  
                    queue.add(cur.right);  
                }else if(cur.left!=null && cur.right==null){    // 如果左子树非空但右子树为空，说明已经出现空节点，之后必须都为空子树  
                    mustHaveNoChild = true;  
                    queue.add(cur.left);  
                }else if(cur.left==null && cur.right!=null){    // 如果左子树为空但右子树非空，说明这棵树已经不是完全二叉完全树！  
                    result = false;  
                    break;  
                }else{          // 如果左右子树都为空，则后面的必须也都为空子树  
                    mustHaveNoChild = true;  
                }  
            }  
        }  
        return result;  
    }  
       
    /** 
     * 14.  判断二叉树是不是完全二叉树（递归） 
     * http://stackoverflow.com/questions/1442674/how-to-determine-whether-a-binary-tree-is-complete 
     *  
     */ 
    public static boolean isCompleteBinaryTreeRec(TreeNode root){  
//      Pair notComplete = new Pair(-1, false);  
//      return !isCompleteBinaryTreeSubRec(root).equalsTo(notComplete);  
        return isCompleteBinaryTreeSubRec(root).height != -1;  
    }  
       
    // 递归判断是否满树（完美）  
    public static boolean isPerfectBinaryTreeRec(TreeNode root){  
        return isCompleteBinaryTreeSubRec(root).isFull;  
    }  
       
    // 递归，要创建一个Pair class来保存树的高度和是否已满的信息  
    public static Pair isCompleteBinaryTreeSubRec(TreeNode root){  
        if(root == null){  
            return new Pair(0, true);  
        }  
           
        Pair left = isCompleteBinaryTreeSubRec(root.left);  
        Pair right = isCompleteBinaryTreeSubRec(root.right);  
           
        // 左树满节点，而且左右树相同高度，则是唯一可能形成满树（若右树也是满节点）的情况  
        if(left.isFull && left.height==right.height){  
            return new Pair(1+left.height, right.isFull);  
        }  
           
        // 左树非满，但右树是满节点，且左树高度比右树高一  
        // 注意到如果其左树为非完全树，则它的高度已经被设置成-1，  
        // 因此不可能满足第二个条件！  
        if(right.isFull && left.height==right.height+1){  
            return new Pair(1+left.height, false);  
        }  
           
        // 其他情况都是非完全树，直接设置高度为-1  
        return new Pair(-1, false);  
    }  
       
    private static class Pair{  
        int height;             // 树的高度  
        boolean isFull;     // 是否是个满树  
   
        public Pair(int height, boolean isFull) {  
            this.height = height;  
            this.isFull = isFull;  
        }  
   
        public boolean equalsTo(Pair obj){  
            return this.height==obj.height && this.isFull==obj.isFull;  
        }  
    }  
       
}  