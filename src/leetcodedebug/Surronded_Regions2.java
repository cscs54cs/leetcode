package leetcodedebug;

import java.util.Stack;

public class Surronded_Regions2 {
	public void solve(char[][] board) {
		Stack<Integer> xs = new Stack<Integer>();
		Stack<Integer> ys = new Stack<Integer>();
		int x=board.length;
        if(x==0)    return;
        int y =board[0].length;
        int ii,jj;
        if(x<=2&&y<=2)  return;
        for(int i=0;i<x;i++)
        {
            if(board[i][0]=='O')
            {
                xs.push(i);
                ys.push(0);
            }
            if(board[i][y-1]=='O')
            {
                xs.push(i);
                ys.push(y-1);
            }
        }
        for(int j=1;j<y-1;j++)
        {
            if(board[0][j]=='O')
            {
                xs.push(0);
                ys.push(j);
            }
            if(board[x-1][j]=='O')
            {
                xs.push(x-1);
                ys.push(j);
            }
        }
        while(!xs.isEmpty()&&(!ys.isEmpty()))
        {
            ii=xs.pop();
            jj=ys.pop();
            board[ii][jj]='Y';
            if(ii>0&&board[ii-1][jj]=='O')
            {
                xs.push(ii-1);
                ys.push(jj);
            }
            if(ii<x-1&&board[ii+1][jj]=='O')
            {
                xs.push(ii+1);
                ys.push(jj);
            }
            if(jj>0&&board[ii][jj-1]=='O')
            {
                xs.push(ii);
                ys.push(jj-1);
            }
            if(jj<y-1&&board[ii][jj+1]=='O')
            {
                xs.push(ii);
                ys.push(jj+1);
            }
        }
        for(int i=0;i<x;i++)
        {
            for(int j=0;j<y;j++)
            {
                if(board[i][j]=='O')
                    board[i][j]='X';
                if(board[i][j]=='Y')
                    board[i][j]='O';
            }
        }
    }
	public static void main(String[] argv)
	{
    	Surronded_Regions2 test = new Surronded_Regions2();
    	char[][] board = {	{'O','X','X','O','X'},
	    					{'X','O','O','X','O'},
	    					{'X','O','X','O','X'},
	    					{'O','X','O','O','O'},
	    					{'X','X','O','X','O'},};
    	test.solve(board);
    	int x=board.length;
        int y =board[0].length;

        for(int i =0; i< x;i++)
        {
        	System.out.println(board[i]);
        }
	}
}
