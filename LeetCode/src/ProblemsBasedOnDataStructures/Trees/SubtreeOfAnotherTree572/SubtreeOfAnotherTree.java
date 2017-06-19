package ProblemsBasedOnDataStructures.Trees.SubtreeOfAnotherTree572;


import ProblemsBasedOnDataStructures.Trees.TreeNode;


public class SubtreeOfAnotherTree {
	/*
	 * Check if t is a subtree of s
	 * 
	 * 
	 * 
	 * call isEqual on each node
	 */
	public static boolean isSubtree(TreeNode s, TreeNode t) {
		
		if(t == null){
			return true;
		}
		if(s == null){
			return false;
		}
		
		if(isEqual(s,t)){
			return true;
		}

        return isSubtree(s.left,t) || isSubtree(s.right,t);
    }
	/*
	 * 
	 * Checks if two trees are equal
	 */
	public static boolean isEqual(TreeNode s, TreeNode t){	
		if(s == null && t == null){
			return true;
		}
		if(s == null || t == null){
			return false;
		}
		return s.val == t.val && isEqual(s.left,t.left) && isEqual(s.right,t.right);
	}
	

}
