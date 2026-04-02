package adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.listdemo1.R;

import java.util.List;

import bean.Student;

public class StudentArrayAdapter extends ArrayAdapter<Student> {

    public StudentArrayAdapter(@NonNull Context context, List<Student> list) {
        super(context, 0,list);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Log.d("test111", "======getView======");
        Student student = getItem(position);
    if (convertView ==null){
        Log.e("test111", "======convertView==null======" );
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.array_adapter_item,parent,false);

    }
    TextView nameText = convertView.findViewById(R.id.name);
    TextView numberText = convertView.findViewById(R.id.number);

    if (student!=null){
        nameText.setText(student.getName());
        numberText.setText(student.getNumber());
        convertView.setTag(student);
    }


        return convertView;
    }
}
