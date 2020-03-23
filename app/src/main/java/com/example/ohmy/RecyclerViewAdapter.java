package com.example.ohmy;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Herdi_WORK on 15.09.16.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private List<Task> dataList;
    private final LayoutInflater mInflater;
//    private ArrayList<String> TaskName = new ArrayList<>();
//    private ArrayList<String> DueDate = new ArrayList<>();
//    private ArrayList<String> TaskInfo = new ArrayList<>();
    //private Context context;

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public ConstraintLayout constraintLayout;
        public MyViewHolder(ConstraintLayout v){
            super(v);
            constraintLayout = v;
        }
    }

    public RecyclerViewAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        ConstraintLayout v = (ConstraintLayout) mInflater.inflate(R.layout.view_rv_item, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position){
        CheckBox task = (CheckBox)  holder.constraintLayout.getViewById(R.id.checkBox);
        TextView name = (TextView) holder.constraintLayout.getViewById(R.id.tv_task);
        TextView due = (TextView) holder.constraintLayout.getViewById(R.id.tv_date);

        if (dataList != null) {
            Task current = dataList.get(position);
            task.setText(current.getTaskName());
            task.setText(current.getDueDate());
            task.setChecked(current.isDone() ? true: false);
        } else {
            task.setText("No Task");
        }

        final int pos = position;
        task.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                dataList.get(pos).setDone(isChecked);
            }
        });
    }

    public void setTasks(List<Task> tasks){
        //Collections.sort(tasks);
        dataList = tasks;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        if (dataList != null)
            return dataList.size();
        else return 0;
    }
}
