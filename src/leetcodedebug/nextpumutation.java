package leetcodedebug;

public class nextpumutation {
	public void nextPermutation(int[] num) {
        int i,j,k,notde,firstlar,temp;
        int len=num.length;
        if(len==1)  return;
        for(i=len-1;i>0;i--)
        {
            if(num[i-1]<num[i])
                break;
        }
        notde=i-1;
        if(num[0]>=num[1])
        {
            for(j=0;len-j-1>j;j++)
            {
                temp=num[j];
                num[j]=num[len-j-1];
                num[len-j-1]=temp;
            }
            return;
        }
        for(i=len-1;i>notde;i--)
        {
            if(num[i]>num[notde])
            {
                temp=num[notde];
                num[notde]=num[i];
                num[i]=temp;
                break;
            }
        }
        for(j=notde+1;len-(j-notde)>j;j++)
        {
            temp=num[j];
            num[j]=num[len-(j-notde)];
            num[len-(j-notde)]=temp;
        }
        
    }
	public static void main(String[] args)
	{
		int[] num={2,1,3};
		nextpumutation test = new nextpumutation();
		test.nextPermutation(num);
	}
}
