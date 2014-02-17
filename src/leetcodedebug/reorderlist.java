package leetcodedebug;

public class reorderlist {
	public void reorderList(ListNode head) {
        if(head==null)  return;
        if(head.next==null) return;
        ListNode slow=head,fast=head,lcur,rcur,pre=null,ret;
        int flag = 1;
        while(fast!=null)
        {
            pre=slow;
            slow=slow.next;
            fast=fast.next;
            if(fast!=null)
            {
                fast=fast.next;
            }
        }
        pre.next=null;
        slow = rev(slow);
        ret=head;
        lcur=head.next;
        rcur=slow;
        while(lcur!=null&&rcur!=null)
        {
            if(flag==1)
            {
                ret.next=rcur;
                ret=ret.next;
                rcur=rcur.next;
                flag=0;
            }
            if(flag==0)
            {
                ret.next=lcur;
                ret=ret.next;
                lcur=lcur.next;
                flag=1;
            }
        }
        if(lcur!=null)  ret.next=lcur;
        if(rcur!=null)  ret.next=rcur;
    }
    public ListNode rev(ListNode head)
    {
        if(head==null)  return head;
        ListNode nhead,pre=null,cur=head,nex;
        while(cur!=null)
        {
            nex=cur.next;
            cur.next=pre;
            pre=cur;
            cur=nex;
        }
        return pre;
    }
}
