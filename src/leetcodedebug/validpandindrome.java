package leetcodedebug;

import java.util.ArrayList;

public class validpandindrome {
	 public boolean isPalindrome(String s) {
	        s=s.toLowerCase();
	        int i=0,start=-1,end=-1;
	        boolean flag=true;
	        ArrayList<Character> sn = new ArrayList<Character>();
	        for(i=0;i<s.length();i++)
	        {
	        	if((s.charAt(i)>='a'&&s.charAt(i)<='z')||(s.charAt(i)>='0'&&s.charAt(i)<='9'))
	            {
	                sn.add(s.charAt(i));
	            }
	        }
	        for(i=0;i<sn.size()/2&&flag;i++)
	        {
	            flag = (sn.get(i)==sn.get(sn.size()-1-i));
	        }
	        return flag;
	    }
	 public static void main(String[] args)
	{
		String s = "1a2";
		validpandindrome test = new validpandindrome();
		System.out.print(test.isPalindrome(s));
	}
}
