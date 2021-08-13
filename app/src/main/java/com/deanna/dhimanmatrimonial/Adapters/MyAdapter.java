package com.deanna.dhimanmatrimonial.Adapters;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.deanna.dhimanmatrimonial.Fragments.Female;
import com.deanna.dhimanmatrimonial.Fragments.Male;
import com.deanna.dhimanmatrimonial.Fragments.MyProfile;

public class MyAdapter extends FragmentPagerAdapter {

    private Context myContext;
    int totalTabs;

    public MyAdapter(Context context, FragmentManager fm, int totalTabs) {
        super(fm);
        myContext = context;
        this.totalTabs = totalTabs;
    }

    // this is for fragment tabs
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Male male=new Male();
                return male;

            case 1:
                Female female=new Female();
                return female;
            case 2:
                MyProfile profile=new MyProfile();
                return profile;
            default:
                return null;
        }
    }
    // this counts total number of tabs
    @Override
    public int getCount() {
        return totalTabs;
    }
}
