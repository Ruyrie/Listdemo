package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.view.LayoutInflater;
import com.example.listdemo1.R;
import java.util.List;

import bean.Student;

public class StudentBaseAdapter extends BaseAdapter {
    private List<Student> mList;
    private LayoutInflater mInflater;
    public StudentBaseAdapter(Context context, List<Student> list) {
        mList = list;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Student getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.array_adapter_item, parent, false);
            viewHolder.nameText = convertView.findViewById(R.id.name);
            viewHolder.numberText = convertView.findViewById(R.id.number);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Student student = getItem(position);
        if (student != null) {
            viewHolder.nameText.setText(student.getName());
            viewHolder.numberText.setText(student.getNumber());
        }
        return convertView;
    }

    public static class ViewHolder {
        TextView nameText;
        TextView numberText;
    }
}

