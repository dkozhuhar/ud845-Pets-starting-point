package com.example.android.pets.db;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "pets")
public class Pet {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    public int _id;
    @NonNull
    public String name;
    public String breed;
    @NonNull
    public int gender;
    @NonNull
    public int weight;

    public Pet(String name, String breed, int gender, int weight){
        this.name = name;
        this.breed = breed;
        this.gender = gender;
        this.weight = weight;
    }
}
