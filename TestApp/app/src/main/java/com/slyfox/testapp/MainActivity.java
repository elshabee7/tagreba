package com.slyfox.testapp;

import android.support.annotation.IdRes;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;


public class MainActivity extends AppCompatActivity implements MainListener {
//public class MainActivity extends AppCompatActivity{

    private LightFragment lightFragment;
    private SoundFragment soundFragment;
    private VideoFragment videoFragment;
    private ProfileFragment profileFragment;
    private Fragment selectedFragment;
    private BottomBar bottomBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);https://www.ei.tum.de/fileadmin/tueifei/www/Studium_Studienfuehrer/Studienfuehrer_BScEI_WS1617.pdf

        //Fragments
        lightFragment = new LightFragment();
        soundFragment = new SoundFragment();
        videoFragment = new VideoFragment();
        profileFragment = new ProfileFragment();
        selectedFragment = videoFragment;


        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frame_layout, lightFragment).hide(lightFragment);
        transaction.add(R.id.frame_layout, soundFragment).hide(soundFragment);
        transaction.add(R.id.frame_layout, videoFragment).hide(videoFragment);
        transaction.add(R.id.frame_layout, profileFragment).hide(profileFragment);
        transaction.commit();

        //Bottombar
        bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        bottomBar.setDefaultTabPosition(2);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {

                if (tabId == R.id.tab_sound) {
                    changeFragment(soundFragment);
                }

                else if (tabId == R.id.tab_light) {
                    changeFragment(lightFragment);
                }
                else if (tabId == R.id.tab_dashboard){
                    changeFragment(null);
                }
                else if (tabId == R.id.tab_video){
                    changeFragment(videoFragment);
                }
                else if (tabId == R.id.tab_profile){
                    changeFragment(profileFragment);
                }

            }
        });


        FloatingActionButton FAB = (FloatingActionButton) findViewById(R.id.fab);
        FAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomBar.selectTabAtPosition(2);

            }
        });
    }

    private void changeFragment(Fragment toShowFragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.hide(selectedFragment);
        if(toShowFragment != null) {
            transaction.show(toShowFragment);
            selectedFragment = toShowFragment;
        }
        transaction.commit();
    }


    @Override
    public void changeColor(int num) {
    }

    @Override
    public void changeColor2(int num) {
    }
}
