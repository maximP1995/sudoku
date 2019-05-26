package com.maixm.sudoku;

import com.maixm.sudoku.entiy.SudoNumber;
import com.maixm.sudoku.view.SudoBoard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SudoCheck {
    private SudoNumber[][] table;
    private SudoBoard board;
    private int row;
    private int column;
    public SudoCheck(SudoBoard board,SudoNumber[][] table){
        this.board = board;
        this.table = table;
    }
    public void playerInsert(int index){
         column = index % 9;
         row = index/9;
        checkRow();
        checkColumn();
    }
    private void checkBlock(){
        int blockColumn = column/3;
        int blockRow = row/3;
        for (int r = blockRow;r<blockRow+3;r++){
            for (int c = blockColumn;c<blockRow+3;c++){
                SudoNumber number = table[r][c];
                for (int r1 = blockRow;r1<blockRow+3;r1++){
                    for (int c1 = blockColumn;c1<blockRow+3;c1++){
                        if (r1 == r && c1 == c)continue;
                        SudoNumber exam = table[r1][c1];

                    }
                }
            }
        }
    }
    private void checkRow(){
        ArrayList<int[]> errorList = new ArrayList<>();
        HashSet<Integer> columnSet = new HashSet<>();
        for (int c = 0;c<9;c++){
            SudoNumber number = table[row][c];
//            if (number.value != 0)continue;
            for (int i = 0;i<9;i++){
                if ( i == c )continue;
                SudoNumber exam = table[row][i];
                if (number.value!=0&&exam.value!=0)continue;
                if (number.value!=0){
                    if (exam.playerInsert == number.value){
                        if (!columnSet.contains(i)){
                            columnSet.add(i);
                        }
                    }
                }else {
                    if (exam.value!=0){
                        if (number.playerInsert == exam.value){
                            if (!columnSet.contains(c)){
                                columnSet.add(c);
                            }
                        }
                    }else {
                        if (exam.playerInsert == number.playerInsert){
                            if (!columnSet.contains(c)){
                                columnSet.add(c);
                            }
                            if (!columnSet.contains(i)){
                                columnSet.add(i);
                            }
                        }
                    }
                }
            }
        }
        if (columnSet.size()!=0){
            Iterator<Integer> iterator = columnSet.iterator();
            if (iterator.hasNext()){
                int column = iterator.next();
                errorList.add(new int[]{row,column});
            }
            board.setError(errorList);
        }
    }
    private void checkColumn(){
        ArrayList<int[]> errorList = new ArrayList<>();
        HashSet<Integer> rowSet = new HashSet<>();
        for (int r = 0;r<9;r++){
            SudoNumber number = table[r][column];
//            if (number.value!=0) continue;
            for (int i = 0;i<9;i++){
                if (i == r) continue;
                SudoNumber exam = table[i][column];
                if (number.value!=0&&exam.value!=0)continue;;
                if (number.value!=0){
                    if (exam.playerInsert == number.value){
                        rowSet.add(i);
                    }
                }else {
                    if (exam.value!=0){
                        if (number.playerInsert == exam.value){
                            if (!rowSet.contains(r)){
                                rowSet.add(r);
                            }
                        }
                    }else {
                        if (exam.playerInsert == number.playerInsert){
                            if (!rowSet.contains(r)){
                                rowSet.add(r);
                            }
                            if (!rowSet.contains(i)){
                                rowSet.add(i);
                            }
                        }
                    }
                }
            }
        }
        if (rowSet.size()!=0){
            Iterator<Integer> iterator = rowSet.iterator();
            if (iterator.hasNext()){
                int row = iterator.next();
                errorList.add(new int[]{row,column});
            }
            board.setError(errorList);
        }
    }
}
