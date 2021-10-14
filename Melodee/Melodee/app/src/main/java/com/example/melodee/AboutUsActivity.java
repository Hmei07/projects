package com.example.melodee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class AboutUsActivity extends AppCompatActivity {

    private TextView pageName, username;
    private ImageButton homeBtn, albumBtn, aboutUsBtn, logOutBtn;
    TabLayout tabLayout;
    ViewPager viewPager;
    TabItem tab1, tab2;
    PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        init();

        String pageNameIntent = getIntent().getStringExtra("PAGENAME");
        pageName.setText(pageNameIntent);
        String usernameIntent = getIntent().getStringExtra("USERNAME");
        username.setText("Welcome, " + usernameIntent);

        pagerAdapter = new PageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                pagerAdapter.notifyDataSetChanged();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }

    private void init(){
        this.homeBtn = findViewById(R.id.homeBtn);
        this.albumBtn = findViewById(R.id.albumBtn);
        this.aboutUsBtn = findViewById(R.id.aboutUsBtn);
        this.logOutBtn = findViewById(R.id.logOutBtn);
        pageName = findViewById(R.id.title);
        username = findViewById(R.id.welcome);

        this.tabLayout = findViewById(R.id.tabLayout);
        this.tab1 =  findViewById(R.id.tab1);
        this.tab2 = findViewById(R.id.tab2);
        this.viewPager = findViewById(R.id.viewPager);
    }

    public void goHome(View view) {
        Intent intentHome = new Intent(AboutUsActivity.this, HomeActivity.class);
        intentHome.putExtra("PAGENAME", "Home");
        intentHome.putExtra("USERNAME", getIntent().getStringExtra("USERNAME"));
        startActivity(intentHome);
    }

    public void goAlbum(View view) {
        Intent intentAlbum = new Intent(AboutUsActivity.this, AlbumActivity.class);
        intentAlbum.putExtra("PAGENAME", "Home");
        intentAlbum.putExtra("USERNAME", getIntent().getStringExtra("USERNAME"));
        startActivity(intentAlbum);
    }

    public void goAboutUs(View view) {

    }

    public void goLogOut(View view) {
        Intent intentHome = new Intent(AboutUsActivity.this, HomeActivity.class);
        startActivity(intentHome);
    }
}