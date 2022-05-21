package com.pal;

/**
 * There are 8 prison cells in a row and each cell is either occupied or vacant.
 *
 * Each day, whether the cell is occupied or vacant changes according to the following rules:
 *
 * If a cell has two adjacent neighbors that are both occupied or both vacant, then the cell becomes occupied.
 * Otherwise, it becomes vacant.
 * Note that because the prison is a row, the first and the last cells in the row can't have two adjacent neighbors.
 *
 * You are given an integer array cells where cells[i] == 1 if the ith cell is occupied and cells[i] == 0 if the ith cell is vacant, and you are given an integer n.
 *
 * Return the state of the prison after n days (i.e., n such changes described above).
 *
 * Example 1:
 *
 * Input: cells = [0,1,0,1,1,0,0,1], n = 7
 * Output: [0,0,1,1,0,0,0,0]
 * Explanation: The following table summarizes the state of the prison on each day:
 * Day 0: [0, 1, 0, 1, 1, 0, 0, 1]
 * Day 1: [0, 1, 1, 0, 0, 0, 0, 0]
 * Day 2: [0, 0, 0, 0, 1, 1, 1, 0]
 * Day 3: [0, 1, 1, 0, 0, 1, 0, 0]
 * Day 4: [0, 0, 0, 0, 0, 1, 0, 0]
 * Day 5: [0, 1, 1, 1, 0, 1, 0, 0]
 * Day 6: [0, 0, 1, 0, 1, 1, 0, 0]
 * Day 7: [0, 0, 1, 1, 0, 0, 0, 0]
 *
 * Example 2:
 *
 * Input: cells = [1,0,0,1,0,0,1,0], n = 1000000000
 * Output: [0,0,1,1,1,1,1,0]
 */
public class PrisonCells {

    public int[] prisonAfterNDays(int[] cells, int n) {
        int len = cells.length;

        if(len!=8)
            return new int[8];

        int[] tmpCells = new int[8];

        while(n>0) {
            for (int i = 1; i < len - 1; i++) {
                tmpCells[0] = 0;
                tmpCells[len - 1] = 0;
                if (cells[i - 1] == cells[i + 1])
                    tmpCells[i] = 1;
                else
                    tmpCells[i] = 0;
            }
            cells=tmpCells.clone();
            n--;
        }

        return cells;
    }

    public static void main(String[] args) {
        PrisonCells pc = new PrisonCells();
        int[] cells = {1,0,0,1,0,0,1,0};
        int days = 1000000000;
        int[] outputCells = pc.prisonAfterNDays(cells,days);
        System.out.print("Resulting cells=");
        for(int i=0;i<outputCells.length;i++)
            System.out.print(outputCells[i]+" ");
    }
}
