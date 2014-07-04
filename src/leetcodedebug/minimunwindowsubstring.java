package leetcodedebug;

public class minimunwindowsubstring {
    public String minWindow(String S, String T) {
        int start=0,end=0;
        String result = "";
        int[] expect = new int[256];
        int[] lcount = new int[256];
        int found=0,min=Integer.MAX_VALUE,temp;
        int i,j,k;
        for(i=0;i<T.length();i++){
            expect[(int)T.charAt(i)]++;
        }
        while(end<S.length())
        {
            lcount[(int)S.charAt(end)]++;
            if(expect[(int)S.charAt(end)]>0&&expect[(int)S.charAt(end)]>=lcount[(int)S.charAt(end)]){
                found++;
            }
            if(found<T.length()){
                end++;
            }
            else{
                while(expect[(int)S.charAt(start)]==0||lcount[(int)S.charAt(start)]>expect[(int)S.charAt(start)])
                {
                	lcount[(int)S.charAt(start++)]--;
                }
                temp = end - start+1;
                if(min>temp){
                    min =temp;
                    result = S.substring(start,end+1);
                }
                end++;
            }
        }
        return result;   
    }
}
