package Trees.countCompleteTreeNodes222;

import Trees.TreeNode;

public class countCompleteTreeNodes222 {

	// 1. Get left height
	// 2. Get right height 
	// 3. If equal, then return 2^h - 1.(Number of complete nodes)
	// 4. If not recurse on right and left subtrees
	
	public static void main(String args[]){
		TreeNode n = new TreeNode(3);
		//System.out.println(getLeftHeight(n));
	}
	
	public  static int countNodes(TreeNode root) {
		if(root==null)
	        return 0;
	 
	    int left = getLeftHeight(root)+ 1;    
	    int right = getRightHeight(root) + 1;
	    
	    if(left == right){
	    	return (2<<(left-1))-1;
	    } else {
	    	return countNodes(root.left) + countNodes(root.right) + 1;
	    }
	        
	}
	
	
	
	public static int getLeftHeight(TreeNode n){
	    if(n==null) return 0;
	 
	    int height=0;
	    while(n.left!=null){
	        height++;
	        n = n.left;
	    }
	    return height;
	}
	 
	public static int getRightHeight(TreeNode n){
	    if(n==null) return 0;
	 
	    int height=0;
	    while(n.right!=null){
	        height++;
	        n = n.right;
	    }
	    return height;
	}
}
