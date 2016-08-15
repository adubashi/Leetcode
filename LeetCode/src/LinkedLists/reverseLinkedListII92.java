package LinkedLists;

public class reverseLinkedListII92 {
	
	public static ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode prev = newHead;
        for(int i = 0 ; i < m-1 ; i++){
            prev = prev.next;
        }
        ListNode  reversedPrev = prev;
        //position m
        prev = prev.next;
        ListNode cur = prev.next;
        for(int i = m ; i < n ; i++){
            prev.next = cur.next;
            cur.next = reversedPrev.next;
            reversedPrev.next = cur;
            cur = prev.next;
        }
        return newHead.next;
    }

}
