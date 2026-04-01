package com.example.listdemo1;

import android.os.Bundle;
import android.service.autofill.OnClickAction;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

import adapter.StudentArrayAdapter;
import bean.Student;

public class ArrayAdapterActivity1 extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView mListView;

    private List<Student> mList;
    private StudentArrayAdapter mAdapter;


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
        initData();
        mAdapter = new StudentArrayAdapter(this,mList);
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(this);

}

    private void initData() {
    mList = new ArrayList<>();
    for (int i = 0 ;i<20;i++){
        Student student = new Student();
        student.setName("张三"+i);
        student.setNumber(130000 + i);
        mList.add(student);
    }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Student student = mAdapter.getItem(position);
        Log.e("test111", "======" + student);
    }

}
