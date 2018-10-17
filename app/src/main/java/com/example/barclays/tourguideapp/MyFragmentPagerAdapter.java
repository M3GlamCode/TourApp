package com.example.barclays.tourguideapp;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    public MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
               return new AboutFragment();

            case 1:
                return new AttractionFragment();

            case 2:
                return new HotelFragment();

            case 3:
                return new ClubFragment();

        }
        return null;
    }

    /**
     *
     * @return The number of fragments in the viewPager
     */
    @Override
    public int getCount() {
        return 4;
    }

    /**
     *
     * @param position Getting t position of the tabs
     * Setting the title of each tab according to position
     */
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
       switch (position){
           case 0:
               return "ABOUT";

           case 1:
               return "ATTRACTIONS";

           case 2:
               return "HOTELS";

           case 3:
               return "CLUBS";
       }
       return null;
    }

}//end og public class
