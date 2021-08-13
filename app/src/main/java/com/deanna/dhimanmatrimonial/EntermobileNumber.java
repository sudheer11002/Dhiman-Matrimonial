package com.deanna.dhimanmatrimonial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.hbb20.CountryCodePicker;

public class EntermobileNumber extends AppCompatActivity {


    AppCompatEditText signup_edittext_mobilenumber;
    CountryCodePicker countryCodePicker;
    AppCompatButton send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Fullscreen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_entermobile_number);

        // ID's are here
        send=findViewById(R.id.sendotp);
        signup_edittext_mobilenumber=findViewById(R.id.mobNumber);
        countryCodePicker=findViewById(R.id.ccp);

        //Open OTP Activity
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                String signup_number;

                signup_number= signup_edittext_mobilenumber.getText().toString();


                if (signup_number.isEmpty()){
                    signup_edittext_mobilenumber.setError("Enter your mobile number");

                } else if (signup_number.length()<10){
                    signup_edittext_mobilenumber.setError("Enter valid number");

                } else{

                    Intent a = new Intent(EntermobileNumber.this, OTP.class);
                    a.putExtra("moblilenumber",countryCodePicker.getSelectedCountryCodeWithPlus()+signup_number );
                    startActivity(a);
                    finish();
                }
            }
        });

    }
}
