package com.example.zoo.cell;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.zoo.MainActivity;
import com.example.zoo.R;
import com.example.zoo.animal.Animal;
import com.example.zoo.animal.AnimalAdapter;
import com.example.zoo.animal.AnimalDialogFragment;
import com.example.zoo.animal.AnimalListener;

import java.util.ArrayList;
import java.util.List;

public class CellDataActivity extends AppCompatActivity implements AnimalListener {


    RecyclerView recyclerView;
    List<Animal> animals = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cell_data);
        recyclerView = findViewById(R.id.animalsRecycler);
        TextView name = findViewById(R.id.cellNameView);
        TextView type = findViewById(R.id.cellTypeView);
        TextView biome = findViewById(R.id.biomeView);
        Cell cell = getIntent().getParcelableExtra("cell");

        if(cell != null) {
            animals = cell.getAnimals();
            AnimalAdapter adapter = new AnimalAdapter(animals);
            Log.d("wtf", cell.getAnimals().toString());
            name.setText(cell.getName());
            type.setText(cell.getType());
            biome.setText(cell.getBiome());
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            findViewById(R.id.add).setOnClickListener(view -> {
                Bundle bundle = new Bundle();
                bundle.putString("type",cell.getType());
                bundle.putParcelable("cell", cell);
                Log.d("type", cell.getType());
                AnimalDialogFragment fragment = AnimalDialogFragment.newInstance(bundle);
                fragment.setListener(this);
                fragment.show(getSupportFragmentManager(), "AnimalDialogFragment");
            });
        }
        findViewById(R.id.back).setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.putExtra("cell", cell);
            intent.putExtra("position", getIntent().getIntExtra("pos", 0));
            startActivity(intent);
        });

    }

    @Override
    public void addItem(Animal animal) {
        Resources resources = getResources();
        recyclerView.setBackgroundColor(resources.getColor(R.color.yellow));
        int numberOfAnimals = animals.size();
        animals.add(animal);
        recyclerView.getAdapter().notifyItemInserted(numberOfAnimals);
    }
}