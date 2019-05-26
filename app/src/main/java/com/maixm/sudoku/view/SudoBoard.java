package com.maixm.sudoku.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import com.maixm.sudoku.SudoCheck;
import com.maixm.sudoku.entiy.SudoNumber;

import java.util.ArrayList;

public class SudoBoard extends ViewGroup {

    private SudoBoardAdapter mAdapter;
    private Context context;
    private boolean needInit = true;
    private int mWidth;
    private int mHeight;
    private int singleWidth;
    private int singleMeasure;
    private SudoPopup popupWindow;
    private boolean isClickOnChild;
    private int index = -1;
    private SudoCheck check;

    public SudoBoard(Context context) {
        super(context);
        this.context = context;

    }
    public SudoBoard(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;

    }
    public void setAdapter(SudoBoardAdapter mAdapter){
        this.mAdapter = mAdapter;
        this.mAdapter.bind(this);
    }
    protected void setData(SudoNumber[][] table){
        check = new SudoCheck(this,table);
        int i = 0;
        for (int r = 0;r<9;r++){
            for (int c = 0;c<9;c++){
                SudoNumber number = table[r][c];
                System.out.print(number.value+" ");
                SudoChild child = new SudoChild(context,i);
                child.setRealNum(number.value);
                ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(singleWidth,singleWidth);
                addView(child,layoutParams);
                i+=1;
            }
            System.out.print("\n");
        }
    }
    private void init(){
        needInit = false;
        mWidth = getMeasuredWidth();
        mHeight = getMeasuredHeight();
        singleWidth = mWidth/10;
        singleMeasure = singleWidth/10;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.d("123","getWidth == "+getMeasuredWidth()+" getHeight == "+getMeasuredHeight());
        if (needInit){
            init();
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        Log.d("123","onLayout childCount == "+getChildCount());
        int childIndex = 0;
        for (int row = 0;row<9;row++){
            for (int column = 0;column<9;column++){
                View child = getChildAt(childIndex);
                int childLeft = singleMeasure+singleMeasure*column+singleWidth*column;
                int childTop = singleMeasure+singleMeasure*row+singleWidth*row;
                child.layout(childLeft,childTop,childLeft+singleWidth,childTop+singleWidth);
             childIndex+=1;
            }
        }
    }
    protected void clearAllSelected(){
        index = -1;
        int childChount = getChildCount();
        for (int i = 0;i<childChount;i++){
            View view = getChildAt(i);
            try{
                SudoChild child = (SudoChild) view;
                child.setSelected(false);
            }catch (ClassCastException e){

            }
        }
    }
    protected void isClickOnChild(boolean isClickOnChild){
        this.isClickOnChild = isClickOnChild;
    }
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d("123","dispatchTouchEvent");
        isClickOnChild = false;
        if (popupWindow!=null){
            popupWindow.dismiss();
            popupWindow = null;
            clearAllSelected();
            return false;
        }
        return super.dispatchTouchEvent(ev);
    }
    protected void setSelectedIndex(int index){
        Log.d("123","setSelectedIndex == "+index);
        this.index = index;
    }
    public void setError(ArrayList<int[]> errorList){
        Log.d("123","error!");
        for (int[] arg : errorList){
            int row = arg[0];
            int column = arg[1];
            int index = column+row*9;
            try {
                SudoChild child = (SudoChild) getChildAt(index);
                child.setError(true);

            }catch (ClassCastException e){

            }
        }
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.d("123","parent action down getRawX == "+event.getRawX()+" getRawY == "+event.getRawY());
                if (isClickOnChild){
                        popupWindow = new SudoPopup(SudoBoard.this);
                        popupWindow.setClickCallback(new SudoPopup.OnClickCallback() {
                            @Override
                            public void onClick(int num) {
                                popupWindow = null;
                                try {
                                    Log.d("123","index == "+index);
                                    SudoChild child = (SudoChild) getChildAt(index);
                                    child.setNumber(num);
                                    check.playerInsert(index);
                                }catch (ClassCastException e){

                                }
                                clearAllSelected();
                                Log.d("123","num == "+num);
                            }
                        });
                    popupWindow.show((int) event.getRawX(),(int) event.getRawY());
                }else {
                    if (popupWindow!=null){
                        popupWindow.dismiss();
                        popupWindow = null;
                    }
                    clearAllSelected();
                }
                break;
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        canvas.drawColor(Color.BLACK);
        super.dispatchDraw(canvas);
    }

}
