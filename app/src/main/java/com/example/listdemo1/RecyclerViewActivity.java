package com.example.listdemo1;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import adapter.RecyclerAdapter;
import bean.Student;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity
        implements RecyclerAdapter.OnItemClickListener, RecyclerAdapter.OnItemLongClickListener {
    private RecyclerView mRecyclerView;
    private List<Student> mList;
    private RecyclerAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        mRecyclerView = findViewById(R.id.recycler);
        initData();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3,
                StaggeredGridLayoutManager.VERTICAL);

        // 1. 线性布局 (水平/垂直滑动列表)
        //mRecyclerView.setLayoutManager(linearLayoutManager);

        // 2. 网格布局 (多列等宽网格)
        mRecyclerView.setLayoutManager(gridLayoutManager);

        // 3. 瀑布流布局 (高低不平的交错网格)
        // mRecyclerView.setLayoutManager(staggeredGridLayoutManager);

        mAdapter = new RecyclerAdapter(mList, this);
        mAdapter.setOnItemLongClickListener(this);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void initData() {
        mList = new ArrayList<>();
        for (int i = 0; i < 120; i++) {
            Student student = new Student();
            student.setName("张老" + i);
            student.setNumber("1300000000" + i);
            mList.add(student);
        }

        Student student = new Student();
        student.setName("张老");
        student.setNumber("1300000000000000000000000000000000000000000000000000000");
        mList.add(4, student);

        student = new Student();
        student.setName("张老");
        student.setNumber("1300000000000000000000000000000000000000000000000000000");
        mList.add(6, student);

        student = new Student();
        student.setName("张老");
        student.setNumber("1300000000000000000000000000000000000000000000000000000");
        mList.add(12, student);

        student = new Student();
        student.setName("张老");
        student.setNumber("1300000000000000000000000000000000000000000000000000000");
        mList.add(17, student);

        student = new Student();
        student.setName("张老");
        student.setNumber("1300000000000000000000000000000000000000000000000000000");
        mList.add(25, student);
    }

    @Override
    public void onItemClick(Student student) {
        Log.d("test111", "=======" + student);
    }

    @Override
    public void onItemLongClick(Student student) {
        Log.e("test111", "=======" + student);
    }
}
