package leetcodedebug;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class wordbreak2 {
	ArrayList<String> ret =new ArrayList<String>();
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        ret.clear();
        boolean[] dp = new boolean[s.length()+1];
        helper(s,dict,dp);
        ret = print(s,dp,dict);
        return ret;
    }
    public ArrayList<String> print(String s, boolean[] dp,Set<String> dict)
    {
        
        ArrayList<String> re = new ArrayList<String>();
        //if(s.length()==0)   return null;
        for(int i = s.length()-1;i>=0;i--)
        {
            if(dp[i]==true&&dict.contains(s.substring(i,s.length())))
            {
            	if(i==0)	re.add(s.substring(i,s.length()));
                for(String rs : print(s.substring(0,i),dp,dict))
                {
                    rs = rs+" "+s.substring(i,s.length());
                    re.add(rs);
                }
            }
        }
        return re;
    }
    public void helper(String s, Set<String> dict,boolean[] dp) {
        dp[0]=true;
        for(int i=1;i<=s.length();i++)
        {
            for(int j=0;j<i;j++)
            {
                dp[i]=dp[i]||(dict.contains(s.substring(j,i))&&dp[j]);
            }
        }
    }
	public static void main(String[] argv)
	{
		Set<String> dict = new HashSet<String>();
		String s = "ab";
		dict.add("a");
		dict.add("b");
		dict.add("gs");
		wordbreak2 test = new wordbreak2();
		ArrayList<String> ret = test.wordBreak(s, dict);
		for(int i=0;i<ret.size();i++)
		{
			System.out.println(ret.get(i));
		}
	}
}
