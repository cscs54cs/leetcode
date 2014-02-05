package leetcodedebug;

import java.util.Arrays;
import java.util.Stack;

public class largetrectangleinhitogram {
	public int largestRectangleArea(int[] height) {
        Stack<Integer> st = new Stack<Integer>();
        int maxarea = 0;
        int[] h = new int[height.length+1];
        h = Arrays.copyOf(height,height.length+1);
        for(int i=0;i<h.length;i++)
        {
            if(st.isEmpty()||h[st.peek()]<=h[i])
            {
                st.push(i);
            }
            else
            {
                int t = st.pop();
                maxarea = Math.max(maxarea,h[t]*(st.isEmpty()? i : i-st.peek()-1));
                i--;
            }
        }
        return maxarea;
    }
	public static void main(String[] argv)
	{
		largetrectangleinhitogram test = new largetrectangleinhitogram();
		int[] h = {1,1};
		test.largestRectangleArea(h);
	}
}
