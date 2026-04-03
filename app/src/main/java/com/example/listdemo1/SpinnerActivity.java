package com.example.listdemo1;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class SpinnerActivity extends AppCompatActivity {
    private Spinner mSpinner1;
    private Spinner mSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        String[] array = getResources().getStringArray(R.array.my_array);

        // spinner1 (dialog 模式)
        mSpinner1 = findViewById(R.id.spinner1);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, array);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner1.setAdapter(adapter1);
        mSpinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String s = (String) parent.getSelectedItem();
                Log.d("test111", "spinner1 选中了: " + s);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Log.d("test111", "spinner1 没有选中");
            }
        });

        // spinner2 (dropdown 模式)
        mSpinner = findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, array);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(adapter);
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // String s = array[position];
                // String s = mSpinner.getSelectedItem().toString();
                //String s = (String) parent.getItemAtPosition(position);
                String s = (String) parent.getSelectedItem();
                Log.d("test111", "spinner2 选中了: " + s);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Log.d("test111", "spinner2 没有选中");
            }
        });
    }
}
