package com.example.android.pets.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.arch.persistence.room.Room;

@Database(entities = {Pet.class}, version = 1)
public abstract class PetsDatabase extends RoomDatabase {
    public final static int GENDER_MALE = 1;
    public final static int GENDER_FEMALE = 2;
    public final static int GENDER_UNKNOWN = 0;
    public final static String DATABASE_NAME = "pets-db";
    private static PetsDatabase sInstance;
    public static PetsDatabase getDatabase(final Context context) {
        if (sInstance == null) {
            synchronized (PetsDatabase.class) {
                if (sInstance == null) {
                    sInstance = Room.databaseBuilder(context.getApplicationContext(), PetsDatabase.class, DATABASE_NAME)
                            .build();
                }
            }

        }
        return sInstance;
    }

}

