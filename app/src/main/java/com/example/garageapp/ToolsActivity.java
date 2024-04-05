package com.example.garageapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ToolsActivity extends AppCompatActivity implements RecyclerViewInterface  {

    ArrayList<Model> models = new ArrayList<>();
    int[] toolImages = {R.drawable.spanner,R.drawable.spoke,R.drawable.plierspack,
            R.drawable.flatscrew,R.drawable.hexdriver,R.drawable.wrench,R.drawable.crimping};

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
                Intent intent = new Intent(ToolsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    private void setModels(){
        String[] toolName = getResources().getStringArray(R.array.tool_name);
        String[] toolYear = getResources().getStringArray(R.array.tool_year);
        String[] toolPrice = getResources().getStringArray(R.array.tool_price);
        String[] toolDescription = getResources().getStringArray(R.array.tool_description);

        for (int i = 0; i < toolName.length; i++ ){
            models.add(new Model(toolName[i], toolYear[i], toolPrice[i],
                    toolImages[i], toolDescription[i]));
        }
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(ToolsActivity.this, ThreeActivity.class);

        intent.putExtra("Name", models.get(position).getName());
        intent.putExtra("Year", models.get(position).getYear());
        intent.putExtra("Price", models.get(position).getPrice());
        intent.putExtra("Description", models.get(position).getDescription());
        intent.putExtra("Image", models.get(position).getImage());
        startActivity(intent);
    }
}





