package com.pal;

public class CalculateIslands {
    int[][] islands = {{1, 0, 1, 0},
                       {0, 1, 0, 1},
                        {1, 1, 1, 0}
    };
    static int count;

    public static void main(String[] args){
        CalculateIslands calcIslands = new CalculateIslands();
        calcIslands.getIslands();
        System.out.println("No. of Islands="+count);
    }

    private void getIslands() {
        for (int i=0;i<islands.length;i++){
            for (int j=0;j<islands[0].length;j++){
                if(islands[i][j]==-1 || islands[i][j]==0)
                    continue;
                else{
                    countIslands(i,j);
                    count++;
                }
            }
        }
    }

    private void countIslands(int i, int j) {
        if(i>=0 && i<islands.length && j>=0 && j<islands[0].length){
            if(islands[i][j]==1){
                islands[i][j]=-1;

                countIslands(i,j+1);
                countIslands(i+1,j);
                countIslands(i,j-1);
                countIslands(i-1,j);
            }else
                return;
        }
    }
}
