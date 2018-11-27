package com.wolfsoft.propertyui_hotelsearch;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import fragment.NearByFragment;


public class TabMainActivity extends AppCompatActivity {

    BottomBar bottomBar;
    FrameLayout frameLayout;
    private String token,versionName;
    private int versionCode;
    private boolean isCall = false;
    private String hasCard,hasActivated;
    private Dialog slideDialog;
    private TextView tvupdate;
    private TextView tvskip,tvupdatediscription;
    private boolean callUpdateservice;

    private int selectedTabId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frameLayout = (FrameLayout) findViewById(R.id.framelayout);


        bottomBar = (BottomBar) findViewById(R.id.bottombar);
        for (int i = 0; i < bottomBar.getTabCount(); i++) {
            bottomBar.getTabAtPosition(i).setGravity(Gravity.CENTER_VERTICAL);
        }
        frameLayout = (FrameLayout) findViewById(R.id.framelayout);


        isCall = true;

        /*roughike bottombar library code is here*/

        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {

            @Override
            public void onTabSelected(@IdRes int tabId) {
                //   Fragment fragment = null;

//                if (getIntent() != null && getIntent().hasExtra("check")) {
//                    tabId = getIntent().getIntExtra("check", -1);
//                }
                switch (tabId) {
                    case R.id.nearby:
                        selectedTabId =R.id.home;
                        replace_fragment(new NearByFragment());

                        break;
                    case R.id.discover:
                        selectedTabId =R.id.discover;
                        replace_fragment(new NearByFragment());

                        break;
                    case R.id.schedule:
                        selectedTabId =R.id.schedule;
                        replace_fragment(new NearByFragment());

                        break;

                    case R.id.favorite:
                        selectedTabId =R.id.favorite;
                        replace_fragment(new NearByFragment());
                        break;
                    case R.id.more:
                        selectedTabId =R.id.more;
                        replace_fragment(new NearByFragment());

                        break;

                }


            }
        });
    }


    public void replace_fragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.framelayout, fragment);
        transaction.commit();
    }



}
