package leetcodedebug;

import java.util.ArrayList;

public class restoreip {
    ArrayList<String> ret = new ArrayList<String>();
    ArrayList<String> temp = new ArrayList<String>();
    public ArrayList<String> restoreIpAddresses(String s) {
        ret.clear();
        temp.clear();
        helper(s,0);
        return ret;
    }
    public void helper(String s, int count)
    {
        if(count==3){
        	if(s.charAt(0)=='0'&&s.length()>1)
        		return;
            if(s.length()>3){
                int hh = 0;
                while(s.length()-hh>3){
                    if(s.charAt(hh)!='0')   return;
                    hh++;
                }
            }
            if(Integer.parseInt(s)>255) return;
            else{
                temp.add(s);
                String ss = "";
                for(int i=0;i<4;i++)
                {
                    ss=ss+"."+temp.get(i);
                }
                ss=ss.substring(1);
                ret.add(ss);
                temp.remove(temp.size()-1);
            }
        }
        else{
            for(int i=0;i<s.length()-3+count;i++)
            {
            	if(Integer.parseInt(s.substring(0,i+1))>255)
            		break;
                temp.add(s.substring(0,i+1));
                helper(s.substring(i+1,s.length()),count+1);
                temp.remove(temp.size()-1);
                if(s.charAt(0)=='0')	
                	break;
            }
        }
    }
}
