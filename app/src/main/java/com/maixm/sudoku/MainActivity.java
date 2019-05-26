package com.maixm.sudoku;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.maixm.sudoku.view.SudoBoard;
import com.maixm.sudoku.view.SudoBoardAdapter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private SudoBoard board;
    private SudoBoardAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        board = findViewById(R.id.id_board);
        adapter = new SudoBoardAdapter(this);
        board.setAdapter(adapter);
        SudoRoom sudoRoom = new SudoRoom();
        adapter.setData(sudoRoom.table);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

        }
    }
}
