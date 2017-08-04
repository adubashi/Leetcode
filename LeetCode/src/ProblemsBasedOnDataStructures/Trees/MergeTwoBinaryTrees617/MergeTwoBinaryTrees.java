package ProblemsBasedOnDataStructures.Trees.MergeTwoBinaryTrees617;
import java.util.List;
import java.util.ArrayList;
import ProblemsBasedOnDataStructures.Trees.TreeNode;


public class MergeTwoBinaryTrees {
	
	public static TreeNode mergeTwoBinaryTrees(TreeNode t1, TreeNode t2){
		
		if(t1 == null && t2 == null){
		   return null;
		}
		if(t1 != null && t2 == null){
		   return t1; 
		}
		if(t1 == null && t2 != null){
		   return t2;
		}
		
		
		//Assume neither are null
		TreeNode res = new TreeNode(0);
		res.val = t1.val + t2.val;
		
		res.left  = mergeTwoBinaryTrees(t1.left,t2.left); 
		res.right =  mergeTwoBinaryTrees(t1.right,t2.right);
		
		return res;
		
		
	}

}
