package leetcodedebug;

import java.util.ArrayList;

public class spiralmatrix {
	ArrayList<Integer> ret = new ArrayList<Integer>();
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ret.clear();
        if(matrix.length==0)
            return ret;
        travelhelper(matrix,matrix.length,matrix[0].length);
        return ret;
    }
    public void travelhelper(int[][] matrix,int m,int n)
    {
        if(m==0||n==0)
        {
            return;
        }
        if(m==1&&n==1)
        {
            ret.add(matrix[matrix.length/2][matrix[0].length/2]);
        }
        else if(m==1)
        {
            for(int i =(matrix[0].length-n)/2 ;i<matrix[0].length-(matrix[0].length-n)*0.5;i++)
            {
                ret.add(matrix[matrix.length/2][i]);
            }
        }
        else if(n==1)
        {
            for(int i =(matrix.length-m)/2;i<matrix.length-(matrix.length-m)*0.5;i++)
            {
                ret.add(matrix[i][matrix[0].length/2]);
            }
        }
        else
        {
            for(int i =(matrix[0].length-n)/2 ;i<matrix[0].length-(matrix[0].length-n)/2;i++)
            {
                ret.add(matrix[(matrix.length-m)/2][i]);
            }
            for(int i =(matrix.length-m)/2+1;i<matrix.length-(matrix.length-m)/2;i++)
            {
            	//System.out.println(matrix.length-(matrix.length-n)/2);
                ret.add(matrix[i][matrix[0].length-(matrix[0].length-n)/2-1]);
            }
            for(int i =(matrix[0].length-(matrix[0].length-n)/2-2);i>=(matrix[0].length-n)/2;i--)
            {
                ret.add(matrix[matrix.length-(matrix.length-m)/2-1][i]);
            }
            for(int i =(matrix.length-(matrix.length-m)/2-2);i>=(matrix.length-m)/2+1;i--)
            {
                ret.add(matrix[i][(matrix[0].length-n)/2]);
            }
            travelhelper(matrix,m-2, n-2);
        }
        
    }
    public static void main(String[] args)
	{
    	spiralmatrix test = new spiralmatrix();
    	int[][] a={{1,2,3,4,5,6,7,8,9,10},
    			   {11,12,13,14,15,16,17,18,19,20},
    			   };
    	System.out.println(test.spiralOrder(a));
	}
}
