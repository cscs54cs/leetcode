package leetcodedebug;

public class bestselliii {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len <=1)  return 0;
        int[] shun = new int [len];
        int[] ni = new int[len];
        int minleft = prices[0];
        int maxright = prices[len-1];
        int ret = Integer.MIN_VALUE;
        shun[0]=0;
        ni[len-1]=0;
        for(int i = 1;i<len;i++)
        {
            if(prices[i]<minleft)
                minleft = prices[i];
            if(prices[i]-minleft>shun[i-1])
                shun[i]=prices[i]-minleft;
            else
            	shun[i]=shun[i-1];
        }
        for(int i=len-2;i>-1;i--)
        {
            if(prices[i]>maxright)
                maxright = prices[i];
            if(maxright-prices[i]>ni[i+1])
                ni[i]=maxright-prices[i];
            else
            	ni[i]=ni[i+1];
            if(i>0&&ni[i]+shun[i-1]>ret)
                ret = ni[i]+shun[i-1];
        }
        if(ni[0]+shun[0]>ret)
        	ret = 0+shun[0];
        if(0+shun[len-1]>ret)
        	ret = 0+shun[len-1];
        return ret;
    }
}
