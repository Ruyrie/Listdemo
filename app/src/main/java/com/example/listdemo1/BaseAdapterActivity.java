package com.example.listdemo1;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import adapter.StudentBaseAdapter;
import bean.Student;

public class BaseAdapterActivity extends AppCompatActivity {
    private ListView mListView;
    private List<Student> mList;
    private BaseAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        mListView = findViewById(R.id.listview);
        initData();
        mAdapter = new StudentBaseAdapter(this, mList);
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Student student = (Student) parent.getItemAtPosition(position);
                Log.e("test111", "======" + student);
            }
        });

    }

    private void initData() {
        mList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Student student = new Student();
            student.setName("张三" + i);
            student.setNumber("1300000000" + i);
            mList.add(student);

        }
    }
}