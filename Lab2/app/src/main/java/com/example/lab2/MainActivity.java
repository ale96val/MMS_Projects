package com.example.lab2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.HashSet;
import java.util.Set;


public class MainActivity extends AppCompatActivity {
    //Set to List.
    Set<String> StringSet = new HashSet<>();
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
    }

    protected void onResume() {
        super.onResume();

    }
    @SuppressLint("NotifyDataSetChanged")
    protected void onStart() {
        super.onStart();
        SharedPreferences sharedPref = getSharedPreferences("Task",Context.MODE_PRIVATE);
        String task = sharedPref.getString("Task", "default");
        if(!task.equals("default")){
            StringSet.add("'" + task + "'");
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.clear();
            editor.apply();
            SharedPreferences sharedPref2 = getSharedPreferences("Tasks",Context.MODE_PRIVATE);
            SharedPreferences.Editor editor2 = sharedPref2.edit();
            editor2.putStringSet("Tasks", StringSet);
            Log.d("TAG", StringSet.toString());
            editor2.apply();
            adapter.notifyDataSetChanged();
        }
    }
    public abstract static class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
        public static class ViewHolder extends RecyclerView.ViewHolder {
            public TextView TaskText;
            public ImageView TaskImage;
            public ViewHolder(View itemView) {
                super(itemView);
                TaskText = itemView.findViewById(R.id.TaskText);
                TaskImage = itemView.findViewById(R.id.TaskImage);
            }
        }
        private final Set<String> mTasks;
        public ItemAdapter(Set<String> Tasks) {
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
            String Task = mTasks[position];
            TextView textView = holder.TaskText;
            textView.setText("Test");
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