package leetcodedebug;

import java.util.ArrayList;

public class combinations {
	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        if(n<k) return null;
        int i,j,m;
        ArrayList<ArrayList<Integer>> all = new ArrayList<ArrayList<Integer>>();
        if(k==1)
        {
            for(i=1;i<=n;i++)
            {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                temp.add(new Integer(i));
                all.add(temp);
            }
            return all;
        }
        all.addAll(combine(n-1,k));
        for(ArrayList<Integer> sublist:combine(n-1,k-1))
        {
            sublist.add(n);
            all.add(sublist);
        }
        return all;
    }
	public static void main(String[] args)
	{
		combinations test=new combinations();
		test.combine(2,2);
	}
}
