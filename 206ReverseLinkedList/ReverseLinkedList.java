public class ReverseLinkedList{
	public static void main(String[] args){
		ListNode l1 = new ListNode(1);
		ListNode cur = l1;
		cur.next = new ListNode(3);
		cur = cur.next;
		cur.next = new ListNode(5);
		cur = cur.next;
		cur.next = new ListNode(7);
		cur = cur.next;
		cur.next = new ListNode(9);

		ListNode res = reverse(l1);

		while(res != null){
			System.out.println(res.val);
			res = res.next;
		}
	}
	private static ListNode reverse(ListNode head){
		ListNode pre = null;
		while(head!= null){
			ListNode next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
	}

}

class ListNode{
	int val;
	ListNode next;
	ListNode(int x){this.val = x;}
}