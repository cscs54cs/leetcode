package leetcodedebug;

public class spiralmatrixii {
    public int[][] generateMatrix(int n) {
        int[][] ret = new int[n][n];
        helper(0,ret,1);
        return ret;
    }
    public void helper(int count, int[][] ret,int num){
        int len = ret.length;
        if(count>(len-1)/2) return;
        for(int i=count;i<len-count;i++){
            ret[count][i] = num++;
        }
        for(int i=count+1;i<len-count;i++){
            ret[i][len-count-1] = num++;
        }
        for(int i=len-count-2;i>=count;i--){
            ret[len-count-1][i] = num++;
        }
        for(int i=len-count-2;i>count;i--){
            ret[i][count] = num++;
        }
        helper(count+1,ret,num);            
    }
}
