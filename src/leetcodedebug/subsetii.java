package leetcodedebug;

import java.util.ArrayList;
import java.util.Arrays;

public class subsetii {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        return helper(num,0);
    }
    public ArrayList<ArrayList<Integer>> helper(int[] num,int start){
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        boolean flag = false;
        if(start==num.length){
            ret.add(new ArrayList<Integer>());
            return ret;
        }
        int end=start+1;
        while(end<num.length&&num[end]==num[start]){
            end++;
        }
        ArrayList<Integer> aa = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> re=helper(num,end);
        for(int i=start;i<end;i++){
            aa.add(num[start]);
            for(ArrayList<Integer> partsub:re){
                ArrayList<Integer> bb = (ArrayList<Integer>)aa.clone();
                bb.addAll(partsub);
                ret.add(bb);
            }
        }
        ret.addAll(re);
        return ret;
        
    }
}
