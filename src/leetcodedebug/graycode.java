package leetcodedebug;

import java.util.ArrayList;

public class graycode {
    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if(n==1){
            ret.add(0);
            ret.add(1);
            return ret;
        }
        else{
            ArrayList<Integer> re = grayCode(n-1);
            ret.addAll(re);
            for(int i=re.size()-1;i>-1;i--){
                ret.add(re.get(i)|(1<<(n-1)));
            }
        }
        return ret;
    }
}
