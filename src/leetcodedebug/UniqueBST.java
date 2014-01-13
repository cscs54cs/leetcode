package leetcodedebug;

public class UniqueBST {
	public int numTrees(int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(n==1)    return 1;
        if(n==2)    return 2;
        if(n==3)    return 5;
        int result=0;
        if(n%2==0)
        {
            result = numTrees(n-1);
            int i =0;
            for (i=1;i<=(n-1)/2;i++)
            {
                result = result+numTrees(i)*numTrees(n-1-i);
            }
            result = 2 * result;
        }
        else
        {
            int i =0;
            result = 2*numTrees(n-1);
            for (i=1;i<(n-1)/2;i++)
            {
                result = result+ 2*numTrees(i)*numTrees(n-1-i);
            }
            result = result + numTrees((n-1)/2) * numTrees((n-1)/2);
        }
            return result;
    }
}
