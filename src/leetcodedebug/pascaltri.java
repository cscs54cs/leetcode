package leetcodedebug;

import java.util.ArrayList;

public class pascaltri {
	public ArrayList<Integer> getRow(int rowIndex) {
        int i,j,k;
        int left,right;
        ArrayList<Integer> ret = new ArrayList<Integer>();
        ret.add(1);
        if(rowIndex==0)	return ret;
        ret.add(1);
        for(i=1;i<rowIndex;i++)
        {
            for(j=ret.size()-1;j>=0;j--)
            {
                if(j==ret.size()-1)
                {
                	ret.add(1);
                	ret.set(j,ret.get(j)+ret.get(j-1));
                }
                else if(j==0)
                {
                	ret.set(0,1);
                }
                else
                {
                	ret.set(j,ret.get(j)+ret.get(j-1));
                }
            }
            //System.out.println(ret);
        }
        return ret;
    }
	public static void main(String[] args)
	{
		pascaltri test = new pascaltri();
		System.out.println(test.getRow(5));
	}
}
