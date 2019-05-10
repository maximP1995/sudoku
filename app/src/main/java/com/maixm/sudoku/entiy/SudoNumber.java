package com.maixm.sudoku.entiy;

import android.util.Log;

import java.util.ArrayList;

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
        if (availableValues!=null&&availableValues.size()>0){
            int index = (int) (Math.random()*(availableValues.size()-1));
            int result = availableValues.get(index);
            value = result;
            return value;
        }else {
            return 0;
        }
    }
    public void removeAvailableValue(int value){
        if (availableValues!=null&&availableValues.size()>0){
            for (int i = 0;i<availableValues.size();i++){
                int listValue = availableValues.get(i);
                if (listValue == value){
                    availableValues.remove(i);
                    break;
                }
            }
        }
    }
}
