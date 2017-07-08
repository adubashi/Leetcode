package ProblemsBasedOnDataStructures.Trees.BinaryTreePaths257;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import ProblemsBasedOnDataStructures.Trees.TreeNode;
public class BinaryTreePathsTest {
	
	
	public static void main(String args[]){
		
		BinaryTreePaths mBinaryTreePaths = new BinaryTreePaths();
		
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(5);
		
		t1.left = t2;
		t1.right = t3;
		
		t2.right = t4;
		
		List<String> paths = mBinaryTreePaths.binaryTreePaths(t1);
		
		
		for(int i = 0; i < paths.size(); i++){
			System.out.println(paths.get(i));
		}
		
	}

}
