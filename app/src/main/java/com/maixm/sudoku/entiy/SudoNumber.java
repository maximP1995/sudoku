package com.maixm.sudoku.entiy;

import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

public class SudoNumber {
    public int value;
    public ArrayList<Integer> availableValues = new ArrayList<>();
    public int blockTag;
    public SudoNumber(){
        for (int i = 1;i<10;i++){
            availableValues.add(i);
        }
    }
    public void resetAvailables(){
        availableValues = null;
    }
    public int setRandomValue(){
        if (availableValues.size()>1){
            int index = new Random().nextInt(availableValues.size()-1);
            int value = availableValues.get(index);
            this.value = value;
            availableValues.remove(index);
            return value;
        }else if (availableValues.size() == 1){
            int value = availableValues.get(0);
            this.value = value;
            availableValues.remove(0);
            return value;
        }else {
            return -1;
        }
    }
    public void removeAvailableValue(int value){
        for (int index = 0;index<availableValues.size();index++){
            if (availableValues.get(index) == value){
                availableValues.remove(index);
                break;
            }
        }
    }
}
