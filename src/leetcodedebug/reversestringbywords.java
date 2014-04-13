package leetcodedebug;

import java.util.ArrayList;

public class reversestringbywords {
    public String reverseWords(String s) {
        if(s.length()==0)   return s;
        String[] arr = s.split(" ");
        ArrayList<String> aa = new ArrayList<String>();
        if(arr.length == 0) return "";
        int i =0;
        while(i<arr.length)
        {
        	if(!(arr[i].equals(" ")||arr[i].equals("")))
        	{
                aa.add(arr[i]);
        	}
        	i++;
        }
        if(aa.size()==0)	return "";
        String ret=aa.get(aa.size()-1);
        for(i=aa.size()-2;i>-1;i--){
            ret = ret+" "+aa.get(i);
        }
        return ret;
        
    }
}
