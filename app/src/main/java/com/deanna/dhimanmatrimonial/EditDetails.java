package com.deanna.dhimanmatrimonial;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.UploadTask;

import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;

import de.hdodenhof.circleimageview.CircleImageView;

public class EditDetails extends AppCompatActivity {

    private String mobile;
    private TextView name,gmail,location,father,mother,dob,pob,tob,cast,gotr,height,complexon,qualification,ocupation,sibling,hobbies,address;
   private Spinner spinner;
    private AppCompatButton savedata;
    private Uri uri;
    private ProgressBar progressBar;
    private ImageButton add;
    private CircleImageView dp;
    private HashMap<String, String> transfer = new HashMap<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_details);


        //ID circleimage view
        dp = findViewById(R.id.dp);

        //ID select photo from gallery
        add=findViewById(R.id.addImage);

        //ID Edit text
        name=findViewById(R.id.username);
        gmail=findViewById(R.id.usergmail);
        location=findViewById(R.id.userlocation);
        father=findViewById(R.id.userfather);
        mother=findViewById(R.id.usermother);
        dob=findViewById(R.id.userdateofbirth);
        pob=findViewById(R.id.userplaceofbirth);
        tob=findViewById(R.id.usertimeofbirth);
        //Gender spinner
        spinner=findViewById(R.id.genderspinner);
        cast=findViewById(R.id.usercast);
        gotr=findViewById(R.id.usergotr);
        height=findViewById(R.id.userhight);
        complexon=findViewById(R.id.usercomplexon);
        qualification=findViewById(R.id.userqualification);
        ocupation=findViewById(R.id.userocupation);
        sibling=findViewById(R.id.usersbling);
        hobbies=findViewById(R.id.userhobbies);
        address=findViewById(R.id.useraddress);

        //ID prograssbar
        progressBar=findViewById(R.id.bar);

        //ID button Save
        savedata = findViewById(R.id.savedata);

        progressBar.setVisibility(View.GONE);


        Bundle bundle= getIntent().getBundleExtra("data");

        String editDetailsName=bundle.getString("nameKey");
        String editDetailsgmail=bundle.getString("gmailkey");
        String editDetailsLocation=bundle.getString("locationkey");
        String editDetailsFather=bundle.getString("fatherkey");
        String editDetailsmother=bundle.getString("motherkey");
        String editDetailsdob=bundle.getString("dobkey");
        String editDetailspob=bundle.getString("pobkey");
        String editDetailstob=bundle.getString("tobkey");
