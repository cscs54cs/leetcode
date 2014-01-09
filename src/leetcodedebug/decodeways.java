package leetcodedebug;

public class decodeways {
	public int numDecodings(String s) {
        if(s.length()==0)   return 0;
        int[] count = new int[s.length()];
        cway(s,count);
        return count[count.length-1];
    }
    public void cway(String s,int[] count)
    {
        if(Integer.parseInt(s.substring(0,1))>0)
            count[0]=1;
        else
        {
            count[count.length-1]=0;
            return;
        }
        if(count.length==1) return;
        if(Integer.parseInt(s.substring(0,2))<27&&Integer.parseInt(s.substring(1,2))!=0)
        {
            count[1]=2;
        }
        if(s.charAt(1)=='0')
        {
            if(Integer.parseInt(s.substring(0,2))>26)
            {
                count[count.length-1]=0;
                return;
            }
            else
            {
                count[1]=1;
            }
        }
        for(int i =2;i<count.length;i++)
        {
            
            count[i]=0;
            if(s.charAt(i)=='0'&&Integer.parseInt(s.substring(i-1,i+1))>26)
            {
                count[count.length-1]=0;
                return;
            }
            if(Integer.parseInt(s.substring(i-1,i+1))<27)
            {
                count[i]=count[i]+count[i-2];
            }
            if(Integer.parseInt(s.substring(i,i+1))<10&&Integer.parseInt(s.substring(i,i+1))>0)
            {
                count[i]=count[i]+count[i-1];
            }
        }
    }
    public static void main(String[] args)
	{
		String s = "27";
		decodeways test = new decodeways();
		System.out.println(test.numDecodings(s));
	}
}
