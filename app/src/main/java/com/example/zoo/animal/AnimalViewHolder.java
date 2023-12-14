package com.example.zoo.animal;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zoo.R;

import org.w3c.dom.Text;

public class AnimalViewHolder extends RecyclerView.ViewHolder {
    private final TextView name;
    private final TextView type;
    private final TextView breed;
    public AnimalViewHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.animalNameView);
        type = itemView.findViewById(R.id.animalTypeView);
        breed = itemView.findViewById(R.id.animalBreed);
    }


    public void setName(String name) {
        this.name.setText(name);
    }

    public void setType(String type) {
        this.type.setText(type);
    }

    public void setBreed(String breed) {
        this.breed.setText(breed);
    }
}
