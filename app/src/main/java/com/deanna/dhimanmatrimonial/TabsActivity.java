package com.deanna.dhimanmatrimonial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.deanna.dhimanmatrimonial.Adapters.MyAdapter;
import com.deanna.dhimanmatrimonial.Fragments.Setting;
import com.google.android.material.tabs.TabLayout;

public class TabsActivity extends AppCompatActivity {

    private TabLayout tl;
    private ViewPager viewPager;
    protected MyAdapter myAdapter;
    private ImageButton imgButton;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs);

        //Id
        imgButton = findViewById(R.id.setting);
        imgButton.setEnabled(true);
        imgButton.setAlpha(250);

        imgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container,new Setting());
                fragmentTransaction.addToBackStack(null);
                imgButton.setEnabled(false);
                imgButton.setAlpha(18);
                fragmentTransaction.commit();
            }
        });


        idFind();

        tl.addTab(tl.newTab().setIcon(R.drawable.boy));
        tl.addTab(tl.newTab().setIcon(R.drawable.girl));
        tl.addTab(tl.newTab().setIcon(R.drawable.grayicon));

        tl.setTabGravity(TabLayout.GRAVITY_FILL);

        myAdapter = new MyAdapter(this, getSupportFragmentManager(), tl.getTabCount());
        viewPager.setAdapter(myAdapter);
        setListener();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        imgButton.setEnabled(true);
        imgButton.setAlpha(250);

    }

    private void idFind() {
        tl =  findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);
    }

    private void setListener() {
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tl));
        tl.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }


    }

