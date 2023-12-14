package com.example.zoo.cell;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.example.zoo.animal.Animal;

import java.util.ArrayList;
import java.util.List;

public class Cell implements Parcelable {
    private String name;
    private String biome;
    private String type;
    private List<Animal> animals = new ArrayList<>();

    public Cell(String name, String biome, String type ) {
        this.name = name;
        this.biome = biome;
        this.type = type;
    }

    protected Cell(Parcel in) {
        name = in.readString();
        biome = in.readString();
        type = in.readString();
        animals = in.createTypedArrayList(Animal.CREATOR);
    }

    public static final Creator<Cell> CREATOR = new Creator<Cell>() {
        @Override
        public Cell createFromParcel(Parcel in) {
            return new Cell(in);
        }

        @Override
        public Cell[] newArray(int size) {
            return new Cell[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(biome);
        parcel.writeString(type);
        parcel.writeTypedList(animals);
    }

    public String getName() {
        return name;
    }

    public String getBiome() {
        return biome;
    }

    public String getType() {
        return type;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }
}
