package com.bj.zw.kotlinrecyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.bj.zw.kotlin.ui.MovieActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
static int a=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView idd= (ListView) findViewById(R.id.idd);
        idd.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {

        Intent intent=new Intent();
        intent.putExtra("aaa","aaa");
        intent.setClass(this,MovieActivity.class);
        startActivity(intent);
    }
}
