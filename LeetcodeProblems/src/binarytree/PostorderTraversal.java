package binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Collections;
import java.util.*;

public class PostorderTraversal {
	public static void main(String args[]) {
		TreeNode t = new TreeNode(1);
		t.left = new TreeNode(0);
		t.right = new TreeNode(2);
		//0 --> 1 --> 2
		postorderIterative(t);
		
		//0, 2 , 1
		
	}
	
	//left, right, root
	public static List<Integer> preorderTraversal1(TreeNode root) {
	    List<Integer> ret = new ArrayList<>();
	    dfs(root, ret);
	    return ret;
	}

	private static void dfs(TreeNode root, List<Integer> ret) {
	    if (root != null) {
	        dfs(root.left, ret);
	        dfs(root.right, ret);
	        ret.add(root.val);
	    }
	}
	
	private static List<Integer> postorderIterative(TreeNode root){
		Deque<TreeNode> stack = new LinkedList<>();
	    stack.push(root);
	    List<Integer> ret = new ArrayList<>();
	    while (!stack.isEmpty()) {
	        TreeNode node = stack.pop();
	        if (node != null) {
	            ret.add(node.val);
	            stack.push(node.left);
	            stack.push(node.right);
	        }
	    }
	    Collections.reverse(ret);
	    System.out.println(ret);
	    return ret;
	}

}
