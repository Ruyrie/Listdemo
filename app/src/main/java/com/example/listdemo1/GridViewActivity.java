package com.example.listdemo1;

import android.os.Bundle;
import android.widget.GridView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import adapter.GridViewAdapter;
import bean.Student;

public class GridViewActivity extends AppCompatActivity {
    private GridView mGridView;
    private List<Student> mList;
    private GridViewAdapter mAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview);
        mGridView = findViewById(R.id.gridview);
        initData();
        mAdapter = new GridViewAdapter(this, mList);
        mGridView.setAdapter(mAdapter);
    }

    private void initData() {
        mList = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            Student student = new Student();
            student.setName("张三" + i);
            student.setNumber("1300000000" + i);
            mList.add(student);
        }
    }
}