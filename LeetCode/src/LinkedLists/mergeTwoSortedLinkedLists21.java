package LinkedLists;

public class mergeTwoSortedLinkedLists21 {
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
 
        ListNode fakeHead = new ListNode(0);
        ListNode p = fakeHead;
        
        while(p1 != null && p2 != null){
        	int p1val = p1.val;
        	int p2val = p2.val;
        	if(p1val <= p2val){
        		p.next  = p1;
        		p1 = p1.next;
        	} else {
        		p.next = p2;
        		p2 = p2.next;
        		
        	}
        }
        //What if there are elements left in 1?
        while(p1 != null){
        	p.next = p1;
        }
        //What if there are elements left in 2?
        while(p2 != null){
        	p.next = p2;
        }
        p.next =null;
        return p;
	}

}
