package leetcodedebug;

public class sortedarraytobst {
    public TreeNode sortedArrayToBST(int[] num) {
        if(num.length==0)
            return null;
        if(num.length==1)
            return new TreeNode(num[0]);
        return buildtree(num,0,num.length-1);
    }
    public TreeNode buildtree(int[] num, int start, int end)
    {
        if(start==end)  return new TreeNode(num[start]);
        if(start<end)   return null;
        int middle=(start+end)/2;
        TreeNode root = new TreeNode(num[middle]);
        root.left=buildtree(num,start,middle-1);
        root.right=buildtree(num,middle+1,end);
        return root;
    }
    public static void main(String[] args)
	{
		sortedarraytobst test =new sortedarraytobst();
		int[] num = {1,3};
		test.sortedArrayToBST(num);
	}
}
