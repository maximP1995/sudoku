package com.maixm.sudoku;

import android.util.Log;

import com.maixm.sudoku.entiy.SudoNumber;

import java.util.ArrayList;
import java.util.Random;
//daily check

public class SudoRoom implements NotifyTransporter{
    private SudoBlock[][] blocks;
    public SudoRoom(){
        blocks = new SudoBlock[3][3];
        int blockCount = 0;
        for (int row = 0;row<3;row++){
            for (int column = 0; column<3;column++){
                SudoBlock block = new SudoBlock(this);
                blockCount += 1;
                block.blockTag = blockCount;
                blocks[row][column] = block;
            }
        }
    }
    public void generateRandom(){
        for (int row = 0;row<3;row++){
            for (int column = 0;column<3;column++){
                blocks[row][column].generateRandomNumber();
            }
        }
        print();
    }
    @Override
    public void handleVertical(VerticalNotify verticalNotify, int blockTag) {
            int column = blockTag % 3;
            for (int row = 0;row<3;row++){
                blocks[row][column].getVerticalNotify(verticalNotify);
            }
    }

    @Override
    public void handleHorizontal(HorizontalNotify horizontalNotify, int blockTag) {
            int row = blockTag/3;
            for (int column = 0;column<3;column++){
                blocks[row][column].getHorizontalNotify(horizontalNotify);
            }
    }

    public void print(){
        for (int row = 0;row<3;row++){
            for (int column = 0;column<3;column++){
                blocks[row][column].print();
            }
            System.out.print("\n");
        }
        System.out.println("-------------------------------------------------------");
    }
}
