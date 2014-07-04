package leetcodedebug;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class SubstringwithConcatenationofAllWords {
	public List<Integer> findSubstring(String S, String[] L) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int i=0,j=0,count=0;
        if(L.length==0){
            for(i=0;i<S.length();i++){
                result.add(i);
            }
            return result;
        }
        HashMap<String,Integer> hm1 = new HashMap<String,Integer>();
        HashMap<String,Integer> hcount = new HashMap<String,Integer>();
        HashMap<String,Integer> htemp;
        int strlen = L[0].length();
        int len = S.length();
        int[] arr = new int[len];
        for(i=0;i<L.length;i++){
            hm1.put(L[i],i);
            if(hcount.get(L[i])==null){
            	hcount.put(L[i],1);
            }
            else{
            	hcount.put(L[i], hcount.get(L[i])+1);
            }
        }
        for(i=0;i<=len-strlen;i++){
            if(hm1.containsKey(S.substring(i,i+strlen))){
                arr[i]=hm1.get(S.substring(i,i+strlen));
            }
            else{
                arr[i]=-1;
            }
        }

        for(i=0;i<=len-strlen*L.length;i++){
            j=i;
            count = 0;
            htemp =(HashMap<String,Integer>)hcount.clone();
            while(j<=len-strlen){
                if(arr[j]==-1){
                    break;
                }
                if(htemp.get(L[arr[j]])==null){
                    break;
                }
                else{
                    htemp.put(L[arr[j]], htemp.get(L[arr[j]])-1);
                    if(htemp.get(L[arr[j]])==0){
                    	htemp.remove(L[arr[j]]);
                    }
                    j=j+strlen;
                    if(htemp.size()==0){
                        result.add(i);
                    }
                }
            }
        }
        return result;
    }
}
