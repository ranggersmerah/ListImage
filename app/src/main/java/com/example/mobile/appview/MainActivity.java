package com.example.mobile.appview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mobile.appview.activity.LoginActivity;
import com.example.mobile.appview.fragment.FragmentAdapter;
import com.example.mobile.appview.fragment.Home;
import com.example.mobile.appview.fragment.Profile;
import com.example.mobile.appview.utils.ConfigStorage;
import com.google.android.material.tabs.TabLayout;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private static final int TAG_LOGIN =123;
    ConfigStorage cfg;

    TabLayout tabLayout;
    ViewPager VpMain;
    private final int[] NavIcon = {
            R.drawable.ic_un_home,
            R.drawable.ic_un_person
    };

    private final int[] NavLabels = {
            R.string.home,
            R.string.profile
    };

    private final int[] NavIconActive = {
            R.drawable.ic_home,
            R.drawable.ic_person
    };

    Home home;
    Profile profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cfg =  new ConfigStorage(this);
        if (cfg.isNotLogin()){
            Intent i = new Intent();
            i.setClass(this, LoginActivity.class);
            startActivityForResult(i,TAG_LOGIN);
        }

        InitView();

    }

    private void InitView(){
        VpMain = findViewById(R.id.vp_main);
        tabLayout = findViewById(R.id.main_tabs);
        tabLayout.setupWithViewPager(VpMain);
        setupViewPager(VpMain);

        // loop through all navigation tabs
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            // inflate the Parent LinearLayout Container for the tab
            // from the layout nav_tab.xml file that we created 'R.layout.nav_tab
            @SuppressLint("InflateParams") LinearLayout tab = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.nav_tab, null);

            // get child TextView and ImageView from this layout for the icon and label
            TextView tab_label = tab.findViewById(R.id.nav_label);
            ImageView tab_icon = tab.findViewById(R.id.nav_icon);

            // set the label text by getting the actual string value by its id
            // by getting the actual resource value `getResources().getString(string_id)`
            tab_label.setText(getResources().getString(NavLabels[i]));

            // set the home to be active at first
            if (i == 0) {
                tab_label.setTextColor(getResources().getColor(R.color.colorPrimary));
                tab_icon.setImageResource(NavIconActive[i]);
            } else {
                tab_icon.setImageResource(NavIcon[i]);
            }

            // finally publish this custom view to navigation tab
            Objects.requireNonNull(tabLayout.getTabAt(i)).setCustomView(tab);
        }

        tabLayout.setOnTabSelectedListener(
                new TabLayout.ViewPagerOnTabSelectedListener(VpMain) {

                    @Override
                    public void onTabSelected(@NonNull TabLayout.Tab tab) {
                        super.onTabSelected(tab);

                        // 1. get the custom View you've added
                        View tabView = tab.getCustomView();

                        // get inflated children Views the icon and the label by their id
                        assert tabView != null;
                        TextView tab_label = tabView.findViewById(R.id.nav_label);
                        ImageView tab_icon = tabView.findViewById(R.id.nav_icon);

                        // change the label color, by getting the color resource value
                        tab_label.setTextColor(getResources().getColor(R.color.colorPrimary));
                        // change the image Resource
                        // i defined all icons in an array ordered in order of tabs appearances
                        // call tab.getPosition() to get active tab index.
                        tab_icon.setImageResource(NavIconActive[tab.getPosition()]);
                    }

                    // do as the above the opposite way to reset tab when state is changed
                    // as it not the active one any more
                    @Override
                    public void onTabUnselected(TabLayout.Tab tab) {
                        super.onTabUnselected(tab);
                        View tabView = tab.getCustomView();
                        assert tabView != null;
                        TextView tab_label = tabView.findViewById(R.id.nav_label);
                        ImageView tab_icon = tabView.findViewById(R.id.nav_icon);

                        // back to the black color
                        tab_label.setTextColor(getResources().getColor(R.color.hidden_text));
                        // and the icon resouce to the old black image
                        // also via array that holds the icon resources in order
                        // and get the one of this tab's position
                        tab_icon.setImageResource(NavIcon[tab.getPosition()]);
                    }

                    @Override
                    public void onTabReselected(TabLayout.Tab tab) {
                        super.onTabReselected(tab);
                    }
                }
        );

    }

    private void setupViewPager(ViewPager viewPager) {
        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager());

        if (home == null) {
            home = new Home();
        }

        if (profile == null) {
            profile = new Profile();
        }

        adapter.addFragment(home, "");
        adapter.addFragment(profile, "");

        viewPager.setAdapter(adapter);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == TAG_LOGIN){
            if (resultCode == RESULT_OK){

            }else if (resultCode == RESULT_CANCELED){
                finish();
            }
        }
    }
}