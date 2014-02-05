package leetcodedebug;

import java.util.Stack;

public class Maximal_Rectangle {
	public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0)    return 0;
        int x = matrix.length;
        int y = matrix[0].length;
        int[][] h = new int[matrix.length+1][matrix[0].length];
        for(int i =0; i<x;i++ )
        {
            int count =0;
            for(int j =y-1; j>=0 ; j--)
            {
                if(matrix[i][j]=='1')
                {
                    count++;
                    h[i][j]=count;
                }
                else
                {
                    count=0;
                    h[i][j]=0;
                }
            }
        }
        Stack<Integer> st = new Stack<Integer>();
        int maxarea =0;
        int j=0;
        for(int i =0; i<y;i++)
        {
            j=0;
            st.clear();
            while(j<x+1)
            {
                if(st.isEmpty()||h[j][i]>=h[st.peek()][i])
                {
                    st.push(j);
                    j++;
                }
                else
                {
                    int t = st.pop();
                    maxarea=Math.max(maxarea,h[t][i]*(st.isEmpty() ? j : j-st.peek()-1));
                }
            }
        }
        return maxarea;
    }
	public static void main(String[] argv)
	{
		Maximal_Rectangle test = new Maximal_Rectangle();
		char[][] h = {{'0','1'}};
		int ret=test.maximalRectangle(h);
		System.out.print(ret);
	}
}
