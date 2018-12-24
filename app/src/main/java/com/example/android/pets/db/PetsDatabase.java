package com.example.android.pets.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Pets.class}, version = 1)
public class PetsDatabase extends RoomDatabase {
    private static PetsDatabase sInstance;
}

