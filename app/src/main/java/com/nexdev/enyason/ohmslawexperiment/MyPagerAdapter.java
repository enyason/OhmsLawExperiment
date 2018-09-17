package com.nexdev.enyason.ohmslawexperiment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by enyason on 9/17/18.
 */

public class MyPagerAdapter extends FragmentStatePagerAdapter{

    private final CharSequence[] title = {"Experiment","Result"};

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new FragmentOhmsLawExperiment();
            case 1:
                return new FragmentOhmsLawResult();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }

}
