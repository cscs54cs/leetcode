package leetcodedebug;

public class ListnodePartition {
    public ListNode partition(ListNode head, int x) {
        ListNode less=new ListNode(0);
        ListNode more=new ListNode(0);
        ListNode lcur=less,mcur=more,cur=head;
        while(cur!=null)
        {
            if(cur.val<x)
            {
                lcur.next=cur;
                lcur=lcur.next;
            }
            else
            {
                mcur.next=cur;
                mcur=mcur.next;
            }
            cur=cur.next;
        }
        lcur.next=more.next;
        return less.next;
        
    }

}
