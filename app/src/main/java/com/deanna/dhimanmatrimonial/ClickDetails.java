package com.deanna.dhimanmatrimonial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class ClickDetails extends AppCompatActivity {
    private TextView fragmentname,fragmentgmail,fragmentlocation,fragmentfather,fragmentmother,fragmentdob,fragmentpob,fragmenttob,fragmentgender,fragmentcast,
            fragmentgotr,fragmentheight,fragmentcomplexon,fragmentqualification,fragmentocupation,fragmentsibling,fragmenthobbies,fragmentaddress;
    private CircleImageView fragmentcircleimage;
    private ProgressBar fragmentprogressbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click_details);

        fragmentname = findViewById(R.id.fragmentname);
        fragmentgmail = findViewById(R.id.fragmentgmail);
        fragmentlocation = findViewById(R.id.fragmentlocation);
        fragmentfather = findViewById(R.id.fragmentfather);
        fragmentmother = findViewById(R.id.fragmentmother);
        fragmentdob = findViewById(R.id.fragmentdob);
        fragmentpob = findViewById(R.id.fragmentpob);
        fragmenttob = findViewById(R.id.fragmenttob);
        fragmentgender = findViewById(R.id.fragmentgender);
        fragmentcast = findViewById(R.id.fragmentcast);
        fragmentgotr = findViewById(R.id.fragmentgotr);
        fragmentheight = findViewById(R.id.fragmentheight);
        fragmentcomplexon = findViewById(R.id.fragmentcomplexon);
        fragmentqualification = findViewById(R.id.fragmentqualification);
        fragmentocupation = findViewById(R.id.fragmentocupation);
        fragmentsibling = findViewById(R.id.fragmentsibling);
        fragmenthobbies = findViewById(R.id.fragmenthobbies);
        fragmentaddress = findViewById(R.id.fragmentaddress);
        fragmentcircleimage =findViewById(R.id.userdpOnClickDetails);



        Bundle bundle= getIntent().getBundleExtra("valueBundle");

        // Text
        String nameKey=bundle.getString("name");
        String gmailKey=bundle.getString("gmail");
        String locationkey=bundle.getString("location");
        String fatherkey=bundle.getString("father");
        String motherkey=bundle.getString("mother");
        String dobkey=bundle.getString("dob");
        String pobkey=bundle.getString("pob");
        String tobkey=bundle.getString("tob");
        String genderkey=bundle.getString("gender");
        String castkey=bundle.getString("cast");
        String gotrkey=bundle.getString("gotr");
        String heightkey=bundle.getString("height");
        String complexonkey=bundle.getString("complexon");
        String qualificationkey=bundle.getString("qualification");
        String ocupationkey=bundle.getString("ocupation");
        String siblingkey=bundle.getString("sibling");
        String hobbieskey=bundle.getString("hobbies");
        String addresskey=bundle.getString("address");




        fragmentname.setText(nameKey);
        fragmentgmail.setText(gmailKey);
        fragmentlocation.setText(locationkey);
        fragmentfather.setText(fatherkey);
        fragmentmother.setText(motherkey);
        fragmentdob.setText(dobkey);
        fragmentpob.setText(pobkey);
        fragmenttob.setText(tobkey);
        fragmentgender.setText(genderkey);
        fragmentcast.setText(castkey);
        fragmentgotr.setText(gotrkey);
        fragmentheight.setText(heightkey);
        fragmentcomplexon.setText(complexonkey);
        fragmentqualification.setText(qualificationkey);
        fragmentocupation.setText(ocupationkey);
        fragmentsibling.setText(siblingkey);
        fragmenthobbies.setText(hobbieskey);
        fragmentaddress.setText(addresskey);
        //Image
        Picasso.get().load(Uri.parse(getIntent().getStringExtra("dp"))).into(fragmentcircleimage);

    }

}
