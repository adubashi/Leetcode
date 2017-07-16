package ProblemsBasedOnDataStructures.Trees.FindModeOfaBST501;


import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
import ProblemsBasedOnDataStructures.Trees.TreeNode;


public class ModeInABST {

	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(2);
		t1.right = t2;
		t2.left = t3;
		
		inorderTraversal(t1);
	}
	/*
	 * L V R 
	 * 
	 * Need a stack and current TreeNode
	 */
	public static void inorderTraversal(TreeNode root){
		Stack<TreeNode> stk = new Stack<TreeNode>();
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
