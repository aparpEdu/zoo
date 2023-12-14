package com.example.zoo.cell;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zoo.R;

public class CellViewHolder extends RecyclerView.ViewHolder {
    private final TextView biome;
    private final TextView type;
    public CellViewHolder(@NonNull View itemView) {
        super(itemView);
        biome = itemView.findViewById(R.id.biome);
        type = itemView.findViewById(R.id.type);

    }

    public void setBiome(String biome) {
        this.biome.setText(biome);
    }

    public void setType(String type) {
        this.type.setText(type);
    }
}
