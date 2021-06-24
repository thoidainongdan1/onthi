package com.example.onthi.fragments;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class FragmentViewPagerAdapter extends FragmentStatePagerAdapter {

    public FragmentViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0: return new StudentFragment();
            case 1: return new ClassroomFragment();
            default: return new StudentFragment();
        }
    }

    @Override
    public int getCount() {return 2;}

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Sinh viên";
            case 1:
                return "Lớp";
            default:
                return "Sinh viên";
        }
    }
}
