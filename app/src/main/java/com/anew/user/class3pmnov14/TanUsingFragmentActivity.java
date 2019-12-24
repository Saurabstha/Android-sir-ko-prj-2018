package com.anew.user.class3pmnov14;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.anew.user.class3pmnov14.fragments.BottomFragment;
import com.anew.user.class3pmnov14.fragments.TopFragment;

public class TanUsingFragmentActivity extends AppCompatActivity {
    TextView tab1, tab2, tab3;
    ViewPager pager;
    //FrameLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tan_using_fragment);
        pager = findViewById(R.id.container);
        tab1 = findViewById(R.id.tab1);
        tab2 = findViewById(R.id.tab2);
        tab3 = findViewById(R.id.tab3);
        //container=findViewById(R.id.con)
        tab1.setOnClickListener(tabClickListener);
        tab2.setOnClickListener(tabClickListener);
        tab3.setOnClickListener(tabClickListener);

        //getSupportFragmentManager().beginTransaction().replace(R.id.container, new TopFragment()).commit();
        tab1.setBackgroundColor(Color.parseColor("#ccbbaa"));
        pager.setAdapter(new ViewPagerkoAdapter(getSupportFragmentManager()));
        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    tab1.setBackgroundColor(Color.parseColor("#ccbbaa"));

                } else if (position == 1) {
                    tab2.setBackgroundColor(Color.parseColor("#ccbbaa"));


                } else if (position == 2) {
                    tab3.setBackgroundColor(Color.parseColor("#ccbbaa"));


                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    public View.OnClickListener tabClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            tab1.setBackgroundColor(Color.parseColor("#aabbcc"));
            tab2.setBackgroundColor(Color.parseColor("#aabbcc"));
            tab3.setBackgroundColor(Color.parseColor("#aabbcc"));

            if (view.getId() == R.id.tab1) {
                tab1.setBackgroundColor(Color.parseColor("#ccbbaa"));

                //getSupportFragmentManager().beginTransaction().replace(R.id.container, new TopFragment()).commit();
                pager.setCurrentItem(0);
            } else if (view.getId() == R.id.tab2) {
                tab2.setBackgroundColor(Color.parseColor("#ccbbaa"));

                //getSupportFragmentManager().beginTransaction().replace(R.id.container, new BottomFragment()).commit();
                pager.setCurrentItem(1);

            } else if (view.getId() == R.id.tab3) {
                tab3.setBackgroundColor(Color.parseColor("#ccbbaa"));

                //getSupportFragmentManager().beginTransaction().replace(R.id.container, new TopFragment()).commit();
                pager.setCurrentItem(2);

            }
        }
    };

    public class ViewPagerkoAdapter extends FragmentPagerAdapter {
        public ViewPagerkoAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return new TopFragment();
            } else if (position == 1) {
                return new BottomFragment();
            }
            return new TopFragment();
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}
