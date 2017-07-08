package ProblemsBasedOnDataStructures.Trees.BinaryTreePaths257;

import java.util.List;
import java.util.ArrayList;
import ProblemsBasedOnDataStructures.Trees.TreeNode;

public class BinaryTreePaths {
	
	public static ArrayList<String> mBinaryTreePaths;
	
	
	
    public List<String> binaryTreePaths(TreeNode root) {

    	mBinaryTreePaths = new ArrayList<String>();
    	binaryTreePathsHelper(root,"");
    	return mBinaryTreePaths;
        
    }
    public void binaryTreePathsHelper(TreeNode root, String elem){
    	
    	if(root == null){
    		return;
    	}
    	
    	
    	if(root.left == null && root.right == null){
    		elem = elem + String.valueOf(root.val);
    		mBinaryTreePaths.add(elem);

    	} else{
    		elem = elem + root.val + "->";
    		binaryTreePathsHelper(root.right, elem);
    		binaryTreePathsHelper(root.left, elem);
    	}
    	
    }
    
    public void dfs(TreeNode root, ArrayList<ArrayList<String>> list, ArrayList<String> curr){
    	curr.add(root.val + "");
    	
    	if(root.left == null && root.right == null){
    		list.add(curr);
    		return;
    	}
    	
    	if(root.left != null){
    		dfs(root.left, list, new ArrayList<String>(curr) );
    	}
    	if(root.right != null){
    		dfs(root.right, list, new ArrayList<String>(curr));
    	}
    }
    
    
    
    

}
