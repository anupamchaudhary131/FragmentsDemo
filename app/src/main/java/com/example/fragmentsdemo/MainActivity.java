package com.example.fragmentsdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnAFrag, btnBFrag, btnCFrag;
    int flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAFrag = findViewById(R.id.btnAFrag);
        btnBFrag = findViewById(R.id.btnBFrag);
        btnCFrag = findViewById(R.id.btnCFrag);

        // default fragment
        loadFragment(new BFragment() , 0);

        btnAFrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                loadFragment(AFragment.getInstance("Ram",1), 1);


            }
        });

        btnBFrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                loadFragment(new BFragment(), 1);
            }
        });


        btnCFrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                loadFragment(new CFragment(), 1);
            }
        });
    }


    public void loadFragment(Fragment fragment, int flag)
    {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

/*      To set the arguments universal in all activity.

        Bundle bundle = new Bundle();
        bundle.putString("arg1", "Raman");
        bundle.putInt("arg2", 7);

        fragment.setArguments(bundle); */

        if(flag == 0) {
            ft.add(R.id.container, fragment);
        }
        else{
            ft.replace(R.id.container, fragment);
        }

        ft.addToBackStack(null);

        ft.commit();
    }
}