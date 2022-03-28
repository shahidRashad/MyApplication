package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class TabsAdapter extends FragmentStatePagerAdapter {
    int NoofTabs;
    public TabsAdapter(@NonNull FragmentManager fm, int NoofTabs) {
        super(fm);
        this.NoofTabs = NoofTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                FragmentHome home = new FragmentHome();
                return home;
            case 1:
                FragmentContact contact = new FragmentContact();
                return contact;
            case 2:
                FragmentAbout about = new FragmentAbout();
                return about;
            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        return NoofTabs;
    }
}
