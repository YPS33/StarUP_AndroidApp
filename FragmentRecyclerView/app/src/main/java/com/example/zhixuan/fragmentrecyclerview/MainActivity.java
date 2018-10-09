package com.example.zhixuan.fragmentrecyclerview;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
       
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment fragment;
            switch (menuItem.getItemId()){
                default:
                    fragment = new HomeFragment();
                    break;
                case R.id.itemMine:
                    fragment = new MineFragment();
                    break;
                case R.id.itemWorks:
                    fragment = new WorksFragment();
                    break;
                case R.id.itemRecruit:
                    fragment = new RecruitFragment();
                    break;
                case R.id.itemMall:
                    fragment = new MallFragment();
                    break;

            }
            menuItem.setChecked(true);
            changeFragment(fragment);
            setTitle(menuItem.getTitle());
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
        initContent();
    }

    private void initContent() {
        bottomNavigationView.setSelectedItemId(R.id.itemHome);
    }

    private void changeFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content,fragment);
        fragmentTransaction.commit();

    }
    

}
