package leetcodedebug;

public class test {
    public static void main(String[] args)
	{
    	populatetree test = new populatetree();
    	TreeLinkNode l1 = new TreeLinkNode(1);
    	l1.right = new TreeLinkNode(-9);
    	l1.right.right = new TreeLinkNode(8);
    	l1.right.right.left = new TreeLinkNode(4);
    	l1.right.right.right = new TreeLinkNode(-3);
    	l1.right.right.right.left = new TreeLinkNode(3);
    	test.connect(l1);
	}
}
