package com.alexistdev.daihatsu;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.alexistdev.daihatsu.fragment.akun_fragment;
import com.alexistdev.daihatsu.fragment.home_fragment;
import com.alexistdev.daihatsu.fragment.pesan_fragment;
import com.alexistdev.daihatsu.fragment.riwayat_fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadFragment(new home_fragment());
        /* Mengatur Menu bottom bar */
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomMenu);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            Fragment fragment = null;
            switch (item.getItemId()){
                case R.id.home_menu:
                    fragment = new home_fragment();
                    break;
                case R.id.history_menu:
                    fragment = new riwayat_fragment();
                    break;
                case R.id.inbox_menu:
                    fragment = new pesan_fragment();
                    break;
                default:
                    fragment = new akun_fragment();
            }
            return loadFragment(fragment);
        });
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fl_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}