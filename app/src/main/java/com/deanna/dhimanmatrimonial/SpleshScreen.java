package com.deanna.dhimanmatrimonial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;

public class SpleshScreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Fullscreen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splesh_screen);


        new Thread(){
            @Override
            public void run() {

                try {

                    Thread.sleep(4900);
//                    flower.setVisibility(View.INVISIBLE);
                    if (FirebaseAuth.getInstance().getCurrentUser()==null){
                        startActivity(new Intent(SpleshScreen.this, EntermobileNumber.class));
                        finish();
                    }
                    else {
                        startActivity(new Intent(SpleshScreen.this, TabsActivity.class));
                        finish();
                    }

                }catch (Exception e){

                }
            }
        }.start();


    }
}
