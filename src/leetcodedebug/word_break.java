package leetcodedebug;

import java.util.HashSet;
import java.util.Set;

public class word_break {
	public boolean wordBreak(String s, Set<String> dict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0]=true;
        for(int i=1;i<=s.length();i++)
        {
            for(int j=0;j<i;j++)
            {
                dp[i]=dp[i]||(dict.contains(s.substring(j,i))&&dp[j]);
            }
        }
        return dp[s.length()];
    }
	public static void main(String[] argv)
	{
		Set<String> dict = new HashSet<String>();
		String s = "dogs";
		dict.add("dog");
		dict.add("s");
		dict.add("gs");
		word_break test = new word_break();
		test.wordBreak(s, dict);
	}
}
