package leetcodedebug;

public class recoverBST {
    public void recoverTree(TreeNode root) {
        TreeNode cur=root;
        TreeNode pre = new TreeNode(Integer.MIN_VALUE);
        TreeNode bad1=null,bad2=null,ttemp=null;
        while(cur!=null){
            if(cur.left!=null){
                TreeNode temp = cur.left;
                while(temp.right!=null&&temp.right!=cur){
                    temp=temp.right;
                }
                if(temp.right==null){
                    temp.right=cur;
                    cur = cur.left;
                }
                else if(temp.right==cur){                                       
                    if(pre.val>cur.val){
                        if(bad1==null){
                            bad1=pre;
                            ttemp = cur;
                        }
                        else{
                            bad2=cur;
                        }
                    }
                    pre = cur; 
                	cur = cur.right;
                	temp.right=null;
                }
            }
            else{
                 if(pre.val>cur.val){
                    if(bad1==null){
                        bad1=pre;
                        ttemp=cur;
                    }
                    else{
                        bad2=cur;
                    }
                }
                pre=cur;
                cur = cur.right;
            }
        }
        int temp;
        if(bad2==null)	bad2=ttemp;
        temp = bad1.val;
        bad1.val = bad2.val;
        bad2.val = temp;
    }
}
