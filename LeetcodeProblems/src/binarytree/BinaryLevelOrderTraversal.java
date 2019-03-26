package binarytree;

import java.util.*;

public class BinaryLevelOrderTraversal {
	
	
	public static void main(String args[]) {
		TreeNode t = new TreeNode(1);
		t.left = new TreeNode(0);
		t.right = new TreeNode(2);
		
		List<Integer> test = levelOrder(t);
	}
	
	/*
	 * Use BFS 
	 * : 1
	 * : 0 2
	 * 
	 * - Use a queue 
	 * - Set a node to the root node 
	 * - while the temp node is not null->temp_node->data,
	 * - Enqueue temp_node’s children (first left then right children) to q
	 * - Dequeue a node from q and assign it’s value to temp_node
	 */
	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
	    Queue<TreeNode> queue = new LinkedList<>();
	    queue.offer(root);
	    
	    while(!queue.isEmpty()) {
	        int size = queue.size();
	        List<Integer> curList = new ArrayList<>();
	        for (int i = 0; i < size; i++) {
	            TreeNode curNode = queue.poll();
	            curList.add(curNode.val);
	            if (curNode.left != null) {
	                queue.offer(curNode.left);
	            }
	            if (curNode.right != null) {
	                queue.offer(curNode.right);
	            }
	        }
	        result.add(curList);
	    }
	    return result;
        
    }

}
