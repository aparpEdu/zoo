package com.example.zoo.animal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zoo.R;

import java.util.List;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalViewHolder> {

    private Context context;
    private List<Animal> animals;

    public AnimalAdapter(List<Animal> animals) {
        this.animals = animals;
    }

    @NonNull
    @Override
    public AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View cellView = inflater.inflate(R.layout.animal, parent, false);
        return new AnimalViewHolder(cellView);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalViewHolder holder, int position) {
        Animal animal = animals.get(position);

        holder.setBreed(animal.getBreed());
        holder.setName(animal.getName());
        holder.setType(animal.getType());

        holder.itemView.setOnLongClickListener(view -> {
            animals.remove(position);
            notifyItemRemoved(position);
            return false;
        });
    }

    @Override
    public int getItemCount() {
        return animals.size();
    }
}
