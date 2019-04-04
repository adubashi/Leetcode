package linkedlist;

public class RemoveNthNode {
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
        /*
		 * 1. Calculate length of list 
		 * 2. Subtract n from length, traverse that much then remove it.
		 */
		int len = length(head);
		int diff = len - n + 1;
		if(diff == 1) {
			return head.next;
		}
		
		//remove non-first node    
        ListNode p = head;
        int i=0;
        while(p!=null){
            i++;
            if(i==diff-1){
                p.next = p.next.next;
            }
            p=p.next;
        }
        return head;
    }
    
    public static int length(ListNode head) {
		int len = 0;
		while(head != null) {
			head = head.next;
			len++;
		}
		return len;
	}

}
