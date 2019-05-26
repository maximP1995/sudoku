package com.maixm.sudoku.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.maixm.sudoku.R;

public class PopupAdapter extends RecyclerView.Adapter {
    private int[] nums = new int[]{1,2,3,4,5,6,7,8,9};
    private NumberClickCallback callback;
    public void setCallback(NumberClickCallback callback){
        this.callback = callback;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.tv_num.setText(String.valueOf(nums[position]));
        viewHolder.tv_num.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callback!=null)callback.onNumberClick(nums[position]);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 9;
    }
    private class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_num;
        public ViewHolder(View itemView) {
            super(itemView);
            tv_num = itemView.findViewById(R.id.tv_num);
        }
    }
    public interface NumberClickCallback{
        void onNumberClick(int num);
    }
}
