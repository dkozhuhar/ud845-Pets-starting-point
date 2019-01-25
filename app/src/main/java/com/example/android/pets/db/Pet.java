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

    public Pet(String name){
        this.name = name;
        this.breed = "lol";
        this.gender = PetsDatabase.GENDER_UNKNOWN;
        this.weight = 0;
    }
}
