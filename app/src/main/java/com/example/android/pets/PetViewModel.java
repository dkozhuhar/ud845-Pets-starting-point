package com.example.android.pets;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.example.android.pets.db.Pet;
import com.example.android.pets.db.PetDao;
import com.example.android.pets.db.PetsDatabase;

import java.util.List;

public class PetViewModel extends AndroidViewModel {
    private LiveData<List<Pet>> allPets;

    private PetDao petDao;
    public LiveData<List<Pet>> getAllPets() {
        return allPets;
    }

    public PetViewModel(Application application) {
        super(application);
        PetsDatabase db = PetsDatabase.getDatabase(application);
        petDao = db.petDao();
        allPets = petDao.getAllPets();
    }
}
