package com.maixm.sudoku;

public interface NotifyTransporter {
    void handleVertical(VerticalNotify verticalNotify,int blockTag);
    void handleHorizontal(HorizontalNotify horizontalNotify,int blockTag);
}
