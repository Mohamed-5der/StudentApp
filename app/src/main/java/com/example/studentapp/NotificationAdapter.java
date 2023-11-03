package com.example.studentapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationViewHolder> {
    ArrayList<DataNotification> dataNotifications;

    public NotificationAdapter(ArrayList<DataNotification> dataNotifications) {
        this.dataNotifications = dataNotifications;
    }

    @NonNull
    @Override
    public NotificationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_notification_custom,null,false);
        return new NotificationViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationViewHolder holder, int position) {
        DataNotification dataNotification=dataNotifications.get(position);
        holder.onBind(dataNotification);

    }

    @Override
    public int getItemCount() {
        return dataNotifications.size();
    }
}
class NotificationViewHolder extends RecyclerView.ViewHolder{
    TextView visitDone,date,description;
    public NotificationViewHolder(@NonNull View itemView) {
        super(itemView);
        visitDone=itemView.findViewById(R.id.txt_visitDone);
        date=itemView.findViewById(R.id.txt_date);
        description=itemView.findViewById(R.id.txt_description);
    }
    public void onBind(DataNotification dataNotification){
           visitDone.setText(dataNotification.getVisitDone());
           date.setText(dataNotification.getDate());
        description.setText(dataNotification.getDescription());
    }
}