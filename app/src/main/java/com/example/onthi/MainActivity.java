package com.example.onthi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.onthi.fragments.FragmentViewPagerAdapter;
import com.example.onthi.model.Student;
import com.example.onthi.model.StudentAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        FragmentViewPagerAdapter adapter = new FragmentViewPagerAdapter(getSupportFragmentManager(), 2);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

}