package binarytree;

public class IsSymmetric {
	
	public static boolean isSymmetric(TreeNode root) {
		return helper(root, root);
		
    }
	
	public  static boolean helper(TreeNode root1, TreeNode root2) {
		if(root1 == null && root2 == null) {
			return true;
		}
		boolean condition = root1 != null && root2 != null && root1.val == root2.val;
		if(condition) {
			return helper(root1.right, root2.left) && helper(root1.left, root2.right);
		}
		return false;
	}

}
