package com.deanna.dhimanmatrimonial.Fragments;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.deanna.dhimanmatrimonial.EditDetails;
import com.deanna.dhimanmatrimonial.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.Objects;

import de.hdodenhof.circleimageview.CircleImageView;


public class MyProfile extends Fragment {

    private AppCompatButton edit;
    private TextView mobnum,name,gmail,location,father,mother,dob,pob,tob,gender,cast,gotr,height,complexon,qualification,ocupation,sibling,hobbies,address;
    private  String mobile;
    private CircleImageView profilephoto;
    private ProgressBar profileprogressbar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_my_profile, container, false);

        mobnum = view.findViewById(R.id.mobNumber);
        name = view.findViewById(R.id.name);
        gmail = view.findViewById(R.id.gmail);
        location = view.findViewById(R.id.location);
        father = view.findViewById(R.id.father);
        mother = view.findViewById(R.id.mother);
        dob = view.findViewById(R.id.dob);
        pob = view.findViewById(R.id.pob);
        tob = view.findViewById(R.id.tob);
        gender = view.findViewById(R.id.gender);
        cast = view.findViewById(R.id.cast);
        gotr = view.findViewById(R.id.gotr);
        height = view.findViewById(R.id.height);
        complexon = view.findViewById(R.id.complexon);
        qualification = view.findViewById(R.id.qualification);
        ocupation = view.findViewById(R.id.ocupation);
        sibling = view.findViewById(R.id.sibling);
        hobbies = view.findViewById(R.id.hobbies);
        address = view.findViewById(R.id.address);
        edit = view.findViewById(R.id.edit);

        profileprogressbar=view.findViewById(R.id.profilebar);
        profilephoto =view.findViewById(R.id.profilephoto);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String  username,usergmail, userlocation, userfather,usermother,userdob,userpob,usertob,usergender,usercast,usergotr,userheight,usercomplexon,
                        userqualification,userocupation,usersibling,userhobbies,useraddress;

                username= name.getText().toString();
                usergmail= gmail.getText().toString();
                userlocation = location.getText().toString();
                userfather = father.getText().toString();
                usermother = mother.getText().toString();
                userdob = dob.getText().toString();
                userpob = pob.getText().toString();
                usertob = tob.getText().toString();
                usergender = gender.getText().toString();
                usercast = cast.getText().toString();
                usergotr = gotr.getText().toString();
                userheight = height.getText().toString();
                usercomplexon = complexon.getText().toString();
                userqualification = qualification.getText().toString();
                userocupation = ocupation.getText().toString();
                usersibling = sibling.getText().toString();
                userhobbies = hobbies.getText().toString();
                useraddress = address.getText().toString();

                Bundle bundle = new Bundle();
                bundle.putString("nameKey",username);
                bundle.putString("gmailkey",usergmail);
                bundle.putString("locationkey",userlocation);
                bundle.putString("fatherkey",userfather);
                bundle.putString("motherkey",usermother);
                bundle.putString("dobkey",userdob);
                bundle.putString("pobkey",userpob);
                bundle.putString("tobkey",usertob);
                bundle.putString("genderkey",usergender);
                bundle.putString("castkey",usercast);
                bundle.putString("gotrkey",usergotr);
                bundle.putString("heightkey",userheight);
                bundle.putString("complexonkey",usercomplexon);
                bundle.putString("qualificationkey",userqualification);
                bundle.putString("ocupationkey",userocupation);
                bundle.putString("siblingkey",usersibling);
                bundle.putString("hobbieskey",userhobbies);
                bundle.putString("addresskey",useraddress);
                Intent i = new Intent(getActivity(), EditDetails.class);
                i.putExtra("data",bundle);
                startActivity(i);

            }
        });

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        profileprogressbar.setVisibility(View.GONE);

        mobile=  FirebaseAuth.getInstance().getCurrentUser().getPhoneNumber();
        mobnum.setText(mobile);

        DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference().child("Male");
        databaseReference.child(mobile).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    name.setText(dataSnapshot.child("Username").getValue().toString());
                    gmail.setText(dataSnapshot.child("Usergmail").getValue().toString());
                    location.setText(dataSnapshot.child("Userlocation").getValue().toString());
                    father.setText(dataSnapshot.child("Userfather").getValue().toString());
                    mother.setText(dataSnapshot.child("Usermother").getValue().toString());
                    dob.setText(dataSnapshot.child("Userdob").getValue().toString());
                    pob.setText(dataSnapshot.child("Userpob").getValue().toString());
                    tob.setText(dataSnapshot.child("Usertob").getValue().toString());
                    gender.setText(dataSnapshot.child("Usergender").getValue().toString());
                    cast.setText(dataSnapshot.child("Usercast").getValue().toString());
                    gotr.setText(dataSnapshot.child("Usergotr").getValue().toString());
                    height.setText(dataSnapshot.child("Userheight").getValue().toString());
                    complexon.setText(dataSnapshot.child("Usercomplexon").getValue().toString());
                    qualification.setText(dataSnapshot.child("Userqualification").getValue().toString());
                    ocupation.setText(dataSnapshot.child("Usercupation").getValue().toString());
                    sibling.setText(dataSnapshot.child("Usersibling").getValue().toString());
                    hobbies.setText(dataSnapshot.child("Userhobbies").getValue().toString());
                    address.setText(dataSnapshot.child("Useraddress").getValue().toString());
                    if (dataSnapshot.child("dp").exists()){
                        String link=dataSnapshot.child("dp").getValue().toString();
                        Picasso.get().load(link).into(profilephoto);
                    }
                    else {
                        Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/dhimanmatrimonial-75657.appspot.com/o/UserDp%2Fdp.png?alt=media&token=c8c037e3-8644-494f-978a-98c6687e6b7e").into(profilephoto);
                    }


                }else {
                    Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/himachali-trends-3a6f3.appspot.com/o/UserDp%2Fdp.png?alt=media&token=9bfd77ca-2551-4e3b-a087-dd968a9ec317").into(profilephoto);

                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }

        });




        DatabaseReference databaseReference2= FirebaseDatabase.getInstance().getReference().child("Female");
        databaseReference2.child(mobile).addValueEventListener(new ValueEventListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    name.setText(dataSnapshot.child("Username").getValue().toString());
                    gmail.setText(dataSnapshot.child("Usergmail").getValue().toString());
                    location.setText(dataSnapshot.child("Userlocation").getValue().toString());
                    father.setText(dataSnapshot.child("Userfather").getValue().toString());
                    mother.setText(dataSnapshot.child("Usermother").getValue().toString());
                    dob.setText(dataSnapshot.child("Userdob").getValue().toString());
                    pob.setText(dataSnapshot.child("Userpob").getValue().toString());
                    tob.setText(dataSnapshot.child("Usertob").getValue().toString());
                    gender.setText(dataSnapshot.child("Usergender").getValue().toString());
                    cast.setText(dataSnapshot.child("Usercast").getValue().toString());
                    gotr.setText(dataSnapshot.child("Usergotr").getValue().toString());
                    height.setText(dataSnapshot.child("Userheight").getValue().toString());
                    complexon.setText(dataSnapshot.child("Usercomplexon").getValue().toString());
                    qualification.setText(dataSnapshot.child("Userqualification").getValue().toString());
                    ocupation.setText(dataSnapshot.child("Usercupation").getValue().toString());
                    sibling.setText(dataSnapshot.child("Usersibling").getValue().toString());
                    hobbies.setText(dataSnapshot.child("Userhobbies").getValue().toString());
                    address.setText(dataSnapshot.child("Useraddress").getValue().toString());
                    if (dataSnapshot.child("dp").exists()){
                        String link= Objects.requireNonNull(dataSnapshot.child("dp").getValue()).toString();
                        Picasso.get().load(link).into(profilephoto);
                    }
                    else {

                        Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/dhimanmatrimonial-75657.appspot.com/o/UserDp%2Fdp.png?alt=media&token=c8c037e3-8644-494f-978a-98c6687e6b7e").into(profilephoto);
                    }

                }else {

                    if (dataSnapshot.child("dp").exists()){
                        String link= Objects.requireNonNull(dataSnapshot.child("dp").getValue()).toString();
                        Picasso.get().load(link).into(profilephoto);
                    }
//                    Toast.makeText(getContext(), "value one", Toast.LENGTH_SHORT).show();
//                    Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/himachali-trends-3a6f3.appspot.com/o/UserDp%2Fdp.png?alt=media&token=9bfd77ca-2551-4e3b-a087-dd968a9ec317").into(profilephoto);

                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }

        });
    }

}
