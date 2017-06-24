package ProblemsBasedOnDataStructures.Trees.DiameterOfaBinaryTree543;
import ProblemsBasedOnDataStructures.Trees.TreeNode;

public class DiameterOfABinaryTree {
	
	
	public static void main(String args[]){
		TreeNode root = new TreeNode(1);
		
		TreeNode n1 = new TreeNode(2);
		TreeNode n2 = new TreeNode(3);
		
		TreeNode n3 = new TreeNode(4);
		TreeNode n4 = new TreeNode(5);
		
		root.left = n1;
		root.right = n2;
		
		n1.left = n3;
		n1.right = n4;
		
		inOrder(root);
		
	}
	
	public static void inOrder(TreeNode root){
		
		if(root == null){
			return;
		} else {
			inOrder(root.left);
			System.out.println(root.val);
			inOrder(root.right);
		}
		
		
	}
	/*
	 * 
	 * Longest path between any two nodes in a binary tree
	 * Think it is just the longest path down the left side plus the longest path 
	 * down the right side  --> This is incorrect. It  could be a heavily unbalanced
	 * tree  
	 * 
	 * 
	 */
	
	public static int diameterOfBinaryTree(TreeNode root) {
		
		if(root == null){
			return 0;
		}
        
		int leftDepth = maxDepth(root.left);
		int rightDepth = maxDepth(root.right);
		
		
		int leftDiameter = diameterOfBinaryTree(root.left);
		int rightDiameter = diameterOfBinaryTree(root.right);
		
		return Math.max(leftDepth + rightDepth, Math.max(leftDiameter, rightDiameter) );
    }
	
	
	
	
	public static int maxDepth(TreeNode root){
		if(root == null){
			return 0;
		}
		
		int depthOfLeft = maxDepth(root.left);
	    int depthOfRight = maxDepth(root.right);
	    
	    int max = Math.max(depthOfLeft, depthOfRight);
	    
	    return max+1;
	}
	
	
	
	

}
