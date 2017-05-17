package Stack.binaryTreePreorderTraversal;

import java.util.*;

public class binaryTreePreorderTraversal144 {
	
	public List<Integer> preorderTraversal(TreeNode root) {
		
		List<Integer> list =  new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if(root == null){
			return list;
		}
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode curNode = stack.pop();
			list.add(curNode.val);
			if(curNode.right != null){
				stack.push(curNode.right);
			}
			if(curNode.left != null){
			    stack.push(curNode.left);
			}
		}
		
		return list;
        
    }
	public static void printPreorder(TreeNode node)
	{
	     if (node == null)
	          return;
	 
	     /* first print data of node */
	     System.out.println( node.val);  
	     /* then recur on left subtree */
	     printPreorder(node.left);  
	     /* now recur on right subtree */
	     printPreorder(node.right);
	} 

}
