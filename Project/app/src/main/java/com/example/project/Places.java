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


public class Places extends AppCompatActivity {
    //Set to List.
    List<String> StringSet = new ArrayList<>();
    ItemAdapter adapter = new ItemAdapter(StringSet) {
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.places);
        RecyclerView eventList = findViewById(R.id.placesList);
        eventList.setAdapter(adapter);
        eventList.setLayoutManager(new LinearLayoutManager(this));
        StringSet.add("Hotel Warszawa,9/10,Ul. Swidnicka (Wroclaw),100zl/night");
        StringSet.add("Appartament City Centre,10/10,Rynek (Wroclaw),200zl/night");
        StringSet.add("Hostel Studenkie,6/10,Ul. Tramwajowa (Wroclaw),20zl/night");
        StringSet.add("Hostel EuroStars,9/10,Ul. Poznanska (Wroclaw),100zl/night");
        StringSet.add("Hostel Lux,10/10,Arkady Capitol (Wroclaw),200zl/night");
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
            public TextView PlaceTitle;
            public TextView PlaceRate;
            public TextView PlaceLocation;
            public TextView PlacePrice;
            public ImageView PlaceImage;
            public ViewHolder(View itemView) {
                super(itemView);
                PlaceTitle = itemView.findViewById(R.id.placeTitle);
                PlaceRate = itemView.findViewById(R.id.placeRate);
                PlaceLocation = itemView.findViewById(R.id.placeLocation);
                PlacePrice= itemView.findViewById(R.id.placePrice);
                PlaceImage = itemView.findViewById(R.id.placeImage);
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
            if(PlaceTitle.getText().equals("Hotel Warszawa")){
                PlaceImage.setImageResource(R.drawable.skyscrapper_foreground);
            }else if(PlaceTitle.getText().equals("Appartament City Centre")){
                PlaceImage.setImageResource(R.drawable.house_foreground);
            }else if(PlaceTitle.getText().equals("Hostel Studenkie")){
                PlaceImage.setImageResource(R.drawable.studenthouse_foreground);
            }else if(PlaceTitle.getText().equals("Hostel EuroStars")){
                PlaceImage.setImageResource(R.drawable.ic_launcher_background);
            }else{
                PlaceImage.setImageResource(R.drawable.ic_launcher_background);
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