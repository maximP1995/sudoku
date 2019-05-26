package com.maixm.sudoku.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class SudoChild extends View {
    private int text;
    private int realNum;
    private Paint paint;
    private boolean isSelected;
    private boolean isError;
    private boolean dontShow;
    private int index;
    public SudoChild(Context context,int index) {
        super(context);
        this.index = index;
        paint = new Paint();
        paint.setTextSize(30);
        paint.setTypeface(Typeface.DEFAULT_BOLD);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);
    }
    public void setNumber(int text){
        this.text = text;
        dontShow =false;
        paint.setColor(Color.parseColor("#959595"));
        invalidate();
    }
    public void setRealNum(int realNum){
        this.realNum = realNum;
        if (realNum!=0){
            text = this.realNum;
        }else {
            dontShow = true;
        }
        invalidate();
    }
    protected void setError(boolean isError){
        this.isError = isError;
        paint.setColor(Color.RED);
        invalidate();
    }
    public void setSelected(boolean isSelected){
        this.isSelected = isSelected;
        invalidate();
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isSelected){
            canvas.drawColor(Color.GRAY);
        }else {
            canvas.drawColor(Color.WHITE);
        }
        Log.d("123","child getWidth == "+getWidth());
        paint.setTextSize(getWidth()/1.8f);
        if (!dontShow)canvas.drawText(String.valueOf(text),getWidth()/2-paint.getTextSize()/4.5f,getWidth()/2+paint.getTextSize()/4.5f,paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:

                try {
                    SudoBoard board = (SudoBoard) getParent();
                    board.isClickOnChild(realNum == 0);
                    board.clearAllSelected();
                    board.setSelectedIndex(index);
                }catch (ClassCastException e){

                }
                setSelected(true);
                Log.d("123","action down on text == "+text+" getRawX == "+event.getRawX()+"getRawY == "+event.getRawY());
                break;
        }
        return super.onTouchEvent(event);
    }
}
