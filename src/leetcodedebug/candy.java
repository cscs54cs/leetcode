package leetcodedebug;

public class candy {
	public int candy(int[] ratings) {
        int len = ratings.length;
        if(len==0)  return 0;
        int[] candy=new int[len];
        int[] candy1=new int[len];
        int i,ret=0;
        for(i=0;i<len;i++)
        {
            candy[i]=1;
            candy1[i]=1;
        }
        for(i=1;i<len;i++)
        {
            if(ratings[i]>ratings[i-1]) candy[i]=candy[i-1]+1;
        }
        for(i=len-2;i>-1;i--)
        {
            if(ratings[i]>ratings[i+1]) candy1[i]=candy1[i+1]+1;
        }
        for(i=0;i<len;i++)
        {
            ret=ret+Math.max(candy[i],candy1[i]);
        }
        return ret;
    }
}
