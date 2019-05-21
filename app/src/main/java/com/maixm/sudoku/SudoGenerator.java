package com.maixm.sudoku;

import com.maixm.sudoku.entiy.SudoNumber;

public class SudoGenerator {
    private SudoNumber[][] table;
    public SudoGenerator(){
        table = new SudoNumber[9][9];
        for (int row = 0;row<9;row++){
            for (int column = 0;column<9;column++){
                table[row][column] = new SudoNumber();
            }
        }
    }
    public SudoNumber[][] generate(){
        for (int row = 0;row<9;row++){
            for (int column = 0;column<9;column++){
                SudoNumber number = table[row][column];
                int randomValue = number.setRandomValue();
                notifyAvailable(randomValue,row,column);
            }
        }
        return table;
    }
    private void notifyAvailable(int unavailable,int row,int column){
        notifyRow(unavailable,row,column);
        notifyColumn(unavailable,row,column);
        notifySquare(unavailable,row,column);
    }
    private void notifyRow(int unavailable,int row,int column){
        for (int c = column;c<9;c++){
            table[row][c].removeAvailableValue(unavailable);
        }
    }
    private void notifyColumn(int unavailable,int row,int column){
        for (int r = row;r<9;r++){
            table[r][column].removeAvailableValue(unavailable);
        }
    }
    private void notifySquare(int unavailable,int row,int column){
        int squareRow = getSquareRow(row);
        int squareColumn = getSquareColumn(column);
        for (int r = 0;r<9;r++){
            for (int c = 0;c<9;c++){
                if (getSquareRow(r) == squareRow && getSquareColumn(c) == squareColumn){
                    table[r][c].removeAvailableValue(unavailable);
                }
            }
        }
    }
    private int getSquareRow(int row){
        return row/3;
    }
    private int getSquareColumn(int column){
        return column/3;
    }
}
