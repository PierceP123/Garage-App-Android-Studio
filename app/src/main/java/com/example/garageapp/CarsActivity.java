package com.example.garageapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class CarsActivity extends AppCompatActivity implements RecyclerViewInterface  {

    ArrayList<Model> models = new ArrayList<>();
    int[] carImages = {R.drawable.hyundaicalypso,R.drawable.vinfast,R.drawable.skoda,
            R.drawable.mazdaiconic,R.drawable.chrysler,R.drawable.dodgeram,R.drawable.minicountryman};

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
                Intent intent = new Intent(CarsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }

    private void setModels(){
        String[] carName = getResources().getStringArray(R.array.car_name);
        String[] carYear = getResources().getStringArray(R.array.car_year);
        String[] carPrice = getResources().getStringArray(R.array.car_price);
        String[] carDescription = getResources().getStringArray(R.array.car_description);

        for (int i = 0; i < carName.length; i++ ){
            models.add(new Model(carName[i], carYear[i], carPrice[i],
                    carImages[i], carDescription[i]));
        }
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(CarsActivity.this, ThreeActivity.class);

        intent.putExtra("Name", models.get(position).getName());
        intent.putExtra("Year", models.get(position).getYear());
        intent.putExtra("Price", models.get(position).getPrice());
        intent.putExtra("Description", models.get(position).getDescription());
        intent.putExtra("Image", models.get(position).getImage());
        startActivity(intent);
    }
}
