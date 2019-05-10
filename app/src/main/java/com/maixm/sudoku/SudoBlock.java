package com.maixm.sudoku;

import com.maixm.sudoku.entiy.SudoNumber;

import java.util.ArrayList;

public class SudoBlock {
    public int blockTag;
    private SudoNumber[][] table;
    private ArrayList<Integer> totalNumber;
    private NotifyTransporter transporter;
    public SudoBlock(NotifyTransporter transporter){
        this.transporter = transporter;
        table = new SudoNumber[3][3];
        for (int row = 0;row < 3;row++){
            for (int column = 0; column < 3; column++){
                table[row][column] = new SudoNumber();
            }
        }
        totalNumber = new ArrayList<>();
        for (int i = 1;i<10;i++){
            totalNumber.add(i);
        }
    }

    public void generateRandomNumber(){
        int threshold = 5;
        int randomCount = 0;
        while(randomCount<2){
            for (int row = 0;row <3 ;row++){
                if (randomCount>5)break;
                for (int column = 0;column <3 ;column ++){
                    int random = (int) (Math.random()*10);
                    if (random>threshold){
                        if (random>5)break;
                        setRandomTo(row,column);
                        randomCount += 1;
                    }
                }
            }
        }
    }
    public int getRestCount(){
        return totalNumber.size();
    }
    private void removeFromTotal(int randomNumber){
        for (int i = 0;i<totalNumber.size();i++){
            if (totalNumber.get(i)==randomNumber){
                totalNumber.remove(i);
                break;
            }
        }
    }
    private void setRandomTo(int row,int column){
        SudoNumber number = table[row][column];
        int result = number.setRandomValue();
        notifyNumbers(result);
        sendVerticalNotify(column,result);
        sendHorizontalNotify(row,result);
        removeFromTotal(result);
    }
    public void sendVerticalNotify(int column,int value){
        VerticalNotify notify = new VerticalNotify(column,value);
        if (transporter!=null)transporter.handleVertical(notify,blockTag);
    }
    public void sendHorizontalNotify(int row,int value){
        HorizontalNotify notify = new HorizontalNotify(row,value);
        if (transporter!=null)transporter.handleHorizontal(notify,blockTag);
    }
    public void getVerticalNotify(VerticalNotify notify){
        int column = notify.column;
        int value = notify.number;
        notifyColumn(column,value);
    }
    public void getHorizontalNotify(HorizontalNotify notify){
        int row = notify.row;
        int value = notify.number;
        notifyRow(row,value);
    }
    public void notifyNumbers(int unavailableNumber){
        for (int row = 0;row<3;row++){
            for (int column = 0;column<3;column++){
                SudoNumber number = table[row][column];
                number.removeAvailableValue(unavailableNumber);
            }
        }
    }
    public void notifyColumn(int column,int number){
        for (int row = 0;row<3;row++){
            table[row][column].removeAvailableValue(number);
        }
    }
    public void notifyRow(int row,int number){
        for (int column = 0;column<3;column++){
            table[row][column].removeAvailableValue(number);
        }
    }
    public void print(){
        for (int row = 0;row<3;row++){
            for (int column = 0;column<3;column++){
                int value = table[row][column].value;
                System.out.print(" "+value);
            }
            System.out.print("\n");
        }
    }
}
