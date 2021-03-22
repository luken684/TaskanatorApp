package com.example.taskanatorapp;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

class ManageTasksAdapter extends
        RecyclerView.Adapter<ManageTasksAdapter.ViewHolder>{

    private System system;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private CardView cardView;

        public ViewHolder(CardView v){
            super(v);
            cardView = v;
        }
    }

    public ManageTasksAdapter(System system){
        this.system = system;
    }

    @Override
    public int getItemCount(){
        return system.getAllTasks().size(); //getAllTasks to be defined in Task Class.
    }

    @Override
    public ManageTasksAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        CardView cv = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_manage_tasks, parent, false);
        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        CardView cardView = holder.cardView;
        TextView taskTitle = (TextView)cardView.findViewById(R.id.Task_Title);
        TextView taskCategory = (TextView)cardView.findViewById(R.id.Task_Category);
        TextView taskDescription = (TextView)cardView.findViewById(R.id.Task_Description);

        Task currentTask = system.getAllTasks().get(position); //Pending addition of Task class
        taskTitle.setText(currentTask.getTaskName());
        taskCategory.setText(currentTask.getTaskCategory());
        taskDescription.setText(currentTask.getTaskDescription());
    }
}
