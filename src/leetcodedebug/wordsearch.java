package leetcodedebug;

import java.util.ArrayList;

public class wordsearch {
	public boolean exist(char[][] board, String word) {
        int xlen,ylen;
        xlen = board[0].length;
        ylen=board.length;
        boolean[][] visited = new boolean[ylen][xlen];
        boolean flag = false;
        int x,y,i;
        //if(word.length()>xlen*ylen) return false;
        i=0;
        
        for(x=0;x<xlen;x++)
        {
            for(y=0;y<ylen;y++)
            {
                if(board[y][x]==word.charAt(0))
                {
                    flag=flag||sea(board,word,1,visited,x,y,xlen,ylen);
                    if(flag)
                        return true;
                }
            }
        }
        return flag;
    }
    public boolean sea(char[][] board,String word,int index,boolean[][] visited,int x,int y,int xlen,int ylen)
    {
        if(index==word.length())
            return true;
        boolean left,up,down,right;
        left = false;
        up = false;
        right = false;
        down = false;
        if(x>0)
        {
            if(board[y][x-1]==word.charAt(index)&&(!visited[y][x-1]))
            {
                visited[y][x-1]=true;
                left = sea(board,word,index+1,visited,x-1,y,xlen,ylen);
                visited[y][x-1]=false;
            }
            if(left == true)
                return true;
        }
        if(x<xlen-1)
        {
            if(board[y][x+1]==word.charAt(index)&&(!visited[y][x+1]))
            {
                visited[y][x+1]=true;
                right = sea(board,word,index+1,visited,x+1,y,xlen,ylen);
                visited[y][x+1]=false;
            }
            if(right == true)
                return true;
        }
        if(y>0)
        {
            if(board[y-1][x]==word.charAt(index)&&(!visited[y-1][x]))
            {
                visited[y-1][x]=true;
                up = sea(board,word,index+1,visited,x,y-1,xlen,ylen);
                visited[y-1][x]=false;
            }
            if(up == true)
                return up;
        }if(y<ylen-1)
        {
            if(board[y+1][x]==word.charAt(index)&&(!visited[y+1][x]))
            {
                visited[y+1][x]=true;
                down = sea(board,word,index+1,visited,x,y+1,xlen,ylen);
                visited[y+1][x]=false;
            }
            if(down == true)
                return true;
        }
        return up||down||left||right;
    }
    public static void main(String[] args)
	{
		wordsearch test = new wordsearch();
		char[][] board ={{'a','a'}};
		String word = "aaa";
		System.out.print(test.exist(board, word));
	}
}
