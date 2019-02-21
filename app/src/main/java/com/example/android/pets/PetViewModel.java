package com.example.android.pets;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.example.android.pets.db.Pet;
import com.example.android.pets.db.PetDao;
import com.example.android.pets.db.PetsDatabase;

import java.util.List;

public class PetViewModel extends AndroidViewModel {
    private LiveData<List<Pet>> allPets;
    public long lastInsertedPetId = 0;
    private PetDao petDao;

    public LiveData<List<Pet>> getAllPets() {
        Log.v("PetViewModel", "getAllPets called");
        return allPets;
    }

    public PetViewModel(Application application) {
        super(application);
        PetsDatabase db = PetsDatabase.getDatabase(application);
        petDao = db.petDao();
        allPets = petDao.getAllPets();
    }

    public void insert(final Pet pet) {
        if (validatePet(pet)) {
            new AsyncTask<Void, Void, Long>() {

                @Override
                protected Long doInBackground(Void... voids) {
                    return petDao.insert(pet);
                }

                @Override
                protected void onPostExecute(Long aLong) {
                    Toast.makeText(getApplication(), "Pet saved with id:" + aLong, Toast.LENGTH_LONG).show();
                }
            }.execute();
        }
    }

    //Sanity check
    private boolean validatePet(Pet pet) {
        if (TextUtils.isEmpty(pet.name) && TextUtils.isEmpty(pet.breed) && pet.gender == PetsDatabase.GENDER_UNKNOWN && pet.weight == 0) {
            return false;
        }
        if (TextUtils.isEmpty(pet.name)) {
            throw new IllegalArgumentException("Pet requires a name");
        }
        if (pet.weight < 0) {
            throw new IllegalArgumentException("Pet cannot have negative weight");
        }
        return true;
    }

    public void update(final Pet pet) {
        if (validatePet(pet)) {
            new AsyncTask<Void, Void, Integer>() {

                @Override
                protected Integer doInBackground(Void... voids) {
                    return petDao.update(pet);
                }

                @Override
                protected void onPostExecute(Integer aLong) {
                    Toast.makeText(getApplication(), "Pet saved with id:" + aLong, Toast.LENGTH_LONG).show();
                }
            }.execute();
        }
    }

    public void deletePet(Pet pet) {
        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... voids) {
                petDao.delete(pet);
                return null;
            }

            @Override
            protected void onPostExecute(Void aLong) {
                Toast.makeText(getApplication(), "Pet deleted", Toast.LENGTH_LONG).show();
            }
        }.execute();

    }

    public void deleteAll(){
        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... voids) {
                petDao.deleteAll();
                return null;
            }

            @Override
            protected void onPostExecute(Void aLong) {
                Toast.makeText(getApplication(), "All pets are deleted", Toast.LENGTH_LONG).show();
            }
        }.execute();
    }
}
