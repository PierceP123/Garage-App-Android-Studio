package com.example.garageapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    RadioButton car, bike, other;
    Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        car = findViewById(R.id.rdbCars);
        bike = findViewById(R.id.rdbBikes);
        other = findViewById(R.id.rdbOther);
        start = findViewById(R.id.getBtn);

        TextView text = findViewById(R.id.textView);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (car.isChecked()) {
                    Intent intent = new Intent(MainActivity.this, CarsActivity.class);
                    startActivity(intent);
                } else if (bike.isChecked()) {
                    Intent intent = new Intent(MainActivity.this, BikesActivity.class);
                    startActivity(intent);
                } else if (other.isChecked()) {
                    Intent intent = new Intent(MainActivity.this, ToolsActivity.class);
                    startActivity(intent);
                } else {
                    String result = "None";
                }
            }
        });

    }
}


