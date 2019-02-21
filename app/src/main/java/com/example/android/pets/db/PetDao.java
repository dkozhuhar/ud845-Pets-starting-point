package com.example.android.pets.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import android.database.Cursor;

import java.util.List;

@Dao
public interface PetDao {
    @Insert
    long insert (Pet pet);

    @Query("SELECT * FROM pets")
    LiveData<List<Pet>> getAllPets();

    @Query("SELECT * FROM pets")
    Cursor getAllPetsCursor();


    @Query("DELETE FROM pets")
    void deleteAll();

    @Delete
    void delete(Pet pet);

    @Update
    int update (Pet pet);
}
