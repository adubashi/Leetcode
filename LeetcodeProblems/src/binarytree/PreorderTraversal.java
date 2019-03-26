package binarytree;

import java.util.*;

public class PreorderTraversal {
	
	public static void main(String args[]) {
		TreeNode t = new TreeNode(1);
		t.left = new TreeNode(0);
		t.right = new TreeNode(2);
		
		preorderIterative(t);
		//0 --> 1 --> 2
		
	}
	
	//root, left, right
	public static List<Integer> preorderTraversal1(TreeNode root) {
	    List<Integer> ret = new ArrayList<>();
	    dfs(root, ret);
	    return ret;
	}

	private static void dfs(TreeNode root, List<Integer> ret) {
	    if (root != null) {
	        ret.add(root.val);
	        dfs(root.left, ret);
	        dfs(root.right, ret);
	    }
	}
	
	private static List<Integer> preorderIterative(TreeNode root){
		Stack<TreeNode> stack = new Stack<TreeNode>();
		List<Integer> returnList = new ArrayList<Integer>();
		stack.add(root);
		while(!stack.isEmpty()) {
			//Current Node
			TreeNode cur = stack.pop();
            if(cur != null) {
                returnList.add(cur.val);
                if(cur.right != null) {
                    stack.push(cur.right);
                }
                if(cur.left != null) {
                    stack.push(cur.left);
                }	
            }
		}
		System.out.println(returnList);
		return returnList;
	}

}
