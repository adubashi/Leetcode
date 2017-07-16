package ProblemsBasedOnDataStructures.Trees.FindModeOfaBST501;


import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;
import ProblemsBasedOnDataStructures.Trees.TreeNode;


public class ModeInABST {

	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(2);
		TreeNode t4 = new TreeNode(3);
		TreeNode t5 = new TreeNode(3);
		t1.right = t2;
		t2.left = t3;
		t2.right = t4;
		t4.right = t5;
		
		int[] res  = findModeRes(t1);
		
		System.out.println(Arrays.toString(res));
	}
	/*
	 * L V R 
	 * 
	 * Need a stack and current TreeNode
	 */
	public static void inorderTraversal(TreeNode root){
		Stack<TreeNode> stk = new Stack<TreeNode>();
		TreeNode currentNode = null;
		currentNode = root;
		
		//Push the leftmost nodes onto the stack and set the currentNode to the leftmost node
		while(currentNode != null){
			stk.push(currentNode);
			currentNode = currentNode.left;
		}
		
		//While the stk is not empty --> pop the stack and print the node
		while(!stk.isEmpty()){
			currentNode = stk.pop();
			//System.out.println(currentNode.val);
			
			//Work down the right side
			if(currentNode.right != null){
				currentNode = currentNode.right;
				//push the leftmost nodes onto the stack and set the current node to the leftmost node
				while(currentNode != null){
					stk.push(currentNode);
					currentNode = currentNode.left;
				}
			}
		}
		
		}
		
		public static List<Integer> inorderTraversalList(TreeNode root){
			Stack<TreeNode> stk = new Stack<TreeNode>();
			List<Integer> list = new ArrayList<Integer>();
			TreeNode currentNode = null;
			currentNode = root;
			
			//Push the leftmost nodes onto the stack and set the currentNode to the leftmost node
			while(currentNode != null){
				stk.push(currentNode);
				currentNode = currentNode.left;
			}
			
			//While the stk is not empty --> pop the stack and print the node
			while(!stk.isEmpty()){
				currentNode = stk.pop();
				System.out.println(currentNode.val);
				list.add(currentNode.val);
				
				//Work down the right side
				if(currentNode.right != null){
					currentNode = currentNode.right;
					//push the leftmost nodes onto the stack and set the current node to the leftmost node
					while(currentNode != null){
						stk.push(currentNode);
						currentNode = currentNode.left;
					}
				}			
			}
			return list;
		}
		
		public static int findMode(TreeNode root){
			List<Integer> inorderTraversal = inorderTraversalList(root);
			int res = findMode(inorderTraversal);
			return res;
			
		}
		
		public static int findMode(List<Integer> traversal){
			
			List<Integer> max = new ArrayList<Integer>();
			
			Integer maxValue = traversal.get(0);
			Integer lastValue = maxValue;
			int count = 1;
			int maxCount = 1;
			
			for(int i = 1; i < traversal.size(); i++){
				int curVal = traversal.get(i);
				if(curVal == lastValue){
					count++;
				} else {
					count = 1;
					lastValue = curVal;
				}
				
				if(count >= maxCount){
					maxCount = count;
					maxValue = lastValue;
					max.add(maxValue);
				}
			}
			
			int[] arr = max.stream().mapToInt(k -> k).toArray();
			return arr[0];		
		}
		
		public static int[] findModeRes(TreeNode root){
			List<Integer> inorderTraversal = inorderTraversalList(root);
			Map<Integer,Integer> map = new HashMap<Integer,Integer>();
			List<Integer> result = new ArrayList<Integer>();	
			int maxCount = 0;
			for(int i = 0; i < inorderTraversal.size(); i++){
				int currentVal = inorderTraversal.get(i);
				if(map.containsKey(currentVal)){
					int currentcount = map.get(currentVal);
					map.put(currentVal, currentcount + 1);
				} else {
					map.put(currentVal, 1);
				}
				
				int currentcount = map.get(currentVal);
				
				if(currentcount  > maxCount){
					maxCount = currentcount;
				}
			}
			
			for(int i = 0; i < inorderTraversal.size(); i++){
				int curVal = inorderTraversal.get(i);
				if(map.get(curVal) == maxCount && !result.contains(curVal)){
				   result.add(curVal);
				}
			}
			
			int[] arr = result.stream().mapToInt(k -> k).toArray();			
			return arr;
		}
	
	

}
