package adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listdemo1.R;
import bean.Student;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private List<Student> mList;
    private OnItemClickListener mClickListener;
    private OnItemLongClickListener mLongClickListener;
    public RecyclerAdapter(List<Student> list, OnItemClickListener listener) {
        mList = list;
        mClickListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Student student = mList.get(position);
        if (student != null) {
            holder.nameText.setText(student.getName());
            holder.numberText.setText(student.getNumber());
        }
        holder.main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mClickListener.onItemClick(student);
            }
        });
        holder.main.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mLongClickListener.onItemLongClick(student);
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout main;
        TextView nameText;
        TextView numberText;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            main = itemView.findViewById(R.id.main);
            nameText = itemView.findViewById(R.id.name);
            numberText = itemView.findViewById(R.id.number);
        }
    }

    public void setOnItemLongClickListener(OnItemLongClickListener listener) {
        mLongClickListener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(Student student);
    }

    public interface OnItemLongClickListener {
        void onItemLongClick(Student student);
    }
}
