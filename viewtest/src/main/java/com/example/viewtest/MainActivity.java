package com.example.viewtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.viewtest.Activity.DateSelectorActivity;
import com.example.viewtest.Activity.PassWordEditorTextActivity;
import com.example.viewtest.Activity.RollTextActivity;
import com.example.viewtest.PassWordEditorText.PassWordEditorText;

public class MainActivity extends AppCompatActivity {
    Button btnPassWord, btnRollText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnPassWord = findViewById(R.id.act_main_btn_password);
        btnRollText = findViewById(R.id.act_main_btn_roll_text);
    }

    public void ClickPassWord(View view){
        Intent intent = new Intent(MainActivity.this, PassWordEditorTextActivity.class);
        startActivity(intent);
    }

    public void ClickRollText(View view){
        Intent intent = new Intent(MainActivity.this, RollTextActivity.class);
        startActivity(intent);
    }

    public void ClickDateSelector(View view){
        Intent intent = new Intent(MainActivity.this, DateSelectorActivity.class);
        startActivity(intent);
    }
}
