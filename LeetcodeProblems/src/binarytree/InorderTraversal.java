package binarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.*;

public class InorderTraversal {
	public static void main(String args[]) {
		TreeNode t = new TreeNode(1);
		t.left = new TreeNode(0);
		t.right = new TreeNode(2);
		//0 --> 1 --> 2
		List<Integer> res = inorderTraversal(t);
		System.out.println(res);
		
		//0, 2 , 1
		
	}
	
	//left, right, root
	public static List<Integer> inorderRecur(TreeNode root) {
	    List<Integer> ret = new ArrayList<>();
	    dfs(root, ret);
	    return ret;
	}

	private static void dfs(TreeNode root, List<Integer> ret) {
	    if (root != null) {
	        dfs(root.left, ret);
	        ret.add(root.val);
	        dfs(root.right, ret);
	    }
	}
	
	public static List<Integer> inorderTraversal(TreeNode root) {
	    List<Integer> list = new ArrayList<Integer>();
	    Stack<TreeNode> stack = new Stack<TreeNode>();
	    TreeNode cur = root;
	    while(cur!=null || !stack.empty()){
	    		//Go down left
	        while(cur!=null){
	            stack.add(cur);
	            cur = cur.left;
	        }
	        //Go down right
	        cur = stack.pop();
	        list.add(cur.val);
	        cur = cur.right;
	    }
	    return list;
	}

}
