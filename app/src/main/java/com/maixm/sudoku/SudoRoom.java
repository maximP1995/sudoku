package com.maixm.sudoku;

import android.util.Log;

import com.maixm.sudoku.entiy.SudoNumber;

import java.util.ArrayList;
import java.util.Random;
//daily check

public class SudoRoom {
//    private SudoGenerator generator;
//    private SudoNumber[][] table;

    private SudoBlock[][] blocks;
    public SudoRoom(){
        blocks = new SudoBlock[3][3];
        blocks[1][1] = new SudoBlock();
        SudoBlock sb = blocks[1][1].generateCentralBlock();
        SudoBlock left = new SudoBlock();
        left.firstRow = sb.thirdRow;
        left.secondRow = sb.firstRow;
        left.thirdRow = sb.secondRow;
        left.generateTableWithRow();
        blocks[1][0] = left;
        SudoBlock right = new SudoBlock();
        right.firstRow = sb.secondRow;
        right.secondRow = sb.thirdRow;
        right.thirdRow = sb.firstRow;
        right.generateTableWithRow();
        blocks[1][2] = right;
        SudoBlock top = new SudoBlock();
        top.firstColumn = sb.thirdColumn;
        top.secondColumn = sb.firstColumn;
        top.thirdColumn = sb.secondColumn;
        top.generateTableWithColumn();
        blocks[0][1] = top;
        SudoBlock bot = new SudoBlock();
        bot.firstColumn = sb.secondColumn;
        bot.secondColumn = sb.thirdColumn;
        bot.thirdColumn = sb.firstColumn;
        bot.generateTableWithColumn();
        blocks[2][1] = bot;
        SudoBlock topLeft = new SudoBlock();
        topLeft.firstColumn = left.thirdColumn;
        topLeft.secondColumn = left.firstColumn;
        topLeft.thirdColumn = left.secondColumn;
        topLeft.generateTableWithColumn();
        blocks[0][0] = topLeft;
        SudoBlock botLeft = new SudoBlock();
        botLeft.firstColumn = left.secondColumn;
        botLeft.secondColumn = left.thirdColumn;
        botLeft.thirdColumn = left.firstColumn;
        botLeft.generateTableWithColumn();
        blocks[2][0] = botLeft;
        SudoBlock topRight = new SudoBlock();
        topRight.firstColumn = right.thirdColumn;
        topRight.secondColumn = right.firstColumn;
        topRight.thirdColumn = right.secondColumn;
        topRight.generateTableWithColumn();
        blocks[0][2] = topRight;
        topRight.generateTableWithColumn();
        SudoBlock botRight = new SudoBlock();
        botRight.firstColumn = right.secondColumn;
        botRight.secondColumn = right.thirdColumn;
        botRight.thirdColumn = right.firstColumn;
        botRight.generateTableWithColumn();
        blocks[2][2] = botRight;
        for (int line = 0;line<3;line++){
            StringBuilder builder = new StringBuilder();
            for (int i = 0;i<blocks[0][0].firstRow.length;i++){
                if (line == 0)builder.append(blocks[0][0].firstRow[i]+" ");
                if (line == 1)builder.append(blocks[0][0].secondRow[i]+" ");
                if (line == 2)builder.append(blocks[0][0].thirdRow[i]+" ");
            }
            for (int i = 0;i<blocks[0][1].firstRow.length;i++){
                if (line == 0)builder.append(blocks[0][1].firstRow[i]+" ");
                if (line == 1)builder.append(blocks[0][1].secondRow[i]+" ");
                if (line == 2)builder.append(blocks[0][1].thirdRow[i]+" ");
            }
            for (int i = 0;i<blocks[0][2].firstRow.length;i++){
                if (line == 0)builder.append(blocks[0][2].firstRow[i]+" ");
                if (line == 1)builder.append(blocks[0][2].secondRow[i]+" ");
                if (line == 2)builder.append(blocks[0][2].thirdRow[i]+" ");
            }
            Log.d("123",builder.toString());
        }
        for (int line = 0;line<3;line++){
            StringBuilder builder = new StringBuilder();
            for (int i = 0;i<blocks[1][0].firstRow.length;i++){
                if (line == 0)builder.append(blocks[1][0].firstRow[i]+" ");
                if (line == 1)builder.append(blocks[1][0].secondRow[i]+" ");
                if (line == 2)builder.append(blocks[1][0].thirdRow[i]+" ");
            }
            for (int i = 0;i<blocks[1][1].firstRow.length;i++){
                if (line == 0)builder.append(blocks[1][1].firstRow[i]+" ");
                if (line == 1)builder.append(blocks[1][1].secondRow[i]+" ");
                if (line == 2)builder.append(blocks[1][1].thirdRow[i]+" ");
            }
            for (int i = 0;i<blocks[1][2].firstRow.length;i++){
                if (line == 0)builder.append(blocks[1][2].firstRow[i]+" ");
                if (line == 1)builder.append(blocks[1][2].secondRow[i]+" ");
                if (line == 2)builder.append(blocks[1][2].thirdRow[i]+" ");
            }
            Log.d("123",builder.toString());
        }
        for (int line = 0;line<3;line++){
            StringBuilder builder = new StringBuilder();
            for (int i = 0;i<blocks[2][0].firstRow.length;i++){
                if (line == 0)builder.append(blocks[2][0].firstRow[i]+" ");
                if (line == 1)builder.append(blocks[2][0].secondRow[i]+" ");
                if (line == 2)builder.append(blocks[2][0].thirdRow[i]+" ");
            }
            for (int i = 0;i<blocks[2][1].firstRow.length;i++){
                if (line == 0)builder.append(blocks[2][1].firstRow[i]+" ");
                if (line == 1)builder.append(blocks[2][1].secondRow[i]+" ");
                if (line == 2)builder.append(blocks[2][1].thirdRow[i]+" ");
            }
            for (int i = 0;i<blocks[2][2].firstRow.length;i++){
                if (line == 0)builder.append(blocks[2][2].firstRow[i]+" ");
                if (line == 1)builder.append(blocks[2][2].secondRow[i]+" ");
                if (line == 2)builder.append(blocks[2][2].thirdRow[i]+" ");
            }
            Log.d("123",builder.toString());
        }
//        generator = new SudoGenerator();
//        table = generator.generate();
    }
//    public void print(){
//        for (int row = 0;row<9;row++){
//            for (int column = 0;column<9;column++){
//                System.out.print(table[row][column].value+" ");
//            }
//            System.out.print("\n");
//        }
//        System.out.print("----------------------------------------------------");
//    }
}
