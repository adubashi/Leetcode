package ProblemsBasedOnDataStructures.Trees.InvertBinaryTree226;

import java.util.LinkedList;
import java.util.Queue;

import ProblemsBasedOnDataStructures.Trees.TreeNode;

public class InvertBinaryTree {
	
	/*
	 * Invert a Binary Tree
	 * If null --> do nothing
	 * 
	 * If none null, switch right and left children
	 * 
	 * 
	 */
	
	public static void main(String args[]){
		
		TreeNode head = new TreeNode(4);
		
		TreeNode headRight = new TreeNode(7);
		TreeNode headLeft = new TreeNode(2);
		
		head.right = headRight;
		head.left = headLeft;
		
		System.out.println(head.val);
		System.out.println("Left " + head.left.val);
		System.out.println("Right " + head.right.val);
		
		
		TreeNode result = invertBTree(head);
		
		System.out.println(result.val);
		System.out.println("Left " + result.left.val);
		System.out.println("Right " + result.right.val);
		
	}
	
	//Only does the first level
	public static TreeNode invertBTreeWrong(TreeNode head){
		if(head == null){
			return head;
		} 
		
		//Swap right and left children
		TreeNode temp = head.left;
		head.left = head.right;
		head.right = temp;
		
		
		
		return head;
		
	}
	
	//Recursive method --> O(N) Time
	// O(N) --> Space
	public static TreeNode invertBTree(TreeNode head){
			if(head == null){
				return head;
			} 		
			//Swap right and left children
			TreeNode right = invertBTree(head.right);
			TreeNode left = invertBTree(head.left);	
			head.left = right;
			head.right = left;
		
			return head;		
	}
	
	//Iterative method --> O(N) time, O(1) space
	//Use a queue and swap each pointer(right and left)
	
	public static TreeNode invertBTreeIterative(TreeNode head){
		
		//Queue
		Queue<TreeNode> queue = new LinkedList<>();	
		if(head == null){
			return null;
		}
		queue.add(head);
		
		while(!queue.isEmpty()){
			TreeNode curNode = queue.poll();
			
			//Add children to continue 
			if(curNode.left != null){
			    queue.add(curNode.left);
			}
			if(curNode.right != null){
			    queue.add(curNode.right);
			}
			
			//Swap pointers
			TreeNode right = curNode.right;
			curNode.right = curNode.left;
			curNode.left = right;		
		}
		//Return head
		return head;		
	}
	

}
