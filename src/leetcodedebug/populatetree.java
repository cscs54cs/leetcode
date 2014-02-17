package leetcodedebug;

public class populatetree {
    public void connect(TreeLinkNode root) {
        if(root==null)  return;
        TreeLinkNode pre = root,pren;
        TreeLinkNode cur = getleftwall(root),leftwall;
        while(pre!=null)
        {
            leftwall=getleftwall(pre);
            while(pre!=null)
            {
                
                if(pre.left!=null)
                {
                    if(pre.right!=null)
                    {
                        pre.left.next=pre.right;
                        pre.right.next=getnext(pre);
                    }
                    else
                    {
                        pre.left.next=getnext(pre);
                    }
                }
                else
                {
                    if(pre.right!=null)
                    {
                        pre.right.next=getnext(pre);
                    }
                }
                pre=pre.next;
            }
            pre=leftwall;
        }
        
    }
    public TreeLinkNode getleftwall(TreeLinkNode root)
    {
        TreeLinkNode cur = root;
        while(cur!=null)
        {
            if(cur.left!=null) return cur.left;
            if(cur.right!=null)    return cur.right;
            cur=cur.next;
        }
        return null;
    }
    public TreeLinkNode getnext(TreeLinkNode pre)
    {
        if(pre==null||pre.next==null)   return null;
        TreeLinkNode pren = pre.next;
        while(pren!=null)
        {
            if(pren.left!=null) return pren.left;
            if(pren.right!=null) return pren.right;
            pren=pren.next;
        }
        return null;
    }
}
