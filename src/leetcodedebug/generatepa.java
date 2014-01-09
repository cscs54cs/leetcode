package leetcodedebug;

import java.util.ArrayList;

public class generatepa {
	ArrayList<String> ret = new ArrayList<String>();
    public ArrayList<String> generateParenthesis(int n) {
        ret.clear();
        char[] str = new char[2*n];
        ghelper(n,n,str,0);
        return ret;
    }
    public void ghelper(int l,int r,char[] str,int count)
    {
        if(r<0||r<l)    return;
        if(r==0&&l==0)
        {
            ret.add(new String(str));
        }
        else
        {
            if(l>0)
            {
                str[count]='(';
                ghelper(l-1,r,str,count+1);
            }
            if(r>l)
            {
                str[count]=')';
                ghelper(l,r-1,str,count+1);
            }
        }
        
    }
}
