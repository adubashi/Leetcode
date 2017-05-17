package LinkedLists.reverseNodesInKgroup25;

import LinkedLists.ListNode;

public class reverseNodesInKgroup25 {
	/*
	 * 0->1->2->3->4->5->6
	 * |           |   
	 * pre        next
	 *
	 * after calling pre = reverse(pre, next)
	 * 
	 * 0->3->2->1->4->5->6
	 *          |  |
	 *          pre next 
	 */
	public ListNode reverse(ListNode pre, ListNode next){
	    ListNode last = pre.next;
	    ListNode curr = last.next;
	    
	    while(curr != null){
	    	last.next = curr.next;
	        curr.next = pre.next;
	        pre.next = curr;
	        curr = last.next;
	    }
	    
	    return last;
	}
	
	public ListNode reverseKGroup(ListNode head, int k) {
		
		if(head==null||k==1) {
            return head;
		}
     
        ListNode fake = new ListNode(0);
        fake.next = head;
        ListNode pre = fake;
        int i=0;
        
        ListNode p = head;
        while(p != null){
        	i++;
        	if( i % k == 0){
        		pre = reverse(pre,p.next);
        		p = pre.next;
        	} else {
        		p = p.next;
        	}
        }
        return fake.next;
	}

}
