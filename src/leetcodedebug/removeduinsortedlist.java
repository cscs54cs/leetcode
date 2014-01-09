package leetcodedebug;

public class removeduinsortedlist {
	public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null)  return head;
        ListNode fakehead = new ListNode(head.val-1000);
        fakehead.next = head;
        ListNode p1,p2,p3;
        p1=fakehead;
        p2=p1.next;
        p3=p2.next;
        while(p3!=null)
        {
            if(p2.val==p3.val)
            {
                while(p3.next!=null&&p3.next.val==p3.val)
                {
                    p3=p3.next;
                }
                p1.next=p3.next;
                if(p1.next==null)   break;
                p2=p1.next;
                p3=p2.next;
            }
            else
            {
                p1=p3;
                if(p1.next==null)   break;
                p2=p1.next;
                p3=p2.next;
            }
        }
        return fakehead.next;
    }
	public static void main(String[] args)
	{
		removeduinsortedlist test = new removeduinsortedlist();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next= new ListNode(2);
		test.deleteDuplicates(head);
	}
}
