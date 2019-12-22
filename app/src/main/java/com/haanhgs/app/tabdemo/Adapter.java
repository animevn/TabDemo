package com.haanhgs.app.tabdemo;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class Adapter extends FragmentStatePagerAdapter {

    private int numbOfTab;

    public Adapter(@NonNull FragmentManager fm, int behavior, int numbOfTab) {
        super(fm, behavior);
        this.numbOfTab = numbOfTab;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new Tab1();
            case 1: return new Tab2();
            case 2: return new Tab3();
            default: return new Tab1();
        }
    }

    @Override
    public int getCount() {
        return numbOfTab;
    }
}
