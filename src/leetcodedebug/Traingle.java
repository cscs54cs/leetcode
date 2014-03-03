package leetcodedebug;

import java.util.ArrayList;

public class Traingle {
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        int len = triangle.size();
        int count =0;
        ArrayList<Integer> last = (ArrayList<Integer>)triangle.get(len-1).clone();
        for(int i= len-2;i>=0;i--){
        	ArrayList<Integer> temp = triangle.get(i);
            for( int j=0;j<triangle.get(i).size();j++)
            {
                int ret = temp.get(j);
                ret = ret+Math.min(last.get(j),last.get(j+1));
                last.set(count,ret);
                count++;
            }
            count=0;
            last.remove(last.size()-1);
        }
        return last.get(0);
    }
}
