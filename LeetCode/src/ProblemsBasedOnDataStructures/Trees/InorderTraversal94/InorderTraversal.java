package ProblemsBasedOnDataStructures.Trees.InorderTraversal94;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import ProblemsBasedOnDataStructures.Trees.TreeNode;

public class InorderTraversal {
	
	public static List<Integer> inorderTraversalList(TreeNode root){
		Stack<TreeNode> stk = new Stack<TreeNode>();
		List<Integer> list = new ArrayList<Integer>();
		TreeNode currentNode = null;
		currentNode = root;
		
		//Push the leftmost nodes onto the stack and set the currentNode to the leftmost node
		while(currentNode != null){
			stk.push(currentNode);
			currentNode = currentNode.left;
		}
		
		//While the stk is not empty --> pop the stack and print the node
		while(!stk.isEmpty()){
			currentNode = stk.pop();
			System.out.println(currentNode.val);
			list.add(currentNode.val);
			
			//Work down the right side
			if(currentNode.right != null){
				currentNode = currentNode.right;
				//push the leftmost nodes onto the stack and set the current node to the leftmost node
				while(currentNode != null){
					stk.push(currentNode);
					currentNode = currentNode.left;
				}
			}
				
		}
		return list;
	}

}
