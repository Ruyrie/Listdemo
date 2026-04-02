package com.example.listdemo1;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class SimpleCursorAdapterActivity extends AppCompatActivity {
    private ListView mListView;
    private Handler mHandler;
    private SimpleCursorAdapter mAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        mListView = findViewById(R.id.listview);
        initHandler();
        if (checkPermission()) {
            getContacts();
        }
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Cursor cursor = (Cursor) mAdapter.getItem(position);
                @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));

                @SuppressLint("Range") String number = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                Log.d("test111", "======" + name + "======" + number);
            }
        });
    }

    private boolean checkPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_CONTACTS, Manifest.permission.WRITE_CONTACTS},
                    0);
            return false;
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 0) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getContacts();
            }
        }
    }

    private void initHandler() {
        mHandler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(@NonNull Message msg) {
                Cursor cursor = (Cursor) msg.obj;
                mAdapter = new SimpleCursorAdapter(
                        SimpleCursorAdapterActivity.this,
                        R.layout.array_adapter_item,
                        cursor,
                        new String[]{ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME, ContactsContract.CommonDataKinds.Phone.NUMBER},
                        new int[]{R.id.name, R.id.number},
                        0);
                mListView.setAdapter(mAdapter);
                return false;
            }
        });
    }

    private void getContacts() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                ContentResolver resolver = getContentResolver();
                Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
                Cursor cursor = resolver.query(uri, null, null, null, null);

                Message message = Message.obtain();
                message.what = 1;
                message.obj = cursor;
                mHandler.sendMessage(message);
            }
        }).start();
    }
}