//        String hh=bundle.getString("genderkey");
        String editDetailscast=bundle.getString("castkey");
        String editDetailsgotr=bundle.getString("gotrkey");
        String editDetailsheight=bundle.getString("heightkey");
        String editDetailscomplexon=bundle.getString("complexonkey");
        String editDetailsqualification=bundle.getString("qualificationkey");
        String editDetailsocupation=bundle.getString("ocupationkey");
        String editDetailssibling=bundle.getString("siblingkey");
        String editDetailshobbies=bundle.getString("hobbieskey");
        String editDetailsaddress=bundle.getString("addresskey");

        name.setText(editDetailsName);
        gmail.setText(editDetailsgmail);
        location.setText(editDetailsLocation);
        father.setText(editDetailsFather);
        mother.setText(editDetailsmother);
        dob.setText(editDetailsdob);
        pob.setText(editDetailspob);
        tob.setText(editDetailstob);
        spinner.setSelection(0);
        cast.setText(editDetailscast);
        gotr.setText(editDetailsgotr);
        height.setText(editDetailsheight);
        complexon.setText(editDetailscomplexon);
        qualification.setText(editDetailsqualification);
        ocupation.setText(editDetailsocupation);
        sibling.setText(editDetailssibling);
        hobbies.setText(editDetailshobbies);
        address.setText(editDetailsaddress);


        savedata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditDetails.this, TabsActivity.class );
                startActivity(intent);
                finish();
            }
        });

        // Open gallery
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent,11);
            }
        });

        savedata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos =spinner.getSelectedItemPosition();
                mobile=  FirebaseAuth.getInstance().getCurrentUser().getPhoneNumber();


                String sendname=name.getText().toString();
                String sendgmail=gmail.getText().toString();
                String sendlocation=location.getText().toString();
                String sendfather=father.getText().toString();
                String sendmother=mother.getText().toString();
                String senddob=dob.getText().toString();
                String sendpob=pob.getText().toString();
                String sendtob=tob.getText().toString();
                String sendgender=spinner.getSelectedItem().toString();
                String sendcast=cast.getText().toString();
                String sendgotr=gotr.getText().toString();
                String sendheight=height.getText().toString();
                String sendcomplexon=complexon.getText().toString();
                String sendqualification=qualification.getText().toString();
                String sendocupation=ocupation.getText().toString();
                String sendsibling=sibling.getText().toString();
                String sendhobbies=hobbies.getText().toString();
                String sendaddress=address.getText().toString();


                transfer.put("Usernobile",mobile);
                transfer.put("Username",sendname);
                transfer.put("Usergmail",sendgmail);
                transfer.put("Userlocation",sendlocation);
                transfer.put("Userfather",sendfather);
                transfer.put("Usermother",sendmother);
                transfer.put("Userdob",senddob);
                transfer.put("Userpob",sendpob);
                transfer.put("Usertob",sendtob);
                transfer.put("Usergender",sendgender);
                transfer.put("Usercast",sendcast);
                transfer.put("Usergotr",sendgotr);
                transfer.put("Userheight",sendheight);
                transfer.put("Usercomplexon",sendcomplexon);
                transfer.put("Userqualification",sendqualification);
                transfer.put("Usercupation",sendocupation);
                transfer.put("Usersibling",sendsibling);
                transfer.put("Userhobbies",sendhobbies);
                transfer.put("Useraddress",sendaddress);

                if (name==null){
                    Toast.makeText(EditDetails.this, "Enter your name", Toast.LENGTH_SHORT).show();
                }else if (location==null){
                    Toast.makeText(EditDetails.this, "Enter your location", Toast.LENGTH_SHORT).show();
                } else if (uri==null){
                    Toast.makeText(EditDetails.this, "Please upload your profile", Toast.LENGTH_SHORT).show();
                }else if (pos==0){
                    Toast.makeText(EditDetails.this, "Please select your gender", Toast.LENGTH_SHORT).show();
                }else {
                    if (pos==1){
                        Male();
                    }else {
                        Female();
                    }
                }
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 11 && resultCode == RESULT_OK) {
            uri = data.getData();
            dp.setImageURI(uri);
        }
    }

    private void Male(){
        final DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference();
        final String uniqueID = UUID.randomUUID().toString();

        progressBar.setVisibility(View.VISIBLE);

        FirebaseStorage.getInstance().getReference().child("UserDp").child(uniqueID+".PNG").putFile(uri).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {

                if(task.isSuccessful()){
                    FirebaseStorage.getInstance().getReference().child("UserDp").child(uniqueID+".PNG").getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
                        @Override
                        public void onComplete(@NonNull Task<Uri> task) {

                            transfer.put("dp", Objects.requireNonNull(task.getResult()).toString());

                            databaseReference.child("Male").child(Objects.requireNonNull(Objects.requireNonNull(FirebaseAuth.getInstance()
                                    .getCurrentUser()).getPhoneNumber())).setValue(transfer).addOnCompleteListener(new OnCompleteListener<Void>() {

                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {

                                        Toast.makeText(getApplication(), "Upload Successful", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(EditDetails.this, TabsActivity.class );
                                        startActivity(intent);
                                        finish();
                                    } else {
                                        Toast.makeText(getApplication(), "Upload Again", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                        }
                    });

                }else {
                    Toast.makeText(getApplication(), "Try uploading again", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void Female(){
        final DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference();
        final String uniqueID = UUID.randomUUID().toString();

        progressBar.setVisibility(View.VISIBLE);

        FirebaseStorage.getInstance().getReference().child("UserDp").child(uniqueID+".PNG")
                .putFile(uri).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {

                if(task.isSuccessful()){
                    FirebaseStorage.getInstance().getReference().child("UserDp").child(uniqueID+".PNG").getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
                        @Override
                        public void onComplete(@NonNull Task<Uri> task) {

                            transfer.put("dp", Objects.requireNonNull(task.getResult()).toString());

                            databaseReference.child("Female").child(Objects.requireNonNull(Objects.requireNonNull(FirebaseAuth.getInstance()
                                    .getCurrentUser()).getPhoneNumber())).setValue(transfer).addOnCompleteListener(new OnCompleteListener<Void>() {

                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {

                                        Toast.makeText(getApplication(), "Upload Successful", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(EditDetails.this, TabsActivity.class );
                                        startActivity(intent);
                                        finish();
                                    } else {
                                        Toast.makeText(getApplication(), "Upload Again", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                        }
                    });
                }else {
                    Toast.makeText(getApplication(), "Try uploading again", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
