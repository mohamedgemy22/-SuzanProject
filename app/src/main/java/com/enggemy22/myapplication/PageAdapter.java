package com.enggemy22.myapplication;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


public class PageAdapter extends FragmentPagerAdapter {
    private int noTabs;
    public PageAdapter(@NonNull FragmentManager fm, int behavior, int noTabs) {
        super(fm, behavior);
        this.noTabs=noTabs;
    }

    public PageAdapter(FragmentManager fm, int tabCount) {
        super(fm,tabCount);
        this.noTabs=tabCount;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new SociaFragment() ;
            case 1:
                return new phonesFragment();
            case 2:
                return new serviceFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return noTabs;
    }
}
