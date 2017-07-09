package ProblemsBasedOnDataStructures.Trees.ConstructStringFromBinaryTree606;


import java.util.List;
import java.util.ArrayList;
import ProblemsBasedOnDataStructures.Trees.TreeNode;
import ProblemsBasedOnDataStructures.Trees.BinaryTreePaths257.BinaryTreePaths;

public class ConstructStringFromBinaryTree {
	
	
	
	
	public static void preorder(TreeNode t) {
		
		if(t != null){
			System.out.println(t.val);
			preorder(t.left);
			preorder(t.right);
		} else {
			return;
		}
		
    }
	
	public static String tree2str(TreeNode t){
		if(t == null){
			return "";
		} else if(t.left == null && t.right == null){
			return String.valueOf(t.val);
		} else if(t.right == null){
			return t.val + "(" + tree2str(t.left) + ")";
		} else {
			return t.val + "(" + tree2str(t.left) + ")" + "(" + tree2str(t.right) + ")";
		}
	}
	
	
	

	public static void main(String args[]){
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		
		t1.left = t2;
		t1.right = t3;
		
		t2.left = t4;
		
		preorder(t1);
	}

}
