package com.pinal.practicaltaskandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.pinal.practicaltaskandroid.Model.ShopByCategory;
import com.pinal.practicaltaskandroid.Model.ShopByFabric;
import com.pinal.practicaltaskandroid.Model.StickyMenu;
import com.pinal.practicaltaskandroid.adapter.RecShoCatAdapter;
import com.pinal.practicaltaskandroid.adapter.RecShoFabAdapter;
import com.pinal.practicaltaskandroid.adapter.RecTop1Adapter;
import com.pinal.practicaltaskandroid.fragment.CategoryFragment;
import com.pinal.practicaltaskandroid.fragment.HomeFragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.other_layout);

        HomeFragment fragment1 = new HomeFragment();
        FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
        fragmentTransaction1.replace(R.id.frame1, fragment1);
        fragmentTransaction1.commit();

        bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(selectedListener);
        bottomNavigationView.setSelectedItemId(R.id.menu_recent);

    }


    private BottomNavigationView.OnNavigationItemSelectedListener selectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.menu_recent:
                    HomeFragment fragment1 = new HomeFragment();
                    FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction1.replace(R.id.frame1, fragment1);
                    fragmentTransaction1.commit();
                    return true;
                case R.id.menu_files:
                    CategoryFragment fragment2 = new CategoryFragment();
                    FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction2.replace(R.id.frame1, fragment2);
                    fragmentTransaction2.commit();
                    return true;
                case R.id.menu_bookmark:
                    return true;

                case R.id.sale:
                    return true;
            }
            return false;
        }
    };


}