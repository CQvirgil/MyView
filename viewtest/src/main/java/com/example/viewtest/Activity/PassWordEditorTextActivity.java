package com.example.viewtest.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.viewtest.PassWordEditorText.PassWordEditorText;
import com.example.viewtest.PassWordEditorText.PassWordListener;
import com.example.viewtest.R;

public class PassWordEditorTextActivity extends AppCompatActivity {
    PassWordEditorText passWordEditorText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass_word_editor_text);
        passWordEditorText = findViewById(R.id.pass_word_editor_text);
        passWordEditorText.setOnPasswordListener(new PassWordListener() {
            @Override
            public void onFinish(String text) {
                Toast.makeText(PassWordEditorTextActivity.this, text, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
