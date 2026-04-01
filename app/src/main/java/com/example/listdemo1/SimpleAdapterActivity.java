package com.example.listdemo1;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleAdapterActivity extends AppCompatActivity {
    private ListView mListView;
    private List<Map<String, Object>> mList;
    private SimpleAdapter mAdapter;
    private int[] resIds;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        mListView = findViewById(R.id.listview);
        resIds = new int[] {R.mipmap.football, R.mipmap.basketball};
        initData();
        mAdapter = new SimpleAdapter(this, mList, R.layout.simple_adapter_item,
                new String[] {"photo", "name", "id", "age", "phone"},
                new int[] {R.id.photo, R.id.name, R.id.id, R.id.age, R.id.phone}
        );
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Map<String, Object> map = mList.get(position);
                Log.e("test111", "name : " + map.get("name"));
            }
        });
    }

    private void initData() {
        mList = new ArrayList<>();
        Map<String, Object> map = new HashMap();
        map.put("photo", resIds[0]);
        map.put("name", "jim");
        map.put("id", 1);
        map.put("age", 23);
        map.put("phone", "13888888888");
        mList.add(map);
        Map<String, Object> map1 = new HashMap();
        map1.put("photo", resIds[1]);
        map1.put("name", "tom");
        map1.put("id", 2);
        map1.put("age", 28);
        map1.put("phone", "13888888666");
        mList.add(map1);
        Map<String, Object> map2 = new HashMap();
        map2.put("photo", R.mipmap.football);
        map2.put("name", "jack");
        map2.put("id", 3);
        map2.put("age", 21);
        map2.put("phone", "13888888999");
        mList.add(map2);
    }
}