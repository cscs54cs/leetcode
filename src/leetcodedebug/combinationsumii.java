package leetcodedebug;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationsumii {
	ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> re = new ArrayList<Integer>();
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
    	ret.clear();
        re.clear();
        boolean[] added = new boolean[num.length];
        Arrays.sort(num);
        helper(num,0,target,added);
        return ret;
    }
    public void helper(int[] can, int index, int target,boolean[] added)
    {
        if(target == 0)
        {
        	ret.add((ArrayList<Integer>) re.clone());
        	return;
        }
        int i = index;
        while(i<can.length&&can[i]<=target)
        {
            if(i>0&&can[i]==can[i-1]){
                if(added[i]){
                    re.add(can[i]);
                    added[i]=true;
                }
            }
            else{
                re.add(can[i]);
                added[i]=true;
            }
            
            helper(can,i+1,target-can[i],added);
            if(added[i]==true){
                re.remove(re.size()-1);
                added[i]=false;
            }

            i++;
        }
    }
}
