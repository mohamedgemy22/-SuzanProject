package com.enggemy22.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.google.android.material.tabs.TabLayout;

public class Comunication extends AppCompatActivity {
private TabLayout mTabLayout;
private ViewPager mViewPager;
private PageAdapter adapter;
private LinearLayout mLayout;
private ImageView imageViewback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comunication);
initiate();
tabLayout();
imageViewback.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent= new Intent(Comunication.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
});
    }

    private void tabLayout() {
       adapter= new PageAdapter(getSupportFragmentManager(),mTabLayout.getTabCount());
       mViewPager.setAdapter(adapter);
       mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
           @Override
           public void onTabSelected(TabLayout.Tab tab) {
              int postion= tab.getPosition();
              mViewPager.setCurrentItem(postion);
              switch (postion)
              {
                  case 0:
                      FragmentManager manager= getSupportFragmentManager();
                      manager.beginTransaction().replace(R.id.contain,new SociaFragment()).commit();
                      break;
                  case 1:
                      FragmentManager manager1= getSupportFragmentManager();
                      manager1.beginTransaction().replace(R.id.contain,new phonesFragment()).commit();
                      break;
                  case 2:
                      FragmentManager manager2=getSupportFragmentManager();
                      manager2.beginTransaction().replace(R.id.contain,new serviceFragment()).commit();
                      break;
              }

           }

           @Override
           public void onTabUnselected(TabLayout.Tab tab) {

           }

           @Override
           public void onTabReselected(TabLayout.Tab tab) {

           }
       });
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
    }

    private void initiate() {
        mTabLayout= findViewById(R.id.tablayout);
        mViewPager =findViewById(R.id.viewbager);
        mLayout= findViewById(R.id.container);
        imageViewback= findViewById(R.id.backtomain);
    }


}
