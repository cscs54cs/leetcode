package leetcodedebug;

import java.util.ArrayList;

public class insertinterval {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> ret = new ArrayList<Interval>();
        Interval cur,n = newInterval;
        int start=n.start,end=n.end;
        boolean firsttime =true;
        if(intervals.size()==0){
            ret.add(n);
            return ret;
        }
        for(int i=0;i<intervals.size();i++){
            cur=intervals.get(i);
            if(cur.end<start){
                ret.add(cur);
            }
            else{
                if(cur.start<=n.start){
                    if(cur.end<=n.end){
                        n.start=cur.start;
                        continue;
                    }
                    if(cur.end>n.end)
                    {
                        return intervals;
                    }
                }
                else if(cur.start>n.start&&cur.start<=n.end){
                    if(cur.end<n.end){
                        continue;
                    }
                    if(cur.end>n.end){
                        n.end=cur.end;
                        continue;
                    }
                }
                else if(cur.start>n.end){
                    if(firsttime){
                        firsttime=false;
                        ret.add(n);
                    }
                    ret.add(cur);
                }
            }
        }
        if(firsttime){
            firsttime=false;
            ret.add(n);
        } 
        return ret;
    }
}
