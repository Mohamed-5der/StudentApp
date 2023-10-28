package com.example.studentapp;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GroupAdapter extends RecyclerView.Adapter<GroupViewHolder> {
    ArrayList<DataQuiz> dataQuizzes;

    public GroupAdapter(ArrayList<DataQuiz> dataQuizzes) {
        this.dataQuizzes = dataQuizzes;
    }


    @NonNull
    @Override
    public GroupViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_groub,null,false);
        return new GroupViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull GroupViewHolder holder, int position) {
        DataQuiz dataQuiz = dataQuizzes.get(position);
        holder.onBind(dataQuiz);
    }

    @Override
    public int getItemCount() {
        return dataQuizzes.size();
    }
}
class GroupViewHolder extends RecyclerView.ViewHolder{
 TextView nameGroup;
 LinearLayout selectGroup;
    public GroupViewHolder(@NonNull View itemView) {
        super(itemView);
        nameGroup = itemView.findViewById(R.id.txt_nameGroup);
        selectGroup = itemView.findViewById(R.id.l_selectGroup);
    }
    public void onBind(DataQuiz dataQuizzes){
        nameGroup.setText(dataQuizzes.getName());
        selectGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AttendanceFragment.groupName = String.valueOf(nameGroup.getText());
                AttendanceFragment.selectGroup.setText(String.valueOf(nameGroup.getText()));
                AttendanceFragment.dialog.dismiss();
            }
        });

    }
}
