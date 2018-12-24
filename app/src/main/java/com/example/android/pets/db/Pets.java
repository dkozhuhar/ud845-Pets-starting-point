package com.example.android.pets.db;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class Pets {
    @PrimaryKey
    @NonNull
    public int _id;
    public String name;
    public String breed;
    public int gender;
    public int weight;
}
