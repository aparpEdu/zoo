package com.example.zoo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.zoo.cell.Cell;
import com.example.zoo.cell.CellAdapter;
import com.example.zoo.cell.CellSource;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recycler);
        List<Cell> cells = CellSource.getCells();
        CellAdapter adapter = new CellAdapter(cells);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Cell cell = getIntent().getParcelableExtra("cell");
        if(cell != null) {
           cells.set(getIntent().getIntExtra("position", 0), cell);
           recyclerView.getAdapter().notifyItemChanged(getIntent().getIntExtra("position", 0));
        }
    }
}