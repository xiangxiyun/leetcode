public class RemoveNthNode{
	public static void main(String[] args){
		ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int n = 2;

        ListNode res = removeNthFromEnd(head, n);

        while(res!=null){
        	System.out.println(res.val);
        	res = res.next;
        }
	}
	private static ListNode removeNthFromEnd(ListNode head, int n) {
        int i = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while(n--!=0){
        	pre = pre.next;
        }
        pre = pre.next;
        
        ListNode cur = dummy;
        while(pre!=null){
        	pre = pre.next;
        	cur = cur.next;
        }
        // System.out.println(cur.val);
        cur.next = cur.next.next;
        return dummy.next;
    }
    
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}