package com.example.fragmentcommunication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements FragmentA.MyFragmentAListener, FragmentB.MyFragmentBListener{

    private FragmentA fa;
    private FragmentB fb;
    private FragmentManager fm;
    private FragmentTransaction ft;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fa = new FragmentA();
        fb = new FragmentB();

        fm = getSupportFragmentManager();

        ft = fm.beginTransaction();

        ft.replace(R.id.containerA, fa);
        ft.replace(R.id.containerB, fb);

        ft.commit();

    }

    @Override
    public void onInputASent(CharSequence c) {
        fb.updateEditTextofFragmentB(c);
    }

    @Override
    public void onInputBSent(CharSequence c) {
        fa.updateEditTextofFragmentA(c);
    }

    public void removefragment_a(View view) {
        getSupportFragmentManager().beginTransaction().remove(fa).commit();
    }

    public void removefragment_b(View view) {
        getSupportFragmentManager().beginTransaction().remove(fb).commit();
    }

    public void addfragment_a(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.containerA, fa).commit();
    }

    public void addfragment_b(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.containerB, fb).commit();
    }
}