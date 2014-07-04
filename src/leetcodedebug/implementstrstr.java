package leetcodedebug;

public class implementstrstr {
	public String strStr(String haystack, String needle) {
        if(needle.length()==0){
            return haystack;
        }
        if(haystack.length()<needle.length()){
            return null;
        }
        int[] ta = helper(needle);
        int i=0,m=0;
        while(i<needle.length()&&m+i<haystack.length()){
            if(haystack.charAt(m+i)==needle.charAt(i)){
                i++;
            }
            else{
                m=m-ta[i]+i;
                i=ta[i];
                if(i==-1){
                    i=0;
                }
            }
        }
        if(i==needle.length())
        {
            return haystack.substring(m);
        }
        else
            return null;
    }
    public int[] helper(String s)
    {
        int len = s.length();
        int[] ta = new int[len];
        int pos=2,cnd=0;
        if(len==1){
            ta[0]=-1;
            return ta;
        }
        ta[0]=-1;
        ta[1]=0;
        if(len==2){
            return ta;
        }
        while(pos<len){
            if(s.charAt(pos-1)==s.charAt(cnd)){
                ta[pos++]=++cnd;
            }
            else if(cnd>0){
                cnd=ta[cnd];
            }
            else{
                ta[pos++]=0;
            }
        }
        return ta;
       
    }
}
