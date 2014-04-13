package leetcodedebug;

public class swappairs {
    public ListNode swapPairs(ListNode head) {
        if(head==null)  return null;
        if(head.next==null) return head;
        ListNode fakehead = new ListNode(0);
        fakehead.next=head;
        ListNode p1,p2,p3;
        p1=fakehead;
        p2=p1.next;
        p3=p2.next;
        while(p3!=null){
            p1.next=p3;
            p2.next=p3.next;
            p3.next=p2;
            p1=p2;
            p2=p1.next;
            if(p2!=null){
                p3=p2.next;
            }
            else{
                p3=null;
            }
        }
        return fakehead.next;
    }
}
