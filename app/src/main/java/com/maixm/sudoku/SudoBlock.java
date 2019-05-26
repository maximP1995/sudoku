package com.maixm.sudoku;

import com.maixm.sudoku.entiy.SudoNumber;

import java.util.ArrayList;
import java.util.Random;

public class SudoBlock {
    public int blockTag;
    public int[] firstRow;
    public int[] secondRow;
    public int[] thirdRow;
    public int[] firstColumn;
    public int[] secondColumn;
    public int[] thirdColumn;
    private SudoNumber[][] table;
    private ArrayList<Integer> availableValues;
    public SudoBlock(){
        firstRow = new int[3];
        secondRow = new int[3];
        thirdRow = new int[3];
        firstColumn = new int[3];
        secondColumn = new int[3];
        thirdColumn = new int[3];
        availableValues = new ArrayList<>();
        table = new SudoNumber[3][3];
        for (int r = 0;r<3;r++){
            for (int c = 0;c<3;c++){
                table[r][c] = new SudoNumber();
            }
        }
    }
    public void generateFakeNumber(){
        int count = 0;
        while (count<4){
            for (int r = 0;r<3;r++){
                if (count == 7)break;
                for (int c = 0;c<3;c++){
                    if (count == 7)break;
                    SudoNumber number = table[r][c];
                    int random = (int) (Math.random()*10);
                    if (random>5){
                        number.value = 0;
                        count+=1;
                    }
                }
            }
        }
        wrap();
    }
    public SudoBlock generateCentralBlock(){
        for (int i = 1;i<10;i++){
            availableValues.add(i);
        }
        for (int r = 0;r<3;r++){
            for (int c = 0;c<3;c++){
                SudoNumber number = new SudoNumber();
                Random random = new Random();
                int index = 0;
                if (availableValues.size()>1){
                    index = random.nextInt(availableValues.size()-1);
                }
                number.value = availableValues.get(index);
                availableValues.remove(index);
                table[r][c] = number;
            }
        }
        wrap();
        return this;
    }
    public void wrap(){
        for (int r = 0;r<3;r++){
            for (int c = 0;c<3;c++){
                if (r==0)firstRow[c] = table[r][c].value;
                if (r==1)secondRow[c] = table[r][c].value;
                if (r==2)thirdRow[c] = table[r][c].value;
            }
        }
        for (int c = 0;c<3;c++){
            for (int r = 0;r<3;r++){
                if (c == 0) firstColumn[r] = table[r][c].value;
                if (c == 1) secondColumn[r] = table[r][c].value;
                if (c == 2) thirdColumn[r] = table[r][c].value;
            }
        }
    }
    public void generateTableWithRow(){
        for (int r = 0;r<3;r++){
            for (int c = 0;c<3;c++){
                if (r == 0){
                    table[r][c].value = firstRow[c];
                }
                if (r == 1){
                    table[r][c].value = secondRow[c];
                }
                if (r == 2){
                    table[r][c].value = thirdRow[c];
                }
            }
        }
        wrap();
    }
    public void generateTableWithColumn(){
        for (int c = 0;c<3;c++){
            for (int r = 0;r<3;r++){
                if (c == 0){
                    table[r][c].value = firstColumn[r];
                }
                if (c == 1){
                    table[r][c].value = secondColumn[r];
                }
                if (c == 2){
                    table[r][c].value = thirdColumn[r];
                }
            }
        }
        wrap();
    }
}
