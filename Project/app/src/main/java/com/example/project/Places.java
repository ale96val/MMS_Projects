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


public class Places extends AppCompatActivity {
    //Set to List.
    List<String> StringSet = new ArrayList<>();
    ItemAdapter adapter = new ItemAdapter(StringSet) {
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.places);
        RecyclerView eventList = findViewById(R.id.accommodationList);
        eventList.setAdapter(adapter);
        Locale current = getResources().getConfiguration().locale;
        eventList.setLayoutManager(new LinearLayoutManager(this));
        if(current.toString().equals("en_US") || current.toString().equals("en_us")) {
            StringSet.add("Rynek Square,9,Ul. Rynek (Wroclaw),free");
            StringSet.add("Zoo,10,Ul. Tramwajowa (Wroclaw),60zl");
            StringSet.add("Wroclaw Urzad Mieski,6,Ul. Arkady Capitol (Wroclaw),free");
            StringSet.add("Wyspa Slodowa,9,Plac Bema (Wroclaw),free");
            StringSet.add("Main Train Station,10, Wroclaw Glowny (Wroclaw),free");
        }else{
            StringSet.add("Plaza del mercado, 9, Rynek (Wroclaw), gratis");
            StringSet.add("Zoo, 10, Calle Tramwajowa (Wroclaw), 60zl");
            StringSet.add("Ayuntamiento de Wroclaw, 6, Calle Arkady Capitol (Wroclaw), gratis");
            StringSet.add("Isla Slodowa, 9, Plaza Bema (Wroclaw), gratis");
            StringSet.add("Estación de Wroclaw, 10, Wroclaw Glowny (Wroclaw), free");
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
                    Intent intent = new Intent(Places.this, PlacesDetails.class);
                    intent.putExtra("Place",StringSet.get(position));
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
            public TextView PlaceTitle;
            public TextView PlaceRate;
            public TextView PlaceLocation;
            public TextView PlacePrice;
            public ImageView PlaceImage;
            public ViewHolder(View itemView) {
                super(itemView);
                PlaceTitle = itemView.findViewById(R.id.accommodationTitle);
                PlaceRate = itemView.findViewById(R.id.accommodationRate);
                PlaceLocation = itemView.findViewById(R.id.accommodationLocation);
                PlacePrice= itemView.findViewById(R.id.accommodationPrice);
                PlaceImage = itemView.findViewById(R.id.eventDetailImage1);
            }
        }
        private final List<String> mPlaces;
        public ItemAdapter(List<String> Events) {
            mPlaces = Events;
        }
        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Context context = parent.getContext();
            LayoutInflater inflater = LayoutInflater.from(context);
            View ItemView = inflater.inflate(R.layout.item_layout_places, parent, false);
            return new ViewHolder(ItemView);
        }
        @SuppressLint("SetTextI18n")
        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            String Task = mPlaces.get(position);
            TextView PlaceTitle = holder.PlaceTitle;
            TextView PlaceRate = holder.PlaceRate;
            TextView PlaceLocation = holder.PlaceLocation;
            TextView PlacePrice = holder.PlacePrice;
            ImageView PlaceImage = holder.PlaceImage;
            PlaceTitle.setText(Task.split(",")[0]);
            PlaceRate.setText(Task.split(",")[1]);
            PlaceLocation.setText(Task.split(",")[2]);
            PlacePrice.setText(Task.split(",")[3]);
            if(PlaceTitle.getText().equals("Rynek Square") || PlaceTitle.getText().equals("Plaza del mercado")){
                PlaceImage.setImageResource(R.drawable.skyscrapper_foreground);
            }else if(PlaceTitle.getText().equals("Zoo")){
                PlaceImage.setImageResource(R.drawable.house_foreground);
            }else if(PlaceTitle.getText().equals("Wroclaw Urzad Mieski") || PlaceTitle.getText().equals("Ayuntamiento de Wroclaw")){
                PlaceImage.setImageResource(R.drawable.studenthouse_foreground);
            }else if(PlaceTitle.getText().equals("Wyspa Slodowa") || PlaceTitle.getText().equals("Isla Slodowa")){
                PlaceImage.setImageResource(R.drawable.ic_baseline_wb_cloudy_24);
            }else{
                PlaceImage.setImageResource(R.drawable.trip_icon);
            }
        }

        @Override
        public int getItemCount() {
            return mPlaces.size();
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