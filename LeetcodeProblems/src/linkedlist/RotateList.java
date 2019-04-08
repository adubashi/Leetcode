package linkedlist;

public class RotateList {
	public ListNode rotateRight(ListNode head, int k) {
		//Use fast and slow pointer method
				ListNode fast = head;
				ListNode slow = head;
				//Go down k steps
				int i = 0;
		        int len = 0;
		        
		        //Calculate len
		        for(ListNode node = head; node != null; node = node.next){
		            len++;
		        }
		        if(len == 0)//Corner case: fast is null
		            return head; 
		        if(k == 0 || k % len == 0) return head;
		        k = k % len;
		        
		        //Go fast --> k places 
				while(fast != null && i < k) {
					fast = fast.next;
					i++;
				}
		        
				ListNode fastPrev = null;
				ListNode slowPrev = null;
				while(fast != null) {
		            fastPrev = fast;
		            slowPrev = slow;
		            fast = fast.next;
		            slow = slow.next;
		        }
		        fastPrev.next = head;
		        slowPrev.next = null;
		        return slow;
    }
}
