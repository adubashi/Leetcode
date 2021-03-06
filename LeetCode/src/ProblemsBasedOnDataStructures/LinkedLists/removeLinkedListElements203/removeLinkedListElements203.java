package LinkedLists.removeLinkedListElements203;

import LinkedLists.ListNode;

public class removeLinkedListElements203 {
	
	//Add a helper node
	public static ListNode removeElements(ListNode head, int val) {
		 ListNode helper = new ListNode(0);
	     helper.next = head;
	     ListNode cur = helper;
	        
	        while(cur.next != null){
	            if(cur.next.val == val){
	               //Delete node
	            	cur.next = cur.next.next;
	            } else {
	            	//Traverse list 
	            	cur = cur.next;
	            }
	        }
	        return helper.next;
        
    }

}
