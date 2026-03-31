package com.example.listdemo1;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class ArrayAdapterActivity extends AppCompatActivity {
    private ListView mListView;
    private String[] mArray;
    private List<String> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_listview);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        mListView = findViewById(R.id.listview);
        mArray = getResources().getStringArray(R.array.my_array);
        mList = new ArrayList<>();
        mList.add("1111");
        mList.add("2222");
        mList.add("3333");
        mList.add("4444");
        // ArrayAdapter arrayAdapter = new ArrayAdapter(this,
        // android.R.layout.simple_list_item_1, mList);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, mArray);
        mListView.setAdapter(arrayAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textView = (TextView) view;
                Log.d("test111", "内容:" + textView.getText().toString() + ", 位置:" + position);
                // Log.d("test111", "内容:" + mList.get(position) + ", 位置:" + position);
            }
        });
        mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                // Log.e("test111", "内容:" + mList.get(position) + ", 位置:" + position);
                Log.e("test111", "内容:" + mArray[position] + ", 位置:" + position);
                return true;
            }
        });

    }
}
