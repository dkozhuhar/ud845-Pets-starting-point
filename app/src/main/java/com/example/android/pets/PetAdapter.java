package com.example.android.pets;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.android.pets.db.Pet;

import java.util.List;

public class PetAdapter extends RecyclerView.Adapter<PetAdapter.MyViewHolder> {
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout listItemView;
        public MyViewHolder(LinearLayout view) {
            super(view);
            listItemView = view;
        }
    }

    private List<Pet> mPets;

    @Override @NonNull
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int integer) {
        LinearLayout listItemView = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);

        return  new MyViewHolder(listItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Pet current = mPets.get(position);
        TextView petName = holder.listItemView.findViewById(R.id.name);
        petName.setText(current.name);
        TextView petBreed = holder.listItemView.findViewById(R.id.summary);
        petBreed.setText(current.breed);
        holder.listItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), EditorActivity.class);
                intent.putExtra("parcel_data", current);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mPets.size();
    }

    public PetAdapter(List<Pet> pets) {
        super();
        mPets = pets;
    }
}
