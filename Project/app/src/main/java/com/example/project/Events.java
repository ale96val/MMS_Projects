package com.example.project;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class Events extends AppCompatActivity {
    //Set to List.
    List<String> StringSet = new ArrayList<>();
    ItemAdapter adapter = new ItemAdapter(StringSet) {
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.events);
        RecyclerView eventList = findViewById(R.id.eventsList);
        eventList.setAdapter(adapter);
        eventList.setLayoutManager(new LinearLayoutManager(this));
        StringSet.add("Theater in English,20/10/2020,Opera of Wroclaw,20zl");
        StringSet.add("Trip to Warszawa,10/10/2020,Wroclaw Main Station,200zl,");
        StringSet.add("SkyTower Visit,12/10/2020,SKyTower of Wroclaw,6zl,");
    }

    protected void onResume() {
        super.onResume();

    }

    @SuppressLint("NotifyDataSetChanged")
    protected void onStart() {
        super.onStart();
            adapter.notifyDataSetChanged();
        }

    public abstract static class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
        public static class ViewHolder extends RecyclerView.ViewHolder {
            public TextView EventTitle;
            public TextView EventDate;
            public TextView EventLocation;
            public TextView EventPrice;
            public ImageView EventImage;
            public ViewHolder(View itemView) {
                super(itemView);
                EventTitle = itemView.findViewById(R.id.eventTitle);
                EventDate = itemView.findViewById(R.id.eventDate);
                EventLocation = itemView.findViewById(R.id.eventLocation);
                EventPrice= itemView.findViewById(R.id.eventPrice);
                EventImage = itemView.findViewById(R.id.eventImage);
            }
        }
        private final List<String> mEvents;
        public ItemAdapter(List<String> Events) {
            mEvents = Events;
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
            String Task = mEvents.get(position);
            TextView EventTitle = holder.EventTitle;
            TextView EventDate = holder.EventDate;
            TextView EventLocation = holder.EventLocation;
            TextView EventPrice = holder.EventPrice;
            ImageView EventImage = holder.EventImage;
            EventTitle.setText(Task.split(",")[0]);
            EventDate.setText(Task.split(",")[1]);
            EventLocation.setText(Task.split(",")[2]);
            EventPrice.setText(Task.split(",")[3]);
            if(EventTitle.getText().equals("Theater in English")){
                EventImage.setImageResource(R.drawable.theater_icon);
            }else if(EventTitle.getText().equals("Trip to Warszawa")){
                EventImage.setImageResource(R.drawable.trip_icon);
            }else{
                EventImage.setImageResource(R.drawable.ic_launcher_background);
            }
        }

        @Override
        public int getItemCount() {
            return mEvents.size();
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
}