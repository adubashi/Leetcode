package ProblemsBasedOnDataStructures.Trees.BinaryTreePostorderTraversal145;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import ProblemsBasedOnDataStructures.Trees.TreeNode;

public class BinaryTreePostorderTraversal {
	
	
	public static ArrayList<Integer> result = new ArrayList<>();
	
	
	public List<Integer> postorderTraversal(TreeNode t1){
		postorderTraversalHelper(t1);
		return result;
	}
	
	public void postorderTraversalHelper(TreeNode root) {
        //L
		//R
		//End
		if(root != null){
		   postorderTraversalHelper(root.left);
		   postorderTraversalHelper(root.right);
		   result.add(root.val);
			
		}
    }
	/*
	 * 1. Push root to first stack.
	   2. Loop while first stack is not empty
   			2.1 Pop a node from first stack and push it to second stack
   			2.2 Push left and right children of the popped node to first stack
	   3. Print contents of second stack
	 * 
	 */
	
	public List<Integer> postorderTraversalIterative(TreeNode root){	
		Stack<TreeNode> stk1 = new Stack<TreeNode>();
		Stack<TreeNode> stk2 = new Stack<TreeNode>();
		
		//If the root is null, then return an empty list
		if(root == null){
			return new ArrayList<>();
		}
		
		stk1.push(root);

		while(!stk1.isEmpty()){
			TreeNode temp = stk1.pop();
			stk2.push(temp);	
			if(temp.left != null){
				stk1.push(temp.left);
			}
			if(temp.right != null){
				stk1.push(temp.right);
			}	
		}
		
		List<Integer> result = new ArrayList<Integer>();
		while(!stk2.isEmpty()){	
			TreeNode temp = stk2.pop();
			result.add(temp.val);
		}	
		return result;
	}

}
