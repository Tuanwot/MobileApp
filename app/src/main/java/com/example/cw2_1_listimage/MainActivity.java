package com.example.cw2_1_listimage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    ArrayList<Image> ImageList;
    Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = (GridView) findViewById(R.id.grideImage);

        ImageList= new ArrayList<>();
        Field[] ID_Fields = R.drawable.class.getDeclaredFields();
        int[] resArray = new int[ID_Fields.length];
        for(int i = 0; i < ID_Fields.length; i++){
            try {
                String name = ID_Fields[i].getName();
                resArray[i]= ID_Fields[i].getInt(null);
                if(!(name.contains("ic_launcher_"))) {
                    ImageList.add(new Image(name, resArray[i]));
                }else{
                    continue;
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

//        ImageList.add(new Image("item1",R.drawable.a));
//        ImageList.add(new Image("item2",R.drawable.b));
//        ImageList.add(new Image("item3",R.drawable.c));
//        ImageList.add(new Image("item4",R.drawable.d));
//        ImageList.add(new Image("item5",R.drawable.e));
//        ImageList.add(new Image("item6",R.drawable.f));
//        ImageList.add(new Image("item7",R.drawable.g));
//        ImageList.add(new Image("item8",R.drawable.h));
        adapter = new Adapter(this,R.layout.subimage,ImageList);
        gridView.setAdapter(adapter);
    }
}