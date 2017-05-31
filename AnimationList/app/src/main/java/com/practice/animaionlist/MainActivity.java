package com.practice.animaionlist;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

public class MainActivity extends Activity {

    ListView listView;
    ArrayAdapter<String> adapter;
    LinearLayout footballLayout;
    String[] animationType={"Scale","Translate","Rotate", "Fade In","Fade Out", "Parallel","Sequential"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intiView();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(MainActivity.this, AnimationActivity.class);
                intent.putExtra("animationType",animationType[i]);
                startActivity(intent);
             }
            });

        footballLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.football_animation_list);
                dialog.setTitle("Choose animation for android");

                ArrayAdapter<String> adapter;
                ListView lv = (ListView ) dialog.findViewById(R.id.football_lv);
                final String[] footballAnimationType={"Anticipate","Overshoot"};

                adapter=new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_list_item_1 , footballAnimationType);
                lv.setAdapter(adapter);

                lv.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        Intent i= new Intent(MainActivity.this, FootballActivity.class);
                        i.putExtra("footballAnimation",footballAnimationType[position]);
                        dialog.dismiss();
                        startActivity(i);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                dialog.setCancelable(true);
                dialog.setTitle("ListView");
                dialog.show();
//                startActivity(new Intent(MainActivity.this, FootballActivity.class));
            }
        });

    }

    private void intiView() {
        listView=(ListView)findViewById(R.id.list_animation);
        footballLayout=(LinearLayout) findViewById(R.id.football_layout);
        adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1 , animationType);
        listView.setAdapter(adapter);
    }
}
