package com.example.lk.app_activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NextActivity extends AppCompatActivity {
    private Button button =null;
    private TextView textView =null;
    private EditText editText =null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        button = (Button)findViewById(R.id.button);
        textView = (TextView)findViewById(R.id.textView);
        editText = (EditText) findViewById(R.id.editText);
        Intent intent = getIntent();
        String text =  intent.getStringExtra("string");
        textView.setText(text);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                String input = editText.getText().toString().trim();
                intent.putExtra("result",input);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    };

}
