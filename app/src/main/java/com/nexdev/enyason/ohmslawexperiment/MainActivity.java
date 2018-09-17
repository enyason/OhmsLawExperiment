package com.nexdev.enyason.ohmslawexperiment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements CommunicatorOhmsLaw{


    TabLayout tabLayout;
    ViewPager viewPager;
    MyPagerAdapter pagerAdapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.vpPager);
        pagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);

        tabLayout = findViewById(R.id.view_pager_tab);
        tabLayout.setupWithViewPager(viewPager);


    }

    @Override
    public void result(OhmsLawResult result) {

    }
}
