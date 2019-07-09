package gotopark.com.SAlotto;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.Objects;

import gotopark.com.SAlotto.database.DatabaseHelper;


public class MainActivity extends AppCompatActivity {

    @SuppressLint("StaticFieldLeak")
    public static DatabaseHelper db;

    private static final String TAG = "MainActivity";

    @SuppressLint("StaticFieldLeak")
    public static Context CONTEXT;
    BackProcessHandler backHandler;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        CONTEXT = this;
        db = new DatabaseHelper(this);

        backHandler = new BackProcessHandler(this);
        SectionsPageAdapter mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        ViewPager mViewPager = findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);


//TAP 맨위에 탭 아이콘  -->
        Objects.requireNonNull(tabLayout.getTabAt(0)).setIcon(R.drawable.dot1pic);
        Objects.requireNonNull(tabLayout.getTabAt(1)).setIcon(R.drawable.dot2pic);
        Objects.requireNonNull(tabLayout.getTabAt(2)).setIcon(R.drawable.dot3pic);
//TAP 맨위에 탭 아이콘  <---
        mViewPager.setOffscreenPageLimit(3);


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavView_Bar);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.ic_arrow:

                        break;

                    case R.id.ic_android:
                        Intent intent1 = new Intent(MainActivity.this, ActivityOne.class);
                        startActivity(intent1);
                        break;

                    case R.id.ic_books:
                        Intent intent2 = new Intent(MainActivity.this, ActivityTwo.class);
                        startActivity(intent2);
                        break;

                    case R.id.ic_center_focus:
                        Intent intent3 = new Intent(MainActivity.this, ActivityThree.class);
                        startActivity(intent3);
                        break;

                    case R.id.ic_backup:
                        Intent intent4 = new Intent(MainActivity.this, ActivityFour.class);
                        startActivity(intent4);
                        break;
                }


                return false;
            }
        });

        Admob_is();
        BackProcessHandler.AnRate();

    }

    public void Admob_is() {

        // admob
        AdView mAdView = findViewById(R.id.adView);
        MobileAds.initialize(getApplicationContext(), String.valueOf(R.string.google_adsene_id));
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

    }

    private void setupViewPager(ViewPager viewPager) {
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new Tab1Fragment());
        adapter.addFragment(new Tab2Fragment());
        adapter.addFragment(new Tab3Fragment());
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        BackProcessHandler.onBackPressed();
    }

    @Override
    protected void onStart() {
        super.onStart();

        Jsoup_Lotto jsoup_lotto = new Jsoup_Lotto();
        jsoup_lotto.execute();

    }
}
