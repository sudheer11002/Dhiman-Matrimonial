package com.deanna.dhimanmatrimonial.Fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.deanna.dhimanmatrimonial.Adapters.ValueAdapter;
import com.deanna.dhimanmatrimonial.Model.DataModelClass;
import com.deanna.dhimanmatrimonial.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;


public class Female extends Fragment {

    private RecyclerView femalerecyclerView;
    private List<DataModelClass> list;
    private ValueAdapter valueAdapter;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_female, container, false);

        // ID
        femalerecyclerView = view.findViewById(R.id.femalerecyclerview);


        // Array list
        list = new ArrayList<>();

        //set adaper Recycleview

        femalerecyclerView.setHasFixedSize(true);
        femalerecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        valueAdapter = new ValueAdapter(getActivity(),list);
        femalerecyclerView.setAdapter(valueAdapter);


        FirebaseDatabase.getInstance().getReference().child("Female").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                if (dataSnapshot.exists()){

                    DataModelClass dataModelClass  = dataSnapshot.getValue(DataModelClass.class);

                    list.add(dataModelClass);

                    valueAdapter.notifyDataSetChanged();

                }else{


                }
            }
            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        return view;
    }

}
