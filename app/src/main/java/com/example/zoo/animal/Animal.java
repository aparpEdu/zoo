package com.example.zoo.animal;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Animal implements Parcelable {
    private String name;
    private String type;
    private String breed;

    public Animal(String name, String type, String breed) {
        this.name = name;
        this.type = type;
        this.breed = breed;
    }

    protected Animal(Parcel in) {
        name = in.readString();
        type = in.readString();
        breed = in.readString();
    }

    public static final Creator<Animal> CREATOR = new Creator<Animal>() {
        @Override
        public Animal createFromParcel(Parcel in) {
            return new Animal(in);
        }

        @Override
        public Animal[] newArray(int size) {
            return new Animal[size];
        }
    };

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getBreed() {
        return breed;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(type);
        parcel.writeString(breed);
    }
}
