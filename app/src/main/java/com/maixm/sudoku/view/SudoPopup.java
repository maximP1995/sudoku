package com.maixm.sudoku.view;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import com.maixm.sudoku.R;
import com.maixm.sudoku.view.adapter.PopupAdapter;

public class SudoPopup extends PopupWindow {
    private View view;
    private RecyclerView rv_list;
    private PopupAdapter adapter;
    private OnClickCallback clickCallback;
    public void setClickCallback(OnClickCallback clickCallback){
        this.clickCallback = clickCallback;
    }
    public SudoPopup(View view){
        super();
        this.view = view;
        View layout = LayoutInflater.from(view.getContext()).inflate(R.layout.popup_layout,null);
        setContentView(layout);
        setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        rv_list = layout.findViewById(R.id.rv_list);
        rv_list.setLayoutManager(new GridLayoutManager(view.getContext(),3));
        adapter = new PopupAdapter();
        adapter.setCallback(new PopupAdapter.NumberClickCallback() {
            @Override
            public void onNumberClick(int num) {
                if (clickCallback!=null)clickCallback.onClick(num);
                dismiss();
            }
        });
        rv_list.setAdapter(adapter);


    }
    public void show(int x,int y){
        getContentView().measure(0,0);
        int viewHeight = getContentView().getMeasuredHeight();
        int viewWidth = getContentView().getMeasuredWidth();
        int xoff = x;
        int yoff = y-viewHeight;
        showAsDropDown(view,x,y);
        Log.d("123","isShow ? "+(isShowing())+" viewHeight == "+viewHeight);
    }
    public interface OnClickCallback{
        void onClick(int num);
    }
}
