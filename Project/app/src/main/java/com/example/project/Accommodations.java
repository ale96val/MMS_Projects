package com.example.project;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class Accommodations extends AppCompatActivity {
    //Set to List.
    List<String> StringSet = new ArrayList<>();
    ItemAdapter adapter = new ItemAdapter(StringSet) {
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accommodations);
        RecyclerView eventList = findViewById(R.id.accommodationList);
        eventList.setAdapter(adapter);
        eventList.setLayoutManager(new LinearLayoutManager(this));
        Locale current = getResources().getConfiguration().locale;
        if(current.toString().equals("en_US") || current.toString().equals("en_us")) {
            StringSet.add("Hotel Warszawa,9,Ul. Swidnicka (Wroclaw),100zl/night");
            StringSet.add("Appartament City Centre,10,Rynek (Wroclaw),200zl/night");
            StringSet.add("Hostel Studenkie,6,Ul. Tramwajowa (Wroclaw),20zl/night");
            StringSet.add("Hostel EuroStars,9,Ul. Poznanska (Wroclaw),100zl/night");
            StringSet.add("Hostel Lux,10,Arkady Capitol (Wroclaw),200zl/night");
        }else{
            StringSet.add("Hotel Varsovia, 9, Calle Swidnicka (Wroclaw), 100zl/noche");
            StringSet.add("Apartametos Centro Ciudad, 10, Rynek (Wroclaw), 200zl/noche");
            StringSet.add("Hostal de estudiantes, 6, Calle Tramwajowa (Wroclaw), 20zl/noche");
            StringSet.add("Hotel EuroStars, 9, Calle Poznanska (Wroclaw), 100zl/noche");
            StringSet.add("Hootel Lux, 10, ArkadyCapitol (Wroclaw), 200zl/noche");
        }
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(eventList);
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
                    Intent intent = new Intent(Accommodations.this, AccommodationDetails.class);
                    intent.putExtra("Accommodation",StringSet.get(position));
                    startActivity(intent);
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
            adapter.notifyDataSetChanged();
        }

    public abstract static class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
        public static class ViewHolder extends RecyclerView.ViewHolder {
            public TextView AccommodationTitle;
            public TextView AccommodationRate;
            public TextView AccommodationLocation;
            public TextView AccommodationPrice;
            public ImageView AccommodationImage;
            public ViewHolder(View itemView) {
                super(itemView);
                AccommodationTitle = itemView.findViewById(R.id.accommodationTitle);
                AccommodationRate = itemView.findViewById(R.id.accommodationRate);
                AccommodationLocation = itemView.findViewById(R.id.accommodationLocation);
                AccommodationPrice= itemView.findViewById(R.id.accommodationPrice);
                AccommodationImage = itemView.findViewById(R.id.eventDetailImage1);
            }
        }
        private final List<String> mAccommodations;
        public ItemAdapter(List<String> Events) {
            mAccommodations = Events;
        }
        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Context context = parent.getContext();
            LayoutInflater inflater = LayoutInflater.from(context);
            View ItemView = inflater.inflate(R.layout.item_layout_accommodations, parent, false);
            return new ViewHolder(ItemView);
        }
        @SuppressLint("SetTextI18n")
        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            String Task = mAccommodations.get(position);
            TextView AccommodationTitle = holder.AccommodationTitle;
            TextView AccommodationRate = holder.AccommodationRate;
            TextView AccommodationLocation = holder.AccommodationLocation;
            TextView AccommodationPrice = holder.AccommodationPrice;
            ImageView AccommodationImage = holder.AccommodationImage;
            AccommodationTitle.setText(Task.split(",")[0]);
            AccommodationRate.setText(Task.split(",")[1]);
            AccommodationLocation.setText(Task.split(",")[2]);
            AccommodationPrice.setText(Task.split(",")[3]);
            if(AccommodationTitle.getText().equals("Hotel Warszawa")){
                AccommodationImage.setImageResource(R.drawable.skyscrapper_foreground);
            }else if(AccommodationTitle.getText().equals("Appartament City Centre") || AccommodationTitle.getText().equals("Apartamentos Centro Ciudad")){
                AccommodationImage.setImageResource(R.drawable.house_foreground);
            }else if(AccommodationTitle.getText().equals("Hostel Studenkie")){
                AccommodationImage.setImageResource(R.drawable.studenthouse_foreground);
            }else if(AccommodationTitle.getText().equals("Hostel EuroStars")){
                AccommodationImage.setImageResource(R.drawable.skyscrapper_foreground);
            }else{
                AccommodationImage.setImageResource(R.drawable.skyscrapper_foreground);
            }
        }

        @Override
        public int getItemCount() {
            return mAccommodations.size();
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