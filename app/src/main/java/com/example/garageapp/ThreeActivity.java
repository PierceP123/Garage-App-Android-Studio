package com.example.garageapp;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ThreeActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);

        String name = getIntent().getStringExtra("Name");
        String year = getIntent().getStringExtra("Year");
        String price = getIntent().getStringExtra("Price");
        String description = getIntent().getStringExtra("Description");
        int image = getIntent().getIntExtra("Image", 0);

        TextView nameView = findViewById(R.id.item_name);
        TextView yearView = findViewById(R.id.year_view);
        TextView priceView = findViewById(R.id.price_view);
        TextView descriptionView = findViewById(R.id.description_view);
        ImageView items_image = findViewById(R.id.imageView);

        nameView.setText(name);
        yearView.setText(year);
        priceView.setText(price);
        descriptionView.setText(description);
        items_image.setImageResource(image);

        ImageButton backButton = findViewById(R.id.backButton);
        ImageButton homeButton = findViewById(R.id.homeButton);
        ImageButton adButton = findViewById(R.id.ad);

        adButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.donedeal.ie/";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThreeActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
