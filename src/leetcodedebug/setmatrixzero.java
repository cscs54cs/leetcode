package leetcodedebug;

public class setmatrixzero {
    public void setZeroes(int[][] matrix) {
        int rowlen = matrix.length;
        if(rowlen==0)   return;
        int collen = matrix[0].length;
        boolean rowflag = false, colflag = false;
        int i=0,j=0;
        for(i=0;i<rowlen;i++)
        {
            if(matrix[i][0]==0)
            {
                colflag = true;
                break;
            }
        }
        for(i=0;i<collen;i++)
        {
            if(matrix[0][i] ==0)
            {
                rowflag = true;
                break;
            }
        }
        for(i=0;i<rowlen;i++){
            for(j=0;j<collen;j++){
                if(matrix[i][j]==0)
                {
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        for(i=1;i<collen;i++)
        {
            if(matrix[0][i]==0){
                setcol(matrix,rowlen,collen,i);
            }
        }
        for(i=1;i<rowlen;i++)
        {
            if(matrix[i][0]==0){
                setrow(matrix,rowlen,collen,i);
            }
        }
        if(rowflag)
        {
            setrow(matrix,rowlen,collen,0);
        }
        if(colflag)
        {
            setcol(matrix,rowlen,collen,0);
        }
    }
    void setrow(int[][] matrix, int rowlen,int collen, int rowid)
    {
        for(int i=0;i<collen;i++)
        {
            matrix[rowid][i]=0;
        }
    }
    void setcol(int[][] matrix, int rowlen,int collen, int colid)
    {
        for(int i=0;i<rowlen;i++)
        {
            matrix[i][colid]=0;
        }
    }
}
