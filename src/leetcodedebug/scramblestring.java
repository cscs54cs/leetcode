package leetcodedebug;

public class scramblestring {
	public boolean isScramble(String s1, String s2) {
        if(s1.equals(s2))   return true;
        int len = s1.length();
        int v1=0,v2=0;
        for(int i=0;i<len;i++)
        {
            v1 = v1+(int)s1.charAt(i);
            v2 = v2+(int)s2.charAt(i);
        }
        if(v1!=v2)
            return false;
        for(int i=0;i<len-1;i++)
        {
            if(isScramble(s1.substring(0,i+1),s2.substring(0,i+1))&&isScramble(s1.substring(i+1,len),s2.substring(i+1,len)))
                return true;
            if(isScramble(s1.substring(0,i+1),s2.substring(len-i-1,len))&&isScramble(s1.substring(i+1,len),s2.substring(0,len-i-1)))
                return true;
        }
        return false;
    }
	public static void main(String[] argv)
	{
		String s1 = "abcd",s2 = "bdac";
		scramblestring test = new scramblestring();
		System.out.print(test.isScramble(s1, s2));
	}
}
