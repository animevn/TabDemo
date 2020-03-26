package com.haanhgs.app.uitabs;

import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tblMain)
    TabLayout tblMain;
    @BindView(R.id.vpMain)
    ViewPager vpMain;

    private void initTabs(){
        tblMain.addTab(tblMain.newTab().setText("Sports"));
        tblMain.addTab(tblMain.newTab().setText("Weathers"));
        tblMain.addTab(tblMain.newTab().setText("Wows"));
        tblMain.setTabGravity(TabLayout.GRAVITY_CENTER);
    }

    private void initViewPager(){
        //can use constant 1 instead of fucking long-and-dont-know-what-the-fuck-that-is
        Adapter adapter = new Adapter(getSupportFragmentManager(),
                FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, 3);
        vpMain.setAdapter(adapter);
        vpMain.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tblMain));
    }

    private void handleTabClick(){
        tblMain.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vpMain.setCurrentItem(tab.getPosition(), true);
            }
            @Override public void onTabUnselected(TabLayout.Tab tab) {}
            @Override public void onTabReselected(TabLayout.Tab tab) {}
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initTabs();
        initViewPager();
        handleTabClick();
    }
}
