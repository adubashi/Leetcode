package OperatingSystemCompany;
import Problems.TreeNode;
public class symmetricTree100 {
	public static void main(String args[]){
		
	}
	
	public static boolean isSymmetric(TreeNode root) {
    	if (root == null)
    		return true;
    	return isSymmetric(root.left, root.right);
    }
	
	public static boolean isSymmetric(TreeNode l, TreeNode r) {
		//Base case--both are null
		if(l == null && r == null){
			return true;
		} 
		
		if(l != null && r != null && l.val == r.val){
			return isSymmetric(l.left,r.right) && isSymmetric(l.right,r.left);
		}
		
		return false;
		
		
	}

}
