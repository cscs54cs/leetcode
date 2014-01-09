package leetcodedebug;

public class plusone {
	public int[] plusOne(int[] digits) {
        int len = digits.length;
        int jinwei=0;
        int i =0;
        int temp=0;
        boolean notenough=false;
        for(i=len-1;i>=0;i--)
        {
            temp = digits[i]+jinwei+1;
            digits[i]=temp%10;
            jinwei=temp/10;
            if(i==0&&jinwei==1)
            {
                notenough=true;
            }
        }
        if(notenough)
        {
            int[] newdig = new int[len+1];
            newdig[0]=jinwei;
            for(i=1;i<len+1;i++)
            {
                newdig[i]=digits[i-1];
            }
            return newdig;
        }
        return digits;
    }
	public static void main(String[] args)
	{
		int[] d = {1,0};
		plusone test = new plusone();
		test.plusOne(d);
	}
}
