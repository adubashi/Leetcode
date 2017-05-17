package LinkedLists.convertSortedListToBST109;

import LinkedLists.ListNode;
import LinkedLists.TreeNode;

public class convertSortedListToBST109 {
	
	public static ListNode h;
	public TreeNode sortedListToBST(int start, int end) {
		
		if(start > end){
			return null;
		}
		
		int mid = (start + end)/2;
		
		TreeNode left = sortedListToBST(start,mid-1);
		TreeNode root = new TreeNode(h.val);
		h = h.next;
		TreeNode right = sortedListToBST(mid + 1, end); 
		root.left = left;
		root.right = right;
		return root;	
	}

}
