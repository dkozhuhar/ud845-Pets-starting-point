package com.example.android.pets.db;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.arch.persistence.room.Room;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

@Database(entities = {Pet.class}, version = 1)
public abstract class PetsDatabase extends RoomDatabase {
    public final static int GENDER_MALE = 1;
    public final static int GENDER_FEMALE = 2;
    public final static int GENDER_UNKNOWN = 0;
    public final static String DATABASE_NAME = "pets-db";
    public abstract PetDao petDao();
    private static PetsDatabase sInstance;
    public static PetsDatabase getDatabase(final Context context) {
        if (sInstance == null) {
            synchronized (PetsDatabase.class) {
                if (sInstance == null) {
                    sInstance = Room.databaseBuilder(context.getApplicationContext(), PetsDatabase.class, DATABASE_NAME)
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }

        }
        return sInstance;
    }
    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsync(sInstance).execute();
        }
    };
    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {
        private final PetDao mDao;

        public PopulateDbAsync(PetsDatabase db) {
            mDao = db.petDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {

            Pet pet = new Pet("1st");
            mDao.insert(pet);
            return null;
        }
    }

}

