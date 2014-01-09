package leetcodedebug;

import java.util.ArrayList;

public class nqueen {
	ArrayList<String[]> ret = new ArrayList<String[]>();
    public ArrayList<String[]> solveNQueens(int n) {
        int[] column = new int[n];
        ret.clear();
        place(0,column,n);
        return ret;
    }
    public void place(int row,int[] column,int n)
    {
        if(row == n)    
        {
        	createsolution(column,n);
        	return;
        }
        int i =0;
        for(i=0;i<n;i++)
        {
            column[row]=i;
            if(check(row,column))
            {
                place(row+1,column,n);
            }
        }
    }
    public boolean check(int row,int[] column)
    {
        int i =0;
        for(i=0;i<row;i++)
        {
            int diff = Math.abs(column[i]-column[row]);
            if(diff==0||diff==Math.abs(i-row))
                return false;
        }
        return true;
    }
    public void createsolution(int[] column,int n)
    {
        String[] solution = new String[n];
        char[]  row = new char[n];
        for(int i=0;i<n;i++)
        {
            for(int j =0;j<n;j++)
            {
                if(j!=column[i])
                    row[j]='.';
                else
                    row[j]='Q';
            }
            solution[i]=new String(row);
        }
        ret.add(solution);
    }
    public static void main( String[] args )
	{
    	nqueen test = new nqueen();
		System.out.print(test.solveNQueens(1));
	}
}
