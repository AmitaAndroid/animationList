package com.practice.animaionlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(MainActivity.this, AnimationActivity.class);
                intent.putExtra("position",i);
                startActivity(intent);
             }
            });

    }

    private void intiView() {
        listView=(ListView)findViewById(R.id.list_animation);
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1 , animationType);
        listView.setAdapter(adapter);
    }
}
