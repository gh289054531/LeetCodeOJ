package UniquePathsII;

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid==null||obstacleGrid.length<1||obstacleGrid[0].length<1){
            return 0;
        }
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] path=new int[m][n];
        for(int i=0;i<m;i++){
            if(obstacleGrid[i][0]==0){
                path[i][0]=1;
            }else{
                break;
            }
        }
        for(int i=0;i<n;i++){
            if(obstacleGrid[0][i]==0){
                path[0][i]=1;
            }else{
                break;
            }
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(obstacleGrid[i][j]!=1){
                    path[i][j]=path[i-1][j]+path[i][j-1];
                }
            }
        }
        return path[m-1][n-1];
    }
}