package com.example.lab2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class MainActivity extends AppCompatActivity {
    //Set to List.
    List<String> StringSet = new ArrayList<>();
    ItemAdapter adapter = new ItemAdapter(StringSet) {
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        RecyclerView TaskList = findViewById(R.id.TaskList);
        TaskList.setAdapter(adapter);
        TaskList.setLayoutManager(new LinearLayoutManager(this));
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(TaskList);

    }

    ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            final int position = viewHolder.getAdapterPosition();
            switch (direction) {
                case ItemTouchHelper.LEFT:
                    StringSet.remove(position);
                    adapter.notifyItemRemoved(position);
                    break;
                case ItemTouchHelper.RIGHT:
                    String task = StringSet.get(position);
                    String[] task2 = task.split(",");
                    for (int i = 0; i < task2.length; i++){
                        Log.d("TAG",task2[i]);
                        if(task2[i].equals("true")){
                            task2[i] = "false";
                            break;
                        }
                        if(task2[i].equals("false")){
                            task2[i] = "true";
                            break;
                        }
                    }
                    task = TextUtils.join(",", task2);
                    StringSet.set(position, task);
                    adapter.notifyItemRemoved(position);
                    break;
        }
        }
    };

    protected void onResume() {
        super.onResume();

    }
    @SuppressLint("NotifyDataSetChanged")
    protected void onStart() {
        super.onStart();
        SharedPreferences sharedPref = getSharedPreferences("Task",Context.MODE_PRIVATE);
        String task = sharedPref.getString("Task", "default");
        if(!task.equals("default")){
            StringSet.add(task);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.clear();
            editor.apply();
            SharedPreferences sharedPref2 = getSharedPreferences("Tasks",Context.MODE_PRIVATE);
            SharedPreferences.Editor editor2 = sharedPref2.edit();
            Set set2 = new HashSet(StringSet);
            editor2.putStringSet ("Tasks", set2);
            Log.d("TAG", StringSet.toString());
            editor2.apply();
            adapter.notifyDataSetChanged();
        }
    }
    public abstract static class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
        public static class ViewHolder extends RecyclerView.ViewHolder {
            public TextView TaskText1;
            public TextView TaskText2;
            public TextView TaskText3;
            public TextView TaskText4;
            public TextView TaskStatus;
            public ImageView TaskImage;
            public ViewHolder(View itemView) {
                super(itemView);
                TaskText1 = itemView.findViewById(R.id.TaskText);
                TaskText2 = itemView.findViewById(R.id.taskText2);
                TaskText3 = itemView.findViewById(R.id.taskText3);
                TaskText4 = itemView.findViewById(R.id.taskText4);
                TaskStatus = itemView.findViewById(R.id.taskStatus);
                TaskImage = itemView.findViewById(R.id.TaskImage);
            }
        }
        private final List<String> mTasks;
        public ItemAdapter(List<String> Tasks) {
            mTasks = Tasks;
        }
        @NonNull
        @Override
        public ItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Context context = parent.getContext();
            LayoutInflater inflater = LayoutInflater.from(context);
            View ItemView = inflater.inflate(R.layout.item_layout, parent, false);
            return new ViewHolder(ItemView);
        }
        @SuppressLint("SetTextI18n")
        @Override
        public void onBindViewHolder(ItemAdapter.ViewHolder holder, int position) {
            String Task = mTasks.get(position);
            Log.d("TAG", Task.split(",")[1]);
            TextView textView1 = holder.TaskText1;
            TextView textView2 = holder.TaskText2;
            TextView textView3 = holder.TaskText3;
            TextView textView4 = holder.TaskText4;
            TextView taskStatus = holder.TaskStatus;
            ImageView imageView = holder.TaskImage;
            textView1.setText(Task.split(",")[0]);
            textView2.setText(Task.split(",")[1]);
            textView3.setText(Task.split(",")[2]);
            textView4.setText(Task.split(",")[3]);
            if(Task.split(",")[4].equals("false")){
                taskStatus.setText("Not done");
            }else{
                taskStatus.setText("Done");
            }

            if(textView3.getText().equals("To Do")){
                imageView.setImageResource(R.drawable.ic_baseline_assistant_24);
            }
            if(textView3.getText().equals("Email")){
                imageView.setImageResource(R.drawable.ic_baseline_email_24);
            }
            if(textView3.getText().equals("Phone")){
                imageView.setImageResource(R.drawable.ic_baseline_local_phone_24);
            }
            if(textView3.getText().equals("Meet")){
                imageView.setImageResource(R.drawable.ic_baseline_local_phone_24);
            }

        }

        @Override
        public int getItemCount() {
            return mTasks.size();
        }
    }

    protected void onRestart() {
        super.onRestart();

    }
    protected void onStop() {
        super.onStop();

    }
    protected void onPause() {
        super.onPause();

    }
    protected void onDestroy() {
        super.onDestroy();

    }

    public void addElement(View view) {
        Intent intent = new Intent(this, AddActivity.class);
        startActivity(intent);
    }
}