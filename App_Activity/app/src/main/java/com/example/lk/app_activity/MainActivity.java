package com.example.lk.app_activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private String TAG = "MainActivity";
    private EditText editText1 = null;
    private EditText editText2 = null;
    private EditText editText3 = null;
    private Button button = null;
    private Button button2 = null;
    private Button button3 = null;
    private Button button4 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1 = (EditText)findViewById(R.id.editText1);
        editText2 = (EditText)findViewById(R.id.editText2);
        editText3 = (EditText)findViewById(R.id.editText3);
        button = (Button)findViewById(R.id.button);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        button4 = (Button)findViewById(R.id.button4);

        //计算
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String a =  editText1.getText().toString().trim();
               String b =  editText2.getText().toString().trim();
               String c = "" + a + "+" + b + "=?";
               Intent it = new Intent();
               it.putExtra("string", c);
               it.setClass(MainActivity.this,NextActivity.class);
               startActivityForResult(it, 1001);
            }
        });

        //拨号
        //打电话需要权限
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent();
                it.setAction(Intent.ACTION_CALL);
                it.setData(Uri.parse("tel:18607109145"));
                startActivity(it);
            }
        });

        //发短信
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent();
                it.setAction(Intent.ACTION_SENDTO);
                it.setType("vnd.android-dir/mms-sms");
                it.putExtra("sms_body","I want to make friends with you");
                it.setData(Uri.parse("smsto:18607109145"));
                startActivity(it);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent();
                it.setAction(Intent.ACTION_VIEW);
                it.setData(Uri.parse("http://www.baidu.com"));
                startActivity(it);
            }
        });

    }

    @Override
    protected void  onResume(){
        super.onResume();
        Log.i(TAG, "onResume....");
    }

    @Override
    protected  void  onPause(){
        super.onPause();
        Log.i(TAG, "onPause....");
    }

    @Override
    protected void onStop(){
        super.onStop();
    }

    @Override
    protected  void onRestart(){
        super.onRestart();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode)
        {
            case RESULT_OK:
                String s = data.getStringExtra("result");
                editText3.setText(s);
                break;
            default:break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
