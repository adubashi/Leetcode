package ProblemsBasedOnDataStructures.Trees.RecoveryBinarySearchTree99;

import java.util.ArrayList;
import java.util.Stack;

import ProblemsBasedOnDataStructures.Trees.TreeNode;

public class RecoveryBinarySearchTree {
	
	
	
	public static void main(String args[]) {
		TreeNode n1 = new TreeNode(2);
		
		TreeNode n2 = new TreeNode(1);
		
		TreeNode n3 = new TreeNode(3);
		
		n1.left = n2;
		n1.right = n3;
		
		//Switched tree
		TreeNode n4 = new TreeNode(2);
		
		TreeNode n5 = new TreeNode(1);
		
		TreeNode n6 = new TreeNode(3);
		
		n4.left = n6;
		n4.right = n5;
		
		recoverTree(n4);
	}
	
	public static void recoverTree(TreeNode root) {
		//In order traversal 
		
		ArrayList<TreeNode> list = new ArrayList<TreeNode>();
		Stack<TreeNode> stk = new Stack<TreeNode>();
		
		TreeNode currentNode = null;
		currentNode = root;
		
		//Push the leftmost nodes onto the stack and set the currentNode to the leftmost node
		while(currentNode != null){
			stk.push(currentNode);
			currentNode = currentNode.left;
		}
		
		while(!stk.isEmpty()) {
			currentNode = stk.pop();
			System.out.println(currentNode.val);
			list.add(currentNode);
			
			//Work down the right side
			if(currentNode.right != null) {
				currentNode = currentNode.right;
				while(currentNode != null) {
					stk.push(currentNode);
					currentNode = currentNode.left;	
				}
			}
		}
		
		
		
		// Next step, find the elements which are out of position and swap them
		TreeNode first = null;
		TreeNode middle = null;
		TreeNode last = null;
		ArrayList<TreeNode> res = new ArrayList<TreeNode>();
		for(int i = 1; i < list.size(); i++ ) {
			if(list.get(i).val < list.get(i-1).val) {
				if(first == null) {
					first = list.get(i-1);
					middle = list.get(i);
				} else {
					last = list.get(i);
				}
			}
		}
		//Nodes are adjacent 
		if(last == null) {
		   //Swap first and middle
		   int firstValue = first.val;
		   first.val = middle.val;
		   middle.val = firstValue;
			
		} else {
			//Nodes are not adjacent, swap first and last
			int firstValue = first.val;
			first.val = last.val;
			last.val = firstValue;
			
		}
		
		
		System.out.println("------------");
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).val);
		}
		
	}

}
