package leetcodedebug;
import java.util.ArrayList;
public class combinationsum {
	ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> re = new ArrayList<Integer>();
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ret.clear();
        re.clear();
        helper(candidates,0,target);
        return ret;
    }
    public void helper(int[] can, int index, int target)
    {
        if(target == 0)
        {
        	ret.add((ArrayList<Integer>) re.clone());
        	return;
        }
        int i = index;
        while(i<can.length&&can[i]<=target)
        {
            re.add(can[i]);
            helper(can,i,target-can[i]);
            re.remove(re.size()-1);
            i++;
        }
    }
    public static void main(String[] args)
	{
    	combinationsum test = new combinationsum();
    	int[] a ={1,2};
    	System.out.println(test.combinationSum(a,2));
	}
}
