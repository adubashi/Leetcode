package Trees.sumOfLeftLeaves404;

import Trees.*;
public class sumOfLeftLeaves {
	
	public static void main(String args[]){
		
		TreeNode root = new TreeNode(0);
		
		root.left = new TreeNode(1);
		
		TreeNode test = new TreeNode(4);
		root.right = test;
		test.right = new TreeNode(3);
		test.left = new TreeNode(2);
		
		System.out.println(sumOfLeftLeaves(root));
		
		
		
	}

	public static int sumOfLeftLeaves(TreeNode root){
		int sum  = 0;
		if(root != null){

			if(isLeaf(root.left)){
				sum = sum + root.left.val;
			} else {
				sum = sum + sumOfLeftLeaves(root.left);
			}
			
			sum = sum + sumOfLeftLeaves(root.right);
		}
		
		return sum;
	}
	
	public static boolean isLeaf(TreeNode root){
		if(root == null){
			return false;
		}
		
		return root.left == null && root.right == null;
	}
	
	
}
