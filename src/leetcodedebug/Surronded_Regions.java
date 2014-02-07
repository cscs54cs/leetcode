package leetcodedebug;


public class Surronded_Regions {
	
	public void solve(char[][] board) {
		
		int x=board.length;
        if(x==0)    return;
        int y =board[0].length;
        if(x==1&&y==1)  return;
        boolean[][] visited = new boolean[x][y];
        for(int i =0; i< x;i++)
        {
            for(int j =0;j<y;j++)
            {
                if(board[i][j]=='O')
                {
                	clearvisited(visited);
                    if(check(board,i,j,visited))
                    {
                        fill(board,i,j);
                    }
                }
            }
        }
    }
	public void clearvisited(boolean[][] visited)
	{
		int x = visited.length;
		int y = visited[0].length;
		for(int i=0;i<x;i++)
		{
			for(int j=0;j<y;j++)
			{
				visited[i][j]=false;
			}
		}
	}
    public boolean check(char[][] board, int x, int y,boolean[][] visited)
    {
    	visited[x][y]=true;
        if(board[x][y]!='O')    return true;
        boolean left=true,right=true,up=true,down=true;
        if((x==0||x==board.length-1||y==0||y==board.length-1))
            return false;
        else
        {
            if(x>0&&!(visited[x-1][y]))
            {
                left = check(board,x-1,y,visited);
            }
            if(x<board.length-1&&!(visited[x+1][y]))
            {
                right = check(board,x+1,y,visited);
            }
            if(y>0&&!(visited[x][y-1]))
            {
                down = check(board,x,y-1,visited);
            }
            if(y<board[0].length-1&&!(visited[x][y+1]))
            {
                up = check(board,x,y+1,visited);
            }
            return (left&&up&&down&&right);
        }
    }
    public void fill(char[][] board, int x, int y)
    {
        if(board[x][y]!='O')    return;
        board[x][y]='X';
        if(x>0)
        {
            fill(board,x-1,y);
        }
        if(x<board.length-1)
        {
            fill(board,x+1,y);
        }
        if(y>0)
        {
            fill(board,x,y-1);
        }
        if(y<board[0].length-1)
        {
            fill(board,x,y+1);
        }
    }
    public static void main(String[] argv)
	{
    	Surronded_Regions test = new Surronded_Regions();
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
