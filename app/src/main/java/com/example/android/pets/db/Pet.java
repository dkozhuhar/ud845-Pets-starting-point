package com.example.android.pets.db;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

@Entity(tableName = "pets")
public class Pet implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    public long _id;
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

    public static final Creator<Pet> CREATOR = new Creator<Pet>() {
        @Override
        public Pet createFromParcel(Parcel in) {
            return new Pet(in);
        }

        @Override
        public Pet[] newArray(int size) {
            return new Pet[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    //Constructor to recreate object from Parcel
    public Pet(Parcel in){
        this._id = in.readLong();
        this.name = in.readString();
        this.breed = in.readString();
        this.gender =in.readInt();
        this.weight = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int i) {
        dest.writeLong(_id);
        dest.writeString(name);
        dest.writeString(breed);
        dest.writeInt(gender);
        dest.writeInt(weight);
    }
}
