package ProblemsBasedOnDataStructures.Trees.BinaryTreeTilt563;

import ProblemsBasedOnDataStructures.Trees.TreeNode;

public class BinaryTreeTilt {
	
	public static int findTilt(TreeNode root){
		if(root == null){
			return 0;
		}
		
		return Math.abs(helper(root.left) - helper(root.right)) + findTilt(root.left) + findTilt(root.right);
	}
	
	public static int helper(TreeNode root){
		if(root == null){
			return 0;
		}
        return root.val + helper(root.left) + helper(root.right);
	}
	
public static void main(String args[]){
		/*
		 *    4
		 *   / \
		 *  2   7
		 *
		 */
		
		TreeNode head = new TreeNode(4);
		
		TreeNode headRight = new TreeNode(7);
		TreeNode headLeft = new TreeNode(2);
		
		head.right = headRight;
		head.left = headLeft;
		
		System.out.println(head.val);
		System.out.println("Left " + head.left.val);
		System.out.println("Right " + head.right.val);
		
		
		int result = findTilt(head);
		
		System.out.println(result);
		
	}

	
}
