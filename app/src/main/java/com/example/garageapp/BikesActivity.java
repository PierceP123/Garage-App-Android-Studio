package com.example.garageapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class BikesActivity extends AppCompatActivity implements RecyclerViewInterface  {

    ArrayList<Model> models = new ArrayList<>();
    int[] bikeImages = {R.drawable.a3,R.drawable.bike2000,R.drawable.blackbike,
            R.drawable.caferace,R.drawable.police,R.drawable.sp150,R.drawable.a3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cars);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        setModels();
        MyAdapter adapter = new MyAdapter(this, models, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton floatingActionButton = findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BikesActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    private void setModels(){
        String[] bikeName = getResources().getStringArray(R.array.bike_name);
        String[] bikeYear = getResources().getStringArray(R.array.bike_year);
        String[] bikePrice = getResources().getStringArray(R.array.bike_price);
        String[] bikeDescription = getResources().getStringArray(R.array.bike_description);

        for (int i = 0; i < bikeName.length; i++ ){
            models.add(new Model(bikeName[i], bikeYear[i], bikePrice[i],
                    bikeImages[i], bikeDescription[i]));
        }
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(BikesActivity.this, ThreeActivity.class);

        intent.putExtra("Name", models.get(position).getName());
        intent.putExtra("Year", models.get(position).getYear());
        intent.putExtra("Price", models.get(position).getPrice());
        intent.putExtra("Description", models.get(position).getDescription());
        intent.putExtra("Image", models.get(position).getImage());
        startActivity(intent);
    }
}



