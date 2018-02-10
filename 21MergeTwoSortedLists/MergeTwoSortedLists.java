public class MergeTwoSortedLists{

	public static void main(String[] args){
		ListNode l1 = new ListNode(0);
		ListNode cur = l1;
		cur.next = new ListNode(1);
		cur = cur.next;
		cur.next = new ListNode(3);
		cur = cur.next;
		cur.next = new ListNode(4);


		ListNode l2 = new ListNode(1);
		cur = l2;
		cur.next = new ListNode(2);
		cur = cur.next;
		cur.next = new ListNode(5);
		cur = cur.next;
		cur.next = new ListNode(7);

		ListNode res = mergeTwoLists(l1, l2);

		while(res != null){
			System.out.print(res.val);
			System.out.print("->");
			res = res.next;
		}
		System.out.println("null");
	}
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	ListNode res = new ListNode(0);
    	ListNode p1 = l1, p2 = l2, cur = res;

    	while(p1!=null && p2!=null){
    		if(p2.val > p1.val){
    			cur.next = p1;
    			p1 = p1.next;
    		}else{
    			cur.next = p2;
    			p2 = p2.next;
    		}
    		cur = cur.next;
    	}
    	cur.next = p1 == null? p2: p1;

    	return res.next;
    }
}

class ListNode{
	int val;
	ListNode next;
	ListNode(int x){val = x;}
}