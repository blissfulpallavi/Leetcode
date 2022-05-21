package com.pal;

import java.util.ArrayList;
import java.util.List;

public class ValidSudoku{

    public boolean isValidSudoku(char[][] board) {

        int length = board.length;
        int breadth = board[0].length;
        List<Character> arr = new ArrayList<>();

        for(int i=0;i<length;i++){
            for(int j=0;j<breadth;j++){
                if(board[i][j]!='.' && arr.contains(board[i][j]))
                    return false;
                else
                    arr.add(board[i][j]);
            }
            arr.clear();
        }

        for(int i=0;i<length;i++){
            for(int j=0;j<breadth;j++){
                if(board[j][i]!='.' && arr.contains(board[j][i]))
                    return false;
                else
                    arr.add(board[j][i]);
            }
            arr.clear();
        }

        int l=0;
        int b=0;
        while(l<length) {
            while(b<breadth) {
                for (int i = l; i < l + 3; i++) {
                    for (int j = b; j < b + 3; j++) {
                        if (board[i][j] != '.' && arr.contains(board[i][j]))
                            return false;
                        else
                            arr.add(board[i][j]);
                    }
                }
                arr.clear();
                b=b+3;
            }
            l=l+3;
            b=0;
        }

        return true;
    }

    public static void main(String[] args) {
        char[][] board={{'.','.','.','.','5','.','.','1','.'},
                        {'.','4','.','3','.','.','.','.','.'},
                        {'.','.','.','.','.','3','.','.','1'},
                        {'8','.','.','.','.','.','.','2','.'},
                        {'.','.','2','.','7','.','.','.','.'},
                        {'.','1','5','.','.','.','.','.','.'},
                        {'.','.','.','.','.','2','.','.','.'},
                        {'.','2','.','9','.','.','.','.','.'},
                        {'.','.','4','.','.','.','.','.','.'}};

        ValidSudoku validSudoku = new ValidSudoku();
        boolean result = validSudoku.isValidSudoku(board);
        System.out.println("result="+result);
    }

}