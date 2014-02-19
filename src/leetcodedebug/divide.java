package leetcodedebug;

public class divide {
	public int divide(int dividend, int divisor) {
        boolean flag = false;
        flag = (dividend<0)^(divisor<0);
        long dend = dividend;
        long dsor = divisor;
        dend = Math.abs(dend);
        dsor = Math.abs(dsor);
        int ret=0,i=0;
        while(dend>=dsor)
        {
            while(dend>=(dsor<<i))
            {
                i++;
            }
            i--;
            dend = dend-(dsor<<i); 
            ret = ret + (1<<i);
            i=0;
        }
        if(flag)
        	return 0-ret;
        return ret;
    }
}
