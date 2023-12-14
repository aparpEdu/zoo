package com.example.zoo.cell;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zoo.R;

import java.util.List;

public class CellAdapter extends RecyclerView.Adapter<CellViewHolder> {
    private Context context;
    private List<Cell> cells;

    public CellAdapter(List<Cell> cells) {
        this.cells = cells;
    }


    @NonNull
    @Override
    public CellViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View zooView = inflater.inflate(R.layout.cell, parent, false);
        return new CellViewHolder(zooView);
    }

    @Override
    public void onBindViewHolder(@NonNull CellViewHolder holder, int position) {
        Cell cell = cells.get(position);

        holder.setBiome(cell.getBiome());
        holder.setType(cell.getType());

        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(context, CellDataActivity.class);
            intent.putExtra("cell", cell);
            intent.putExtra("pos", position);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return cells.size();
    }
}
