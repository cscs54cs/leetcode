package leetcodedebug;

public class removenthfromend {
	public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1,p2,fakehead=new ListNode(0);
        fakehead.next=head;
        p1=fakehead;
        p2=fakehead;
        int i=0;
        for(i=0;i<n;i++)
        {
            p2=p2.next;
        }
        while(p2!=null)
        {
            p1=p1.next;
            p2=p2.next;
        }
        p1.next=p1.next.next;
        return fakehead.next;
    }
}
