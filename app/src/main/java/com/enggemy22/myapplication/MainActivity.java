package com.enggemy22.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class MainActivity extends AppCompatActivity {
private Button mbtn_order;
private Button mbtn__connect;
private ImageView imageDrawer;
private ImageView mAccountPrivacy;
private ImageView mVedio;
private ImageView minfo;
private ImageView mCansel;
private DrawerLayout mLayout;
private LinearLayout mLinearLayout;
private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniate();

        imageDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mLayout.isDrawerOpen(Gravity.LEFT)){
                    mLayout.closeDrawer(Gravity.LEFT);
                }else{
                    mLayout.openDrawer(Gravity.LEFT);
                }

            }
        });
        mbtn_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,OrderActivity.class);
                startActivity(intent);
                finish();
            }
        });

        mbtn__connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              Intent intent= new Intent(MainActivity.this,Comunication.class);
              startActivity(intent);
              finish();
            }
        });

        mLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    FragmentManager manager = getSupportFragmentManager();
                    manager.beginTransaction().replace(R.id.pageContent, new account()).commit();
                    mLayout.closeDrawers();

            }
        });



    }

    private void iniate() {
        mbtn__connect= findViewById(R.id.connect);
        mbtn_order=findViewById(R.id.order);
        imageDrawer= findViewById(R.id.information);
        mLayout=findViewById(R.id.drawer);
        mAccountPrivacy=findViewById(R.id.accountPrivacy);
        mVedio=findViewById(R.id.play_vedio);
        minfo=findViewById(R.id.inforrrrr);
        mCansel=findViewById(R.id.close);
        mLinearLayout=findViewById(R.id.accountPrivacyLiniear);
        preferences= new SharedPreferences(getApplicationContext());
    }

}
