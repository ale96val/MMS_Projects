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


public class Routes extends AppCompatActivity {
    //Set to List.
    List<String> StringSet = new ArrayList<>();
    ItemAdapter adapter = new ItemAdapter(StringSet) {
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.routes);
        RecyclerView eventList = findViewById(R.id.accommodationList);
        eventList.setAdapter(adapter);
        Locale current = getResources().getConfiguration().locale;
        eventList.setLayoutManager(new LinearLayoutManager(this));
        if(current.toString().equals("en_US") || current.toString().equals("en_us")) {
            StringSet.add("Mountains near to Wroclaw,9,Karpacz,6zl");
            StringSet.add("City tour,10,Rynek (Wroclaw),60zl");
            StringSet.add("Stone City,6,Czech Republic,20zl");
        }else{
            StringSet.add("Montañas cerca de Wroclaw, 9, Karpacz, 6zl");
            StringSet.add("Tour por la ciudad, 10, Rynek (Wroclaw), 60zl");
            StringSet.add("Ciudad de piedra, 6, República Checa, 20zl");
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
                    Intent intent = new Intent(Routes.this, RoutesDetails.class);
                    intent.putExtra("Route",StringSet.get(position));
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
            public TextView RouteTitle;
            public TextView RouteRate;
            public TextView RouteLocation;
            public TextView RoutePrice;
            public ImageView RouteImage;
            public ViewHolder(View itemView) {
                super(itemView);
                RouteTitle = itemView.findViewById(R.id.accommodationTitle);
                RouteRate = itemView.findViewById(R.id.accommodationRate);
                RouteLocation = itemView.findViewById(R.id.accommodationLocation);
                RoutePrice= itemView.findViewById(R.id.accommodationPrice);
                RouteImage = itemView.findViewById(R.id.eventDetailImage1);
            }
        }
        private final List<String> mRoutes;
        public ItemAdapter(List<String> Events) {
            mRoutes = Events;
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
            String Task = mRoutes.get(position);
            TextView PlaceTitle = holder.RouteTitle;
            TextView PlaceRate = holder.RouteRate;
            TextView PlaceLocation = holder.RouteLocation;
            TextView PlacePrice = holder.RoutePrice;
            ImageView PlaceImage = holder.RouteImage;
            PlaceTitle.setText(Task.split(",")[0]);
            PlaceRate.setText(Task.split(",")[1]);
            PlaceLocation.setText(Task.split(",")[2]);
            PlacePrice.setText(Task.split(",")[3]);
            if(PlaceTitle.getText().equals("Mountains near to Wroclaw") || PlaceTitle.getText().equals("Montañas cerca de Wroclaw")){
                PlaceImage.setImageResource(R.drawable.trip_icon);
            }else if(PlaceTitle.getText().equals("City tour") || PlaceTitle.getText().equals("Tour por la ciudad")){
                PlaceImage.setImageResource(R.drawable.ic_baseline_wb_cloudy_24);
            }else{
                PlaceImage.setImageResource(R.drawable.studenthouse_foreground);
            }
        }

        @Override
        public int getItemCount() {
            return mRoutes.size();
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