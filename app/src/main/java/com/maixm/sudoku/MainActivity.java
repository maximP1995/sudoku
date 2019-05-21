package com.maixm.sudoku;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private SudoRoom sudoRoom ;
    private TextView tv_answer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_answer = findViewById(R.id.tv_answer);
        tv_answer.setOnClickListener(this);
        sudoRoom = new SudoRoom();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_answer:
//                sudoRoom.print();
                break;
        }
    }
}
