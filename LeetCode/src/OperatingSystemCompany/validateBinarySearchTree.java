package OperatingSystemCompany;

import Problems.TreeNode;

public class validateBinarySearchTree {
	
	public static boolean validateBST(TreeNode root, Integer min, Integer max ){
		if(root == null){
			return true;
		} else {
			if(root.val > max || root.val < min){
				return false;
			}
			return validateBST(root.left,min,root.val) && validateBST(root.right,root.val,max);	
		}
	}

}
