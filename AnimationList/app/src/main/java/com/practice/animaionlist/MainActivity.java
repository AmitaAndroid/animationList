package com.practice.animaionlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayAdapter<String> adapter;
    String[] animationType={"anim1"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intiView();
    }

    private void intiView() {
        listView=(ListView)findViewById(R.id.list_animation);
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1 , animationType);
        listView.setAdapter(adapter);
    }
}
