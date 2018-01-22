package com.androidlime.cf_check;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  {
     public static EditText mEdit;
    Button click1;
    Button click2;
    public static TextView data;
    ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEdit = (EditText) findViewById(R.id.editText2);


        click2 = (Button) findViewById(R.id.button3);
        click1 = (Button) findViewById(R.id.button4);

        data = (TextView) findViewById(R.id.text2);

        //click2.setOnClickListener(this);
        click1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fetchdata process = new fetchdata();
                process.execute();
            }
        });
        click2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fatchdata1 process1 = new fatchdata1();
                process1.execute();
            }
        });
    }
}
