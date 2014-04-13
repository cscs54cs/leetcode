package leetcodedebug;

public class reverseint {
    public int reverse(int x) {
        boolean isneg = (x<0);
        int div=1;
        int num = Math.abs(x);
        while(num/div>=10){
            div*=10;
        }
        int result=0,count=1;
        while(num>0){
            result +=  count*(num/div);
            count *= 10;
            num=num%div;
            div/=10;
        }
        if(isneg){
            result=0-result;
        }
        return result;
    }
}
