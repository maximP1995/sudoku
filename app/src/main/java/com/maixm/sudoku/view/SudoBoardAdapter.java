package com.maixm.sudoku.view;

import android.content.Context;
import android.view.View;

import com.maixm.sudoku.entiy.SudoNumber;

public class SudoBoardAdapter {
    private Context context;
    private SudoBoard parent;
    public SudoBoardAdapter(Context context){
        this.context = context;
    }
    protected void bind(SudoBoard sudoBoard){
        parent = sudoBoard;
    }
    public void setData(SudoNumber[][] table){
        parent.setData(table);
    }
}
