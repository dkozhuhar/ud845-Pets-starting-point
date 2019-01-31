package com.example.android.pets.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface PetDao {
    @Insert
    long insert (Pet pet);

    @Query("SELECT * FROM pets")
    LiveData<List<Pet>> getAllPets();

    @Query("DELETE FROM pets")
    void deleteAll();
}
