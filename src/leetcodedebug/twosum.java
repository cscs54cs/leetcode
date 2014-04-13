package leetcodedebug;

import java.util.HashMap;
import java.util.LinkedList;

import javax.swing.text.html.HTMLDocument.Iterator;

public class twosum {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, LinkedList<Integer>> h = new HashMap<Integer,LinkedList<Integer>>();
        int len = numbers.length;
        int in1=0,in2=0;
        int[] in = new int[2];
        for(int i=0;i<len;i++){
            if(!(h.containsKey(numbers[i]))){
                LinkedList<Integer> ltemp = new LinkedList<Integer>();
                ltemp.add(i);
                h.put(numbers[i],ltemp);
            }
            else{
                h.get(numbers[i]).add(i);
            }
        }
        for(int i=0;i<len;i++){
            if((target!=2*numbers[i])&&h.containsKey(target-numbers[i])){
                in1=i;
                in2= h.get(target-numbers[i]).peekFirst();
                break;
            }
            if((target==2*numbers[i])&&h.get(numbers[i]).size()>1){
                in1 = h.get(target-numbers[i]).peekFirst();
                in2 = h.get(target-numbers[i]).peekLast();
            }
        }
        in[0] = 1+Math.min(in1,in2);
        in[1] = 1+Math.max(in1,in2);
        return in;
        
    }
}
