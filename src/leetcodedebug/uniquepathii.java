package leetcodedebug;

public class uniquepathii {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int m = obstacleGrid.length;
        if(m==0)    return 0;
        int n=obstacleGrid[0].length;
        int[][] a = new int[m][n];
        int i=0,j=0,left=0,right=0;
        a[0][0]=1;
        for(i=1;i<m;i++){
            if(a[i-1][0]==1&&obstacleGrid[i][0]!=1)
                a[i][0]=1;
            else
                a[i][0]=0;
        }
        for(i=1;i<n;i++){
            if(a[0][i-1]==1&&obstacleGrid[0][i]!=1)
                a[0][i]=1;
            else
                a[0][i]=0;
        }
        for(i=1;i<m;i++)
        {
            for(j=1;j<n;j++)
            {
                if(obstacleGrid[i][j]==1){
                    a[i][j]=0;
                    continue;
                }
                a[i][j]=a[i-1][j]+a[i][j-1];
            }
        }
        return a[m-1][n-1];
    }
}
