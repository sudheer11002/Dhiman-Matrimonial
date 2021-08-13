package com.deanna.dhimanmatrimonial.Fragments;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.deanna.dhimanmatrimonial.EntermobileNumber;
import com.deanna.dhimanmatrimonial.R;
import com.deanna.dhimanmatrimonial.WebView;
import com.google.firebase.auth.FirebaseAuth;


public class Setting extends Fragment {

    private AppCompatButton contactUs,logOut;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setting, container, false);

        contactUs = view.findViewById(R.id.contact_us);
        logOut = view.findViewById(R.id.log);


        contactUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getActivity(),WebView.class);
                startActivity(intent);
            }
        });


        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder =new AlertDialog.Builder(getActivity());
                builder.setTitle("Log Out !!! ");
                builder.setMessage("Are you sure you want to Log out!");

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        FirebaseAuth.getInstance().signOut();
                        Toast.makeText(getContext(), "Log out !", Toast.LENGTH_SHORT).show();
                        Intent intent =new Intent(getActivity().getApplicationContext(), EntermobileNumber.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        getActivity().finish();
                    }
                });
                builder.show();

            }
        });
        return  view;
    }

}